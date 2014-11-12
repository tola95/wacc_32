
public enum PrimType implements Type{

	INT, BOOL, CHAR, STRING, PAIR, IDENT, ERROR, SKIP, NULL, TRUE, FALSE
	   ,MUL , DIV , MOD , PLUS , MINUS , GRT , GRTEQ , SMT , SMTEQ , EQEQ , NOTEQ , AND , OR ;

	@Override
	public boolean isOfType(Type t) {
		return (t instanceof PrimType);
	}
	
}
