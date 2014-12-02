package Intsr;

public class Address implements Operand{
	
	private Reg reg;
	private Immediate imm;
	
	public Address(Reg reg, Immediate imm) {
		this.reg = reg;
		this.imm = imm;
	}
	
	public Address(Reg reg, int imm) {
		this.reg = reg;
		if (imm == 0){
			this.imm = null;
		} else {
			this.imm = new Immediate(Integer.toString(imm));
		}	
	}
	
	@Override
	public String toString() {
		if (imm == null) {
			return "[" + reg + "]";
		} else {
			return "[" + reg + ", #" + imm + "]";
		}
	}

	@Override
	public Types getType() {
		return null;
	}

}
