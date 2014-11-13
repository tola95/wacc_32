
public class PairType implements Type {
	
	private Type fst;
	private Type snd;
	
	PairType(Type fst, Type snd) {
		this.fst = fst;
		this.snd = snd;
	}
	
	public Type getFst() {
		return fst;
	}
	
	public Type getSnd() {
		return snd;
	}

	@Override
	public boolean isOfType(Type t) {
		if (t instanceof PairType) {
			PairType pair = (PairType) t;
			if (this.getFst().isOfType(pair.getFst()) 
					&& this.getSnd().isOfType(pair.getSnd())) {
				return true;
			}
		}
		if (t instanceof PrimType) {
			return (t == PrimType.ANY);
		}
		return false;
	}
	

}
