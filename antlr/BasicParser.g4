parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}

program : BEGIN (func)* stat END ;

func : type IDENT OPEN_PARENTHESES (paramlist)? CLOSE_PARENTHESES IS stat END ;

paramlist : param (COMMA param)* ;

param : type IDENT ;

stat : SKIP 
     | type IDENT EQ assignrhs
     | assignlhs EQ assignrhs
     | READ assignlhs
     | (FREE | RETURN | EXIT | PRINT | PRINTLN) expr 
     | IF expr THEN stat ELSE stat FI
     | WHILE expr DO stat DONE
     | BEGIN stat END
     | stat SEMICOLON stat
     ;

assignlhs : IDENT 
          | arrayelem
          | pairelem
          ;

assignrhs : expr
          | arrayliter
          | NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
          | pairelem
          | CALL IDENT OPEN_PARENTHESES (arglist)? CLOSE_PARENTHESES
          ;

arglist : expr (COMMA expr)* ;

pairelem : (FST | SND) expr ;

type : BASE_TYPE | arraytype |  pairtype ;

arraytype : BASE_TYPE OPEN_SQUAREB CLOSE_SQUAREB | arraytype OPEN_SQUAREB CLOSE_SQUAREB | pairtype OPEN_SQUAREB CLOSE_SQUAREB ;

pairtype : PAIR OPEN_PARENTHESES pairelemtype COMMA pairelemtype CLOSE_PARENTHESES ;

pairelemtype : BASE_TYPE | PAIR ;

expr: expr binaryOper expr
    | INT_LITER
    | OPEN_PARENTHESES expr CLOSE_PARENTHESES
    | BOOL_LITER
    | CHAR_LITER
    | STR_LITER
    | PAIR_LITER
    | IDENT
    | arrayelem
    | unaryoper expr
    | expr binaryOper expr
    | OPEN_PARENTHESES expr CLOSE_PARENTHESES
    ;

unaryoper : NOT | MINUS | LEN | ORD | CHR ;

binaryOper : MUL | DIV | MOD | PLUS | MINUS | GRT | GRTEQ | SMT | SMTEQ | EQEQ | NOTEQ | AND | OR ;

arrayelem : IDENT OPEN_SQUAREB expr CLOSE_SQUAREB ;

arrayliter : OPEN_SQUAREB arglist? CLOSE_SQUAREB ;

// EOF indicates that the program must consume to the end of the input.
prog: (expr)*  EOF ;
