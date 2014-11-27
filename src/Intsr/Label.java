package Intsr;

public class Label implements Instruction{

	private String label;
	
	public Label(String label) {
		this.label = label;
	}
	
	@Override
	public String toString(){
		return label + ":\n";
	}
}
