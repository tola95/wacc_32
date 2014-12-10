package WACCFrontEnd;

public class Int implements Type {
	
	private int value;
	
	public Int(int value) {
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	@Override
	public boolean isOfType(Type t) {
		return (t instanceof Int || t == PrimType.ANY);
	}

	@Override
	public int getSize() {
		return 4;
	}

}
