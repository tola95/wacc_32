
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
			Type thisType = this.type;
			return (t == thisType);
		}
		return false;
	}

}
