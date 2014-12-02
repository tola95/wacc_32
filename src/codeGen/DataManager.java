package codeGen;

import java.util.List;

public enum DataManager {

	STRING, INT, CHAR, BOOL;

	private static boolean nullAdded = false;
	private static boolean stringAdded = false;
	private static boolean intAdded = false;
	private static boolean charAdded = false;
	private static boolean boolAdded = false;

	public static void dataAdd(List<String> list, DataManager dm) {
		switch (dm) {
		case INT:
			if (!intAdded) {
				list.add("\"%d\\0\"");
			}
			intAdded = true;
			addNull(list);
			break;
		case STRING:
			if (!stringAdded) {
				list.add("\"%.*s\\0\"");
			}
			stringAdded = true;
			addNull(list);
			break;
		case CHAR:
			if (!charAdded) {
				list.add("\" %c\\0\"");
			}
			charAdded = true;
			addNull(list);
			break;
		case BOOL:
			if (!boolAdded) {
				list.add("\"true\\0\"");
				list.add("\"false\\0\"");
			}
			boolAdded = true;
			addNull(list);
		}

	}
	
	private static void addNull(List<String> list) {
		if (!nullAdded) {
			list.add("\"\\0\"");
			nullAdded = true;
		}
	}

}
