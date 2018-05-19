grammar Puzzle12;
list    : (prog NEWLINE)+ ;
prog    : name pipes ;
name    : INT ;
pipes   :  '<->' ( name ','? )+ ;
INT     : [0-9]+ ;
NEWLINE : '\r' '\n' | '\n' | '\r';
WS      : [ \r\t\n]+ -> skip ;
ANY     : . ;
