grammar Puzzle18;

input
    : instr (NL instr)*
    ;
instr
    : snd | set | add | mul | mod | rcv | jgz
    ;
snd
    : 'snd' reg_or_number
    ;
set
    : 'set' REG reg_or_number
    ;
add
    : 'add' REG reg_or_number
    ;
mul
    : 'mul' REG reg_or_number
    ;
mod
    : 'mod' REG reg_or_number
    ;
rcv
    : 'rcv' REG
    ;
jgz
    : 'jgz' reg_or_number reg_or_number
    ;
reg_or_number
    : REG | INT
    ;
REG
    : 'a'..'z'
    ;
INT
    : '-'?[0-9]+
    ;
NL
    : '\r' '\n' | '\n' | '\r'
    ;
WS
    : [ \t]+ -> skip
    ;
