package Intsr;


public enum Directives implements Instruction{
	
	TEXT (".text\n\n"), 
	GLOBALM (".global main\n"),
	LTORG ("\t.ltorg\n\n"),
	DATA (".data\n\n"),
	WORD ("\t.word"),
	ASCII ("\t.ascii")
	;
	
	private String direc;
	
	private Directives(String direc) {
		this.direc = direc;
	}
	
	@Override
	public String toString() {
		return direc;
	}

}
