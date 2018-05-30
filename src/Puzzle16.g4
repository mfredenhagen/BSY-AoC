grammar Puzzle16;

dancemoves
    : move (',' move)*
    ;
move
    : spin | exchange | partner
    ;
spin
    : code INT
    ;
exchange
    : code intparams
    ;
partner
    : code nameparams
    ;
intparams
    : x '/' y
    ;
nameparams
    : a '/' b
    ;
code
    : NAME
    ;
x
    : INT
    ;
y
    : INT
    ;
a
    : NAME
    ;
b
    : NAME
    ;

NAME
    : 'a'..'p' | 's' | 'x'
    ;
INT
    : [0-9][0-5]?
    ;
WS
    : [ \r\t\n]+ -> skip
    ;
