package Intsr;


public class Data implements Instruction{
	
	private int i;
	private String str;
	
	//This class is very straightforward
	public Data(int i, String str) {
		this.i = i;
		this.str = str;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(Directives.WORD + " " + Integer.toString(i) + "\n");
		string.append(Directives.ASCII + " " + str.toString() + "\n");
		return string.toString();
	}
	

}
