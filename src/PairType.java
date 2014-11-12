
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
		return (t instanceof PairType);
	}
	

}
