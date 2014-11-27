package Intsr;

public class Address implements Operand{
	
	private Reg reg;
	private Immediate imm;
	
	public Address(Reg reg, Immediate imm) {
		this.reg = reg;
		this.imm = imm;
	}
	
	@Override
	public String toString() {
		if (imm == null) {
			return "[" + reg + "]";
		} else {
			return "[" + reg + ", #" + imm + "]";
		}
	}

}
