import java.util.HashMap;
import java.util.Map;


public class SymbolTable {
	
//	private Map<String, BasicParser.TypeContext> encSymTable = new HashMap<String, BasicParser.TypeContext>();
	private SymbolTable encSymTable;
	private Map<String, Object> dict;
	
	public SymbolTable(SymbolTable st) {
		this.encSymTable = st;
		dict = new HashMap<String, Object>();
	}
	
	public void add(String s, Object t) {
		dict.put(s, t);
	}
	
	public Object lookupCurrLevelOnly(String name) {
		return dict.get(name);
	}
	
	public Object lookupCurrLevelAndEnclosingLevels(String name) {
		SymbolTable S = this;
		while (S != null) {
			Object obj = S.lookupCurrLevelOnly(name);
			if (obj != null) {
				return obj;
			} else {
				S = S.encSymTable;
			}
		}
		return null;
	}
	
	

}
