
public class Function extends Identifier {
	
	private Type returnType;
	private Param[] paramlist;
	private int noOfParams;

	public Function(Type returnType, Param paramlist[], int noOfParams) {
		this.returnType = returnType;
		this.paramlist = paramlist;
		this.noOfParams = noOfParams;
	}

}
