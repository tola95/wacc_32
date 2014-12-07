package WACCFrontEnd;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SymbolTable {
	SymbolTable parent; //Parent SymbolTable
	Map<String, Type> dictionary = new LinkedHashMap<String, Type>(); //Dictionary of Strings to types
	public int totalScope = 0; 
	private Type returnType; //Return type of symbol table
	private List<SymbolTable> children = new ArrayList<>();

	SymbolTable(SymbolTable st, Type t) {
		parent = st;
		returnType = t;
		dictionary = new LinkedHashMap<String, Type>();
	}

	SymbolTable(SymbolTable st) {
		parent = st;
		returnType = st.getReturnType();
		dictionary = new LinkedHashMap<String, Type>();
	}

	public int getTotalScope() {
		return totalScope;
	}

	public void addChildren(SymbolTable child) {
		children.add(children.size(), child);
	}
	
	public void removeChild() {
		children.remove(0);
	}

	public List<SymbolTable> getChildren() {
		return children;
	}

	public void setReturnType(Type type) {
		returnType = type;
	}

	public Type getReturnType() {
		return returnType;
	}

	public SymbolTable getParent() {
		return parent;
	}

	public void add(String str, Type obj) {
		dictionary.put(str, obj);
	}
	
	public Map<String, Type> getDictionary() {
		return dictionary;
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
			S = S.parent;
		}
		return null;
	}

	public void calculateScope() {
		for (Type type : dictionary.values()) {
			totalScope += type.getSize();
		}
	}

	public int calculateOffset(String s) {
		int n = 0;
		SymbolTable st = this;
		while (st != null) {
			List<Map.Entry<String, Type>> list = new ArrayList<>(st.getDictionary().entrySet());
			for (int i = list.size() - 1; i >=0; i--) {
				Map.Entry<String, Type> entry = list.get(i);
				if (entry.getKey().equals(s)) {
					return n;
				}
				n += entry.getValue().getSize();
			}
//			for (Map.Entry<String, Type> entry : st.getDictionary().entrySet()) {
//				if (entry.getKey().equals(s)) {
//					return n;
//				}
//				n += entry.getValue().getSize();
//			}
			st = st.getParent();
		}
		return n;
	}

	public String printing() {
		return dictionary.toString();
	}

}
