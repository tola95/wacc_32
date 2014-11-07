import java.io.FileInputStream;
import java.io.InputStream;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class WACCMain {
	public static void main(String[] args) throws Exception {
		String inputFile = null;
		if (args.length > 0) inputFile = args[0];
		InputStream is = System.in;
		if (inputFile != null) is = new FileInputStream(inputFile);
		ANTLRInputStream input = new ANTLRInputStream(is);
		BasicLexer lexer = new BasicLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		BasicParser parser = new BasicParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(new WACCErrorListener());
		ParseTree tree = parser.program();
		if (WACCErrorListener.isError()) System.exit(100);
		WACCVisitor waccVisitor = new WACCVisitor();
		waccVisitor.visit(tree);
	}
}