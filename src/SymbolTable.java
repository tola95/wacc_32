import java.util.HashMap;

public class SymbolTable {
	SymbolTable symTable;
	HashMap<String, Type> dictionary;
	
	
	SymbolTable(SymbolTable st) {
		symTable = st;
		dictionary = new HashMap<String, Type>();
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
