grammar Puzzle7;
list    : (prog NEWLINE)+ ;
prog    : name '(' weight ')' disc? ;
name    : ID ;
disc  :  '->' ( name ','? )+ ;
weight  : INT ;
ID      : [a-z] [a-z]* ;
INT     : [0-9]+ ;
NEWLINE : '\r' '\n' | '\n' | '\r';
WS      : [ \r\t\n]+ -> skip ;
ANY     : . ;
