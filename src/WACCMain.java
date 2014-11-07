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
		ParseTree tree = parser.program();
		int errors = parser.getNumberOfSyntaxErrors();
		if (WACCErrorListener.error) System.exit(100);
		WACCVisitor waccVisitor = new WACCVisitor();
		waccVisitor.visit(tree);
	}
}