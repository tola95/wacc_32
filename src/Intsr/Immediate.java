package Intsr;

public class Immediate implements Operand{
	
	private String imm;
	
	public Immediate(String imm) {
		this.imm = imm;
	}
	
	@Override
	public String toString() {
		if (imm != null) {
			return imm;
		} else {
			return null;
		}

	}
	
	@Override
	public Types getType() {
		return null;
	}
}
