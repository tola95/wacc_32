lexer grammar BasicLexer;

//binary operators 

DIV : '/' ;
MUL : '*' ;
MOD : '%' ;
PLUS : '+' ;
MINUS : '-' ;
GRT : '>' ;
GRTEQ : '>=' ;
SMT : '<' ;
SMTEQ : '<=' ;
EQEQ : '==' ;
NOTEQ : '!=' ;
AND : '&&' ;
OR : '||' ;
NOT : '!' ;
LEN : 'len' ;
ORD : 'ord' ;
CHR : 'chr' ;
WS : [ \t\n\r\ ] -> skip ;

fragment EOL : '\r'? '\n' ;

EQ : '=' ;
//brackets
OPEN_PARENTHESES : '(' ;
CLOSE_PARENTHESES : ')' ;
OPEN_SQUAREB : '[' ;
CLOSE_SQUAREB : ']' ;

//terminals
BEGIN : 'begin' ;
END : 'end' ;
SKIP : 'skip' ;
READ : 'read' ;
IS : 'is' ;
FREE : 'free' ;
RETURN : 'return' ;
EXIT : 'exit' ;
PRINT : 'print' ;
PRINTLN : 'println' ;
IF : 'if' ;
THEN : 'then' ;
ELSE : 'else' ;
FI : 'fi' ;
DO : 'do' ;
DONE : 'done' ;
SEMICOLON : ';' ;
COMMA : ',' ;
NEWPAIR : 'newpair' ;
CALL : 'call' ;
FST : 'fst' ;
SND : 'snd' ;
PAIR : 'pair' ;
NULL : 'null' ;
HASHTAG : '#' ;
QUOTATION : '"' ;
WHILE : 'while' ;


//bools
BOOL_LITER : 'true' | 'false' ;

//numbers
BASE_TYPE : 'int' | 'bool' | 'char' | 'string' ;
INT_LITER : ('+'|'-')?[0-9]+ ;
INTEGER : DIGIT+ ;
fragment CHARACTER : ~('/' | '`' | '"')+ | '\\' ;
CHAR_LITER : '\'' (CHARACTER|ESCAPED_CHAR) '\'' ;
STR_LITER : '\"' (CHARACTER|ESCAPED_CHAR)+ '\"' ;
fragment ESCAPED_CHAR: '\\0' | '\\b' | '\\t' | '\\n' | '\\f' | '\\r' | '\\' | '\\\\' | '\\\"' | '\\\'' ; 
IDENT : [_|a-z|A-Z][_|a-z|A-Z|DIGIT]* ;
fragment DIGIT : '0'..'9' ; 
PAIR_LITER : 'null' ;



