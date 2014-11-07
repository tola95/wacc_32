import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Recognizer;


public class WACCErrorListener extends BaseErrorListener{
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
	int line, int charPositionInLine, String msg,
	RecognitionException e)
	{
	System.exit(100);
	}
}
