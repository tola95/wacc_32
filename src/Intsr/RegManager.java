package Intsr;

import java.util.List;

public class RegManager {
	
	private List<Reg> regs = Reg.getRegs();
	
	//Returns next available register
	public Reg useRegs() {
		if (!hasNext()) {
			return Reg.R10;
		}
		Reg reg = regs.get(0);
		regs.remove(0);
		return reg;
	}
	
	public void refreshReg() {
		regs = Reg.getRegs();
	}
	
	public void addReg(Reg r) {
		regs.add(0, r);
	}
	
	public boolean hasNext() {
		return !regs.isEmpty();
	}
}
