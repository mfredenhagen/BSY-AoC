grammar Puzzle8;

prog    : instr (NEWLINE instr)* NEWLINE? EOF;
instr   : register op blocks condition ;
register: ID ;
op      : 'inc' | 'dec' ;
blocks   : INT ;
condition: 'if' register comp blocks ;
comp    : '>' | '<' | '>=' | '<=' | '==' | '!=' ;
ID      : [a-z] [a-z]* ;
INT     : '-'?[0-9]+ ;
NEWLINE : '\r' '\n' | '\n' | '\r';
WS      : [ \r\t\n]+ -> skip ;
ANY     : . ;
