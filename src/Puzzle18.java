import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Puzzle18 {

    public static void main(String[] args) {
        System.out.println("Puzzle 18 recovered frequencies: " + solve(args) + " and times program 1 send a value: " + solveA(args));
    }

    public static long solve(String[] input) {
        Duet duet = new Duet();
        return duet.play(parseInstr(input));
    }

    public static int solveA(String[] input) {
        try {
            return new QueueManager().play(parseInstr(input));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static List<Playable> parseInstr(String[] input) {
        String instructions = StringUtils.join(input, '\n');
        CharStream source = CharStreams.fromString(instructions);
        Puzzle18Lexer lexer = new Puzzle18Lexer(source);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Puzzle18Parser parser = new Puzzle18Parser(tokens);
        List<Playable> instrs = new ArrayList<>();
        new Puzzle18BaseVisitor<Void>() {

            private String getReg(TerminalNode node) {
                return node.getSymbol().getText();
            }

            private ReadVal getReadVal(Puzzle18Parser.Reg_or_numberContext regOrNumberContext) {
                if (regOrNumberContext.INT() != null) {
                    final Long val = Long.parseLong(regOrNumberContext.INT().getSymbol().getText());
                    return (duet) -> val;
                } else {
                    final String reg = getReg(regOrNumberContext.REG());
                    return (duet) -> duet.readRegister(reg);
                }
            }

            @Override
            public Void visitSnd(Puzzle18Parser.SndContext ctx) {
                instrs.add(new Snd(getReadVal(ctx.reg_or_number())));
                return super.visitSnd(ctx);
            }

            @Override
            public Void visitSet(Puzzle18Parser.SetContext ctx) {
                instrs.add(new Set(getReg(ctx.REG()), getReadVal(ctx.reg_or_number())));
                return super.visitSet(ctx);
            }

            @Override
            public Void visitAdd(Puzzle18Parser.AddContext ctx) {
                instrs.add(new Add(getReg(ctx.REG()), getReadVal(ctx.reg_or_number())));
                return super.visitAdd(ctx);
            }

            @Override
            public Void visitMul(Puzzle18Parser.MulContext ctx) {
                instrs.add(new Mul(getReg(ctx.REG()), getReadVal(ctx.reg_or_number())));
                return super.visitMul(ctx);
            }

            @Override
            public Void visitMod(Puzzle18Parser.ModContext ctx) {
                instrs.add(new Mod(getReg(ctx.REG()), getReadVal(ctx.reg_or_number())));
                return super.visitMod(ctx);
            }

            @Override
            public Void visitRcv(Puzzle18Parser.RcvContext ctx) {
                instrs.add(new Rcv(getReg(ctx.REG())));
                return super.visitRcv(ctx);
            }

            @Override
            public Void visitJgz(Puzzle18Parser.JgzContext ctx) {
                instrs.add(new Jgz(getReadVal(ctx.reg_or_number(0)), getReadVal(ctx.reg_or_number(1))));
                return super.visitJgz(ctx);
            }
        }.visit(parser.input());

        return instrs;
    }

    interface ReadVal {
        long read(Duet duet);
    }

    interface Playable {
        void apply(Duet duet);
    }

    static abstract class Instr implements Playable {
        private final ReadVal readVal;

        Instr(ReadVal readVal) {
            this.readVal = readVal;
        }

        public abstract void apply(Duet duet);

        ReadVal getReadVal() {
            return readVal;
        }
    }

    static abstract class BinaryInstr extends Instr {

        private final String target;

        BinaryInstr(String target, ReadVal readVal) {
            super(readVal);
            this.target = target;
        }

        String getTarget() {
            return target;
        }

    }

    static class Snd extends Instr {

        Snd(ReadVal val) {
            super(val);
        }

        @Override
        public void apply(Duet duet) {
            duet.snd(this);
        }
    }

    static class Set extends BinaryInstr {

        Set(String target, ReadVal readVal) {
            super(target, readVal);
        }

        @Override
        public void apply(Duet duet) {
            duet.writeRegister(getTarget(), getReadVal().read(duet));
        }
    }

    static class Add extends BinaryInstr {

        Add(String target, ReadVal readVal) {
            super(target, readVal);
        }

        @Override
        public void apply(Duet duet) {
            duet.writeRegister(getTarget(), duet.readRegister(getTarget()) + getReadVal().read(duet));
        }
    }

    static class Mul extends BinaryInstr {

        Mul(String target, ReadVal readVal) {
            super(target, readVal);
        }

        @Override
        public void apply(Duet duet) {
            long register = duet.readRegister(getTarget());
            long multiplier = getReadVal().read(duet);
            duet.writeRegister(getTarget(), register * multiplier);
        }
    }

    static class Mod extends BinaryInstr {

        Mod(String target, ReadVal readVal) {
            super(target, readVal);
        }

        @Override
        public void apply(Duet duet) {
            duet.writeRegister(getTarget(), duet.readRegister(getTarget()) % getReadVal().read(duet));
        }
    }

    static class Rcv implements Playable {

        private final String register;

        Rcv(String reg) {
            this.register = reg;
        }

        @Override
        public void apply(Duet duet) {
            duet.rcv(this);
        }

        String getRegister() {
            return register;
        }
    }

    static class Jgz extends Instr {

        private final ReadVal right;

        Jgz(ReadVal left, ReadVal right) {
            super(left);
            this.right = right;
        }

        @Override
        public void apply(Duet duet) {
            if (getReadVal().read(duet) > 0L) {
                duet.jump(right.read(duet));
            }
        }
    }

    static class Duet {

        private final Map<String, Long> register = new HashMap<>();
        int stackPointer = 0;
        private long note;
        private long recovered = -1;

        Duet() {
            super();
        }

        long readRegister(String name) {
            return register.containsKey(name) ? register.get(name) : 0;
        }

        void writeRegister(String name, long value) {
            register.put(name, value);
        }

        long play(final List<Playable> instrs) {
            while (notTerminated() && (stackPointer < instrs.size())) {
                instrs.get(stackPointer++).apply(this);
            }
            return recovered;
        }

        void snd(Snd snd) {
            this.note = snd.getReadVal().read(this);
        }

        void rcv(Rcv rcv) {
            if (0 != readRegister(rcv.getRegister())) {
                recovered = note;
            }
        }

        boolean notTerminated() {
            return recovered == -1;
        }

        void jump(long value) {
            stackPointer--; // reset stackpointer
            stackPointer += value; // and than jump
        }

        @Override
        public String toString() {
            return register.toString();
        }
    }

    static class QueueManager {
        private final BlockingQueue<OptionalLong> queue1 = new ArrayBlockingQueue<>(Integer.MAX_VALUE / 32);
        private final BlockingQueue<OptionalLong> queue2 = new ArrayBlockingQueue<>(Integer.MAX_VALUE / 32);
        private final Receiver receiver1 = new Receiver(queue1);
        private final Receiver receiver2 = new Receiver(queue2);
        private final DuetA duet1;
        private final DuetA duet2;
        private boolean terminated = false;
        private int duet2SendCounter = 0;

        QueueManager() {
            duet1 = new DuetA(this, 0, new Sender(queue1), receiver2);
            duet2 = new DuetA(this, 1, new Sender(queue2), receiver1);
        }

        private void checkForDeadlock() {
            if (receiver1.isBlocked() && receiver2.isBlocked()) {
                deadlockDetected();
            }
        }

        void terminate() {
            this.terminated = true;
        }

        boolean isTerminated() {
            return terminated;
        }

        private void deadlockDetected() {
            // other thread is receiving -> deadlock
            try {
                queue1.put(OptionalLong.empty());
                queue2.put(OptionalLong.empty());
            } catch (InterruptedException e) {
                terminate();
                Thread.currentThread().interrupt();
            }
        }

        int play(final List<Playable> instrs) throws InterruptedException {
            Thread t1 = new Thread(() -> duet1.play(instrs));
            Thread t2 = new Thread(() -> duet2.play(instrs));
            t1.setName(duet1.toString());
            t2.setName(duet2.toString());
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            return duet2SendCounter;
        }

        private void increaseSendCounter() {
            duet2SendCounter++;
        }

        static class DuetA extends Duet {

            private final QueueManager manager;
            private final int programId;
            private final Receiver receiver;
            private final Sender sender;

            DuetA(QueueManager manager, int p, Sender sender, Receiver receiver) {
                this.manager = manager;
                this.programId = p;
                this.writeRegister("p", programId);
                this.sender = sender;
                this.receiver = receiver;

            }

            @Override
            void rcv(Rcv rcv) {
                try {
                    receiver.next().ifPresentOrElse(
                            value -> writeRegister(rcv.getRegister(), value),
                            manager::terminate
                    );
                } catch (InterruptedException e) {
                    manager.terminate();
                }
            }

            @Override
            void snd(Snd snd) {
                long val = snd.getReadVal().read(this);
                if (programId == 1) manager.increaseSendCounter();
                try {
                    sender.send(val);
                } catch (InterruptedException e) {
                    manager.terminate();
                }
            }

            @Override
            boolean notTerminated() {
                return !manager.isTerminated();
            }

            @Override
            long play(final List<Playable> instrs) {
                while (notTerminated() && (stackPointer < instrs.size())) {
                    instrs.get(stackPointer++).apply(this);
                }
                return 0;
            }

            @Override
            public int hashCode() {
                return programId;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                DuetA duetA = (DuetA) o;

                return programId == duetA.programId;
            }

            @Override
            public String toString() {
                return "DuetA:  " + programId + " " + super.toString();
            }

        }

        class Receiver {
            private final BlockingQueue<OptionalLong> receiveQueue;
            private AtomicBoolean blocked = new AtomicBoolean(false);

            Receiver(BlockingQueue<OptionalLong> queue) {
                receiveQueue = queue;
            }

            OptionalLong next() throws InterruptedException {
                blocked.set(true);
                try {
                    checkForDeadlock();
                    OptionalLong result = receiveQueue.poll(5, TimeUnit.SECONDS);
                    return result == null ? OptionalLong.empty() : result;
                } finally {
                    blocked.set(false);
                }
            }

            boolean isBlocked() {
                return blocked.get() && receiveQueue.isEmpty();
            }
        }

        class Sender {
            private final BlockingQueue<OptionalLong> sendQueue;

            Sender(BlockingQueue<OptionalLong> queue) {
                this.sendQueue = queue;
            }

            void send(long value) throws InterruptedException {
                sendQueue.offer(OptionalLong.of(value), 5, TimeUnit.SECONDS);
            }
        }

    }
}
