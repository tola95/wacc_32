lexer grammar BasicLexer;

//binary operators
PLUS : '+' ;
MINUS : '-' ;
MUL : '*' ;
DIV : '/' ;
MOD : '%' ;
AND : '&&' ;
OR : '||' ;
GRT : '>' ;
SMT : '<' ;
GRTEQ : '>=' ;
SMTEQ : '<=' ;
NOTEQ : '!=' ;

//terminals
BEGIN : 'begin' ;
END : 'end' ;
IS : 'is' ;
READ : 'read' ;
FREE : 'free' ;
RETURN : 'return' ;
EXIT : 'exit' ;
PRINT : 'print' ;
PRINTLN : 'println' ;
IF : 'if' ;
THEN : 'then' ;
ELSE : 'else' ;
FI : 'fi' ;
DONE : 'done' ;
SEMICOLON : ';' ;
COMMA : ',' ;
NEWPAIR : 'newpair' ;
CALL : 'call' ;
FST : 'fst' ;
SND : 'snd' ;
INT : 'int' ;
BOOL : 'bool' ;
CHAR : 'char' ;
STRING : 'string' ;
PAIR : 'pair' ;
NULL : 'null' ;
HASHTAG : '#' ;
QUOTATION : '"' ;
SPACE : ' ' ;

//unary operators
NOT : '!' ;
ORD : 'ord' ;
CHR : 'chr' ;
LEN : 'len' ;

//brackets
OPEN_PARENTHESES : '(' ;
CLOSE_PARENTHESES : ')' ;
OPEN_SQUAREB : '[' ;
CLOSE_SQUAREB : ']' ;

//bools
TRUE : 'true' ;
FALSE : 'false' ;

//numbers
fragment DIGIT : '0'..'9' ; 

INTEGER : DIGIT+ ;
//CHARACTER : ~('\\'|'''|'"');




