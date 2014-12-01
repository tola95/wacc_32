package WACCFrontEnd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import codeGen.WACCAssembler;

import Intsr.ARMInstruction;
import Intsr.Instruction;
import antlr.BasicLexer;
import antlr.BasicParser;

public class WACCMain {
	public static void main(String[] args) throws Exception {
		// Input and output files created
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
		
		// Creaing a new WACCVisitor
		WACCVisitor waccVisitor = new WACCVisitor();
		waccVisitor.visit(tree);
		
		// Creating a new WACCAssembler
		WACCAssembler waccAssembler = new WACCAssembler();
		waccAssembler.visit(tree);	
		// Creating a file
		File inFile = new File(inputFile);
		if (outputFile == null) {
			outputFile = inFile.getName();
			outputFile = outputFile.replace(".wacc", ".s");
			String ofile = "/homes/ss11813/wacc_32/" + outputFile;
			FileWriter file = new FileWriter(new File(ofile));
			for (Instruction arm : WACCAssembler.getCode()) {
				// Writing to a file
				file.write(arm.toString());
			}
			file.close();
		}
		//waccAssembler.getInstructions();
	}
}