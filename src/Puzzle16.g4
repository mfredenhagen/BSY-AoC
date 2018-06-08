grammar Puzzle16;

dancemoves
    : move (',' move)*
    ;
move
    : spin | exchange | partner
    ;
spin
    : 's' INT
    ;
exchange
    : 'x' x '/' y
    ;
partner
    : 'p' a '/' b
    ;
x
    : INT
    ;
y
    : INT
    ;
a
    : (NAME | 'p')
    ;
b
    : (NAME | 'p')
    ;

NAME
    : 'a'..'o'
    ;
INT
    : [0-9][0-5]?
    ;
WS
    : [ \r\t\n]+ -> skip
    ;
