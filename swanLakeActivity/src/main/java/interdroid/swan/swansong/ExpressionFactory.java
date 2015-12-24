package interdroid.swan.swansong;

import android.util.Log;

public class ExpressionFactory {

	public static Expression parse(String parseString)
			throws ExpressionParseException {
		Log.e("Roshan-EFactory", parseString);
		Log.e("Roshan-EFactory","value after parsing: "+SwanExpressionParser.parseExpression(parseString).toParseString());
		return SwanExpressionParser.parseExpression(parseString);
	}

}
