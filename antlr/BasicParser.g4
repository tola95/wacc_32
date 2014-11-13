parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}

program : BEGIN (func)* stat END EOF;

func : type IDENT OPEN_PARENTHESES (paramlist)? CLOSE_PARENTHESES IS stat END ;

paramlist : param (COMMA param)* ;

param : type IDENT ;

stat : SKIP                                             #skip_Stat
     | type IDENT EQ assignrhs                          #identEq_Stat 
     | assignlhs EQ assignrhs                           #assignLhsRhs_Stat
     | READ assignlhs                                   #read_Stat
     | FREE expr                                        #free_Stat
     | RETURN expr                                      #return_Stat
     | EXIT expr                                        #exit_Stat
     | PRINT expr                                       #print_Stat
     | PRINTLN expr                                     #println_Stat
     | IF expr THEN stat ELSE stat FI                   #if_Stat
     | WHILE expr DO stat DONE                          #while_Stat
     | BEGIN stat END                                   #begin_Stat
     | stat SEMICOLON stat                              #semicolon_Stat
     ;

assignlhs : IDENT                                       #ident_AssignLhs
          | arrayelem                                   #arrayelem_AssignLhs
          | pairelem                                    #pairelem_AssignLhs
          ;

assignrhs : expr                                                        #exp_assignrhs
          | arrayliter                                                  #arrayLiter_assignrhs
          | NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES  #newPair_assignrhs
          | pairelem                                                    #pairElem_assignrhs
          | CALL IDENT OPEN_PARENTHESES (arglist)? CLOSE_PARENTHESES    #call_assignrhs
          ;

arglist : expr (COMMA expr)* ;

pairelem : (FST | SND) expr ;

basetype : INT                                   #int_baseType
         | BOOL                                  #bool_baseType
         | CHAR                                  #char_baseType
         | STRING                                #string_baseType
         ;

type : basetype                                
     | arraytype                                 
     | pairtype                                
     ;                            

arraytype : basetype OPEN_SQUAREB CLOSE_SQUAREB  
          | arraytype OPEN_SQUAREB CLOSE_SQUAREB    
          | pairtype OPEN_SQUAREB CLOSE_SQUAREB    
          ;

pairtype : PAIR OPEN_PARENTHESES pairelemtype COMMA pairelemtype CLOSE_PARENTHESES ;  

pairelemtype : basetype                             #baseType_pairElemType        
             | PAIR                                 #pair_pairElemType
             | arraytype                            #arrayType_pairElemType
             ;

expr : unaryoper expr                                 #unaryOper_Expr
     | OPEN_PARENTHESES expr CLOSE_PARENTHESES        #parenth_Expr
     | expr (MUL | DIV | MOD) expr                    #factor_Expr
     | expr (PLUS | MINUS) expr                       #term_Expr
     | expr (GRT | GRTEQ | SMT | SMTEQ) expr          #compare_Expr
     | expr (EQEQ | NOTEQ) expr                       #equality_Expr
     | expr AND expr                                  #and_Expr
     | expr OR expr                                   #or_Expr
     | INT_LITER                                      #intLiter_Expr
     | bool_Liter                                     #boolLiter_Expr
     | CHAR_LITER                                     #charLiter_Expr
     | STR_LITER                                      #strLiter_Expr
     | PAIR_LITER                                     #pairLiter_Expr
     | IDENT                                          #ident_Expr
     | arrayelem                                      #arrayElem_Expr
     ;

unaryoper : NOT | MINUS | LEN | ORD | CHR ;

bool_Liter : TRUE | FALSE ;

arrayelem : IDENT (OPEN_SQUAREB expr CLOSE_SQUAREB)+ ;

arrayliter : OPEN_SQUAREB arglist? CLOSE_SQUAREB ;

// EOF indicates that the program must consume to the end of the input.
prog: (expr)*  EOF ;
