import java.util.HashMap;

public class SymbolTable {
	SymbolTable symTable;
	HashMap<String, Type> dictionary;
	
	
	SymbolTable(SymbolTable st) {
		symTable = st;
		dictionary = new HashMap<String, Type>();
	}
	
	public void add(String str, Type type) {
		dictionary.put(str, type);
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

}
