package codeGen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintManager {
	
	private List<Boolean> prints = Arrays.asList(false, false, false, false, false, false);
	private List<Boolean> reads = Arrays.asList(false, false, false);
	
	public boolean print_string() {
		return helperPrint(prints, 0);
	}
	
	public boolean print_int() {
		return helperPrint(prints, 1);
	}
	
	public boolean print_char() {
		return helperPrint(prints, 2);
	}
	
	public boolean print_array() {
		return helperPrint(prints, 3);
	}
	
	public boolean print_pair() {
		return helperPrint(prints, 4);
	}
	
	public boolean print_bool() {
		return helperPrint(prints, 5);
	}
	
	public boolean read_char() {
		return helperPrint(reads, 0);
	}
	
	public boolean read_int() {
		return helperPrint(reads, 1);
	}
	
	public boolean read_string() {
		return helperPrint(reads, 2);
	}
	
	public boolean helperPrint(List<Boolean> list, int i) {
		boolean value = list.get(i);
		if (!value) {
			list.set(i, true);
		}
		return value;
	}

}
