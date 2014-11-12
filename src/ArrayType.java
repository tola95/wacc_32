
public class ArrayType implements Type{
	
	private int length;
	private Type type;
	
	ArrayType(int length, Type type) {
		this.length = length;
		this.type = type;
	}

	@Override
	public boolean isOfType(Type t) {
		return (t instanceof ArrayType);
	}

}
