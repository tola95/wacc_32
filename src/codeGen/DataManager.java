package codeGen;

import java.util.List;

public enum DataManager {

	STRING, INT, CHAR, BOOL, ARRAY, DIVIDE, OVERFLOW, ARRAYNEG, ARRAYLARGE;

	private static boolean nullAdded = false;
	private static boolean stringAdded = false;
	private static boolean intAdded = false;
	private static boolean charAdded = false;
	private static boolean boolAdded = false;
	private static boolean arrayAdded = false;
	private static boolean divideByAdded = false;
	private static boolean overflowAdded = false;
	private static boolean arrayneg = false;
	private static boolean arraylarge = false;

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
			break;
		case ARRAY:
			if (!arrayAdded) {
				list.add("\"%p\\0\"");
			}
			arrayAdded = true;
			addNull(list);
			break;
		case DIVIDE:
			if (!divideByAdded) {
				list.add("\"DivideByZeroError: divide or modul by zero\\n\\0\"");
			}
			divideByAdded = true;
			addNull(list);
			break;
		case OVERFLOW:
			if (!overflowAdded) {
				list.add("\"OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n\"");
			}
			overflowAdded = true;
			addNull(list);
			break;
		case ARRAYNEG:
			if (!arrayneg) {
				list.add("\"ArrayIndexOutOfBoundsError: negative index\\n\\0\"");
			}
			arrayneg = true;
			addNull(list);
			break;
		case ARRAYLARGE:
			if (!arraylarge) {
				list.add("\"ArrayIndexOutOfBoundsError: index too large\\n\\0\"");
			}
			arraylarge = true;
			addNull(list);
			break;
		}
	}
	
	private static void addNull(List<String> list) {
		if (!nullAdded) {
			list.add("\"\\0\"");
			nullAdded = true;
		}
	}

}
