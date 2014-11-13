
public enum PrimType implements Type{

	INT, BOOL, CHAR, STRING, ANY;

	@Override
	public boolean isOfType(Type t) {
		if (this == ANY) {
			return true;
		}
		if (!(t instanceof Type)) {
			return false;
		}
		PrimType type = (PrimType) t;
		return (type == this || type == PrimType.ANY);
	}
	
}
