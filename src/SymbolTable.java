import java.util.HashMap;

public class SymbolTable {
	SymbolTable symTable;
	HashMap<String, Type> dictionary;
	Type returnType;
	
	SymbolTable(SymbolTable st, Type t) {
		symTable = st;
		returnType = t;
		dictionary = new HashMap<String, Type>();
	}
	
	SymbolTable(SymbolTable st) {
		symTable = st;
		returnType = st.getReturnType();
		dictionary = new HashMap<String, Type>();
	}
	
	public void setReturnType(Type type) {
		returnType = type;
	}
	
	public Type getReturnType() {
		return returnType;
	}
	
	public SymbolTable getParent() {
		return symTable;
	}
	
	public void add(String str, Type obj) {
		dictionary.put(str, obj);
	}
	
	public Type lookUpCurrLevelOnly(String str) {
		return dictionary.get(str);
	}
	
	public Type lookUpCurrLevelAndEnclosingLevels(String str) {
		SymbolTable S = this;
		Type id;
		while (S != null) {
			id = S.lookUpCurrLevelOnly(str);
			if (id != null) {
				return id;
			}
			S = S.symTable;
		}
		return null;
	}
	
	public String printing() {
		return dictionary.toString();
	}

}
