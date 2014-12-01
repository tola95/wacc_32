package WACCFrontEnd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import codeGen.WACCAssembler;

import Intsr.ARMInstruction;
import Intsr.Instruction;
import antlr.BasicLexer;
import antlr.BasicParser;

public class WACCMain {
	public static void main(String[] args) throws Exception {
		//Input and output files created
		String inputFile = null;
		String outputFile = null;
		if (args.length > 0) inputFile = args[0];
		InputStream is = System.in;
		if (inputFile != null) {
			is = new FileInputStream(inputFile);
		}
		ANTLRInputStream input = new ANTLRInputStream(is);
		BasicLexer lexer = new BasicLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		BasicParser parser = new BasicParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(new WACCErrorListener());
		ParseTree tree = parser.program();
		if (WACCErrorListener.isError()) System.exit(100);
		
		//Creaing a new WACCVisitor
		WACCVisitor waccVisitor = new WACCVisitor();
		waccVisitor.visit(tree);
		
		//Creating a new WACCAssembler
		WACCAssembler waccAssembler = new WACCAssembler();
		waccAssembler.visit(tree);	
		if (outputFile == null) {
			outputFile = inputFile.replace(".wacc", ".s");
			File file = new File(outputFile);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (Instruction arm : WACCAssembler.getCode()) {
				bw.write(arm.toString());
			}
		}
		//waccAssembler.getInstructions();
	}
}