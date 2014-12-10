package WACCFrontEnd;


public enum PrimType implements Type{

	INT (null), BOOL(null), CHAR(null), STRING(null), ANY(null);
	
	private String i;
	
	PrimType(String i) {
		this.i = i;
	}
	
	public String retValue() {
		return i;
	}
	
	public void setValue(String str) {
		i = str; 
	}

	@Override
	public boolean isOfType(Type t) {
		if (this == ANY) {
			return true;
		}
		if (!(t instanceof PrimType)) {
			return false;
		}
		if (t instanceof ArrayType) {
			ArrayType at = (ArrayType) t;
			Type type = at.getType();
			 return type.isOfType(CHAR) && this == STRING;
		}
		PrimType type = (PrimType) t;
		return (type == this || type == PrimType.ANY);
	}

	@Override
	public int getSize() {
		int i = 0;
		switch (this) {
		case INT : i = 4; break;
		case BOOL : i = 1; break;
		case CHAR : i = 1; break;
		case STRING : i = 4; break;
		default:
			break;
		}
		return i;
	}
	
}
