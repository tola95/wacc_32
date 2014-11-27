package Intsr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ARMInstruction implements Instruction {

	private Instruc instr;
	List<Operand> operands = new ArrayList<Operand>();

	public ARMInstruction(Instruc instr, Operand... operands) {
		this.instr = instr;
		this.operands = Arrays.asList(operands);
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(instr);
		switch (instr) {
		case PUSH:
		case POP:
			string.append(" {" + printOperands() + "}");
			break;
		default:
			string.append(" " + printOperands());
		}
		return "\t" + string.toString() + "\n";
	}

	public String printOperands() {
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < operands.size(); i++) {
			if (i == operands.size() - 1) {
				string.append(operands.get(i));
			} else {
				string.append(operands.get(i) + ", ");
			}
		}
		return string.toString();
	}

}
