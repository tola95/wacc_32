package Intsr;

import java.util.List;

public class RegManager {
	
	private List<Reg> regs = Reg.getRegs();
	
	public Reg useRegs() {
		Reg reg = regs.get(0);
		regs.remove(0);
		return reg;
	}
	
	public void refreshReg() {
		regs = Reg.getRegs();
	}
}
