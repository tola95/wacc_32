package Intsr;

import java.util.ArrayList;
import java.util.List;

public enum Reg implements Operand{
	
	R0 ("r0"),
	R1 ("r1"),
	R2 ("r2"),
	R3 ("r3"),
	R4 ("r4"),
	R5 ("r5"),
	R6 ("r6"),
	R7 ("r7"),
	R8 ("r8"),
	R9 ("r9"),
	R10 ("r10"),
	R11 ("r11"),
	R12 ("r12"),
	SP ("sp"),
	LR ("lr"),
	PC ("pc")
	;

	private final String reg;
	private Types type = null;
	
	//Enum to represent the registers
	private Reg(String reg) {
		this.reg = reg;
	}
	
	public void setType(Types type) { 
		this.type = type;
	}
	
	@Override
	public Types getType() {
		return type;
	}
	
	//Geturns list of all registers
	public static List<Reg> getRegs() {
		List<Reg> regs = new ArrayList<>();
		for (Reg r : Reg.values()) {
			int i = r.ordinal();
			if (i > 3 && i < 11) {
				regs.add(r);
			}
		}
		return regs;
	}
	
	public String toString() {
		return reg;
	}
}
