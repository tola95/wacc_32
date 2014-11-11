import java.util.HashMap;

public class SymbolTable {
	SymbolTable symTable;
	HashMap<String, Identifier> dictionary;
	
	
	SymbolTable(SymbolTable st) {
		symTable = st;
		dictionary = new HashMap<String, Identifier>();
	}
	
	public void add(String str, Identifier obj) {
		dictionary.put(str, obj);
	}
	
	public Identifier lookUpCurrLevelOnly(String str) {
		return dictionary.get(str);
	}
	
	public Identifier lookUpCurrLevelAndEnclosingLevels(String str) {
		SymbolTable S = this;
		Identifier id;
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
