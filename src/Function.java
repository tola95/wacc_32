import java.util.List;


public class Function extends Identifier {
	
	private Type returnType;
	private List<Type> paramList;

	public Function(Type returnType, List<Type> paramList) {
		this.returnType = returnType;
		this.paramList = paramList;
	}
	
	public Type getReturnType() {
		return returnType;
	}
	
	public List<Type> getParamList() {
		return paramList;
	}

}
