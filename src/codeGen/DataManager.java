package codeGen;

import java.util.List;

import Intsr.Instruction;

public enum DataManager {

	STRING, INT;

	private static boolean nullAdded = false;
	private static boolean stringAdded = false;
	private static boolean intAdded = false;

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
		}

	}
	
	private static void addNull(List<String> list) {
		if (!nullAdded) {
			list.add("\"\\0\"");
			nullAdded = true;
		}
	}

}
