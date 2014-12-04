package WACCFrontEnd;


public class ArrayType implements Type{
	
	private Type type;
	
	public ArrayType() {
		this.type = PrimType.ANY;
	}
	
	public ArrayType(Type t) {
		type = t;
	}
	
	public Type getType() {
		return type;
	}

	@Override
	public boolean isOfType(Type t) {
		if (t == PrimType.ANY) {
			return true;
		} 
		if (t instanceof ArrayType) {
			ArrayType type1 = (ArrayType) t;
			return (type1.getType().isOfType(type));
		}
		return (t.isOfType(PrimType.STRING) && this.getType().isOfType(PrimType.CHAR));
	}

	@Override
	public int getSize() {
		return 4;
	}
	
	@Override
	public String toString() {
		return "Array";
	}

}
