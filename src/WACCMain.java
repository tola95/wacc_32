import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class WACCMain {
	public static void main(String[] args) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		BasicLexer lexer = new BasicLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		BasicParser parser = new BasicParser(tokens);
		ParseTree tree = parser.program();
		System.out.println(tree.toStringTree(parser));
	}
}