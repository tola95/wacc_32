package WACCFrontEnd;

import antlr.BasicParser;


public class SyntaxChecker {
	
	
	
	public static boolean checkReturnType(BasicParser.StatContext ctx) {
		boolean ret = false;
		if ((ctx instanceof BasicParser.Return_StatContext) 
				|| ctx instanceof BasicParser.Exit_StatContext) {
			return true;
		}
		if (ctx instanceof BasicParser.If_StatContext) {
			ret = checkForIfStat(ctx);
			return ret;
		}
			
		if (ctx instanceof BasicParser.Semicolon_StatContext) {
			BasicParser.Semicolon_StatContext semictx =(BasicParser.Semicolon_StatContext) ctx;
			ret = checkReturnType(semictx.stat(1));
		}
		return ret;
	}
	
	private static boolean checkForIfStat(BasicParser.StatContext ctx) {
		BasicParser.If_StatContext ifctx = (BasicParser.If_StatContext) ctx;
		boolean ret1 = checkReturnType(ifctx.stat(0));
		boolean ret2 = checkReturnType(ifctx.stat(1));
		return ret1 && ret2;
		
	}

}
