package interdroid.swan.swansong;

import android.util.Log;

public class ExpressionFactory {

	public static Expression parse(String parseString)
			throws ExpressionParseException {
		Log.e("Roshan", parseString);
		return SwanExpressionParser.parseExpression(parseString);
	}

}
