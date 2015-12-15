// $ANTLR 3.5.2 SwanExpression.g 2015-12-10 02:07:20

package interdroid.swan.swansong;

import android.os.Bundle;
import java.util.Stack;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SwanExpressionParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALL", "AND", "ANY", "CONFIG_HASH", 
		"CONFIG_IS", "CONFIG_TILT", "CONFIG_VAL", "CONTAINS", "DIV", "EQUALS", 
		"ESC_SEQ", "EXPONENT", "FLOAT", "GT", "GTEQ", "HEX_DIGIT", "ID", "INT", 
		"LT", "LTEQ", "MAX", "MEAN", "MEDIAN", "MIN", "MINUS", "MOD", "MULT", 
		"NONE", "NOT", "NOTEQUALS", "OR", "PLUS", "REGEX", "STRING", "TIME_UNIT", 
		"WS", "'$'", "'('", "')'", "','", "'.'", "':'", "'?'", "'@'", "'{'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int ALL=4;
	public static final int AND=5;
	public static final int ANY=6;
	public static final int CONFIG_HASH=7;
	public static final int CONFIG_IS=8;
	public static final int CONFIG_TILT=9;
	public static final int CONFIG_VAL=10;
	public static final int CONTAINS=11;
	public static final int DIV=12;
	public static final int EQUALS=13;
	public static final int ESC_SEQ=14;
	public static final int EXPONENT=15;
	public static final int FLOAT=16;
	public static final int GT=17;
	public static final int GTEQ=18;
	public static final int HEX_DIGIT=19;
	public static final int ID=20;
	public static final int INT=21;
	public static final int LT=22;
	public static final int LTEQ=23;
	public static final int MAX=24;
	public static final int MEAN=25;
	public static final int MEDIAN=26;
	public static final int MIN=27;
	public static final int MINUS=28;
	public static final int MOD=29;
	public static final int MULT=30;
	public static final int NONE=31;
	public static final int NOT=32;
	public static final int NOTEQUALS=33;
	public static final int OR=34;
	public static final int PLUS=35;
	public static final int REGEX=36;
	public static final int STRING=37;
	public static final int TIME_UNIT=38;
	public static final int WS=39;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public SwanExpressionParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public SwanExpressionParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return SwanExpressionParser.tokenNames; }
	@Override public String getGrammarFileName() { return "SwanExpression.g"; }


	public static final Expression parseExpression(final String expression) throws ExpressionParseException {
	        if (expression == null || expression.trim().length() == 0)
	            return null;

	        CharStream stream = new ANTLRStringStream(expression);
	        SwanExpressionLexer lexer = new SwanExpressionLexer(stream);
	        TokenStream tokenStream = new CommonTokenStream(lexer);
	        SwanExpressionParser parser = new SwanExpressionParser(tokenStream);
	        try {
	            return parser.expression() /* .expression */ ;
	        } catch (RecognitionException e) {
	            throw new ExpressionParseException(e);
	        }
	}

	public static final long convertTime(Token time, Token unit) {
		long unitFactor = 1;
		if (unit != null) {
			String unitText = unit.getText();
			if (unitText.equals("h") || unitText.equals("H")) {
				unitFactor = 60 * 60 * 1000;
			} else if (unitText.equals("m") || unitText.equals("M")) {
				unitFactor = 60 * 1000;
			} else if (unitText.equals("s") || unitText.equals("S")) {
				unitFactor = 1000;
			}
		}
		return Long.parseLong(time.getText()) * unitFactor;
	}




	// $ANTLR start "http_configuration_options"
	// SwanExpression.g:53:1: http_configuration_options returns [Bundle http_configuration] : (hid= ID hval= CONFIG_VAL ) ( CONFIG_TILT more_hid= ID more_hval= CONFIG_VAL )* ;
	public final Bundle http_configuration_options() throws RecognitionException {
		Bundle http_configuration = null;


		Token hid=null;
		Token hval=null;
		Token more_hid=null;
		Token more_hval=null;


			Bundle http_config = new Bundle();

		try {
			// SwanExpression.g:57:2: ( (hid= ID hval= CONFIG_VAL ) ( CONFIG_TILT more_hid= ID more_hval= CONFIG_VAL )* )
			// SwanExpression.g:58:2: (hid= ID hval= CONFIG_VAL ) ( CONFIG_TILT more_hid= ID more_hval= CONFIG_VAL )*
			{
			// SwanExpression.g:58:2: (hid= ID hval= CONFIG_VAL )
			// SwanExpression.g:58:3: hid= ID hval= CONFIG_VAL
			{
			hid=(Token)match(input,ID,FOLLOW_ID_in_http_configuration_options62); 
			hval=(Token)match(input,CONFIG_VAL,FOLLOW_CONFIG_VAL_in_http_configuration_options66); 
			}

			http_config.putString(hid.getText(), hval.getText().substring(1));
			// SwanExpression.g:60:2: ( CONFIG_TILT more_hid= ID more_hval= CONFIG_VAL )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==CONFIG_TILT) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// SwanExpression.g:60:3: CONFIG_TILT more_hid= ID more_hval= CONFIG_VAL
					{
					match(input,CONFIG_TILT,FOLLOW_CONFIG_TILT_in_http_configuration_options76); 
					more_hid=(Token)match(input,ID,FOLLOW_ID_in_http_configuration_options80); 
					more_hval=(Token)match(input,CONFIG_VAL,FOLLOW_CONFIG_VAL_in_http_configuration_options84); 
					}
					break;

				default :
					break loop1;
				}
			}

			http_config.putString(more_hid.getText(), more_hval.getText().substring(1));
			http_configuration = http_config;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return http_configuration;
	}
	// $ANTLR end "http_configuration_options"



	// $ANTLR start "configuration_options"
	// SwanExpression.g:66:1: configuration_options returns [Bundle configuration] : (id= ID val= CONFIG_VAL ) ( CONFIG_HASH more_id= ID more_val= CONFIG_VAL )* ;
	public final Bundle configuration_options() throws RecognitionException {
		Bundle configuration = null;


		Token id=null;
		Token val=null;
		Token more_id=null;
		Token more_val=null;


			Bundle config = new Bundle();

		try {
			// SwanExpression.g:70:2: ( (id= ID val= CONFIG_VAL ) ( CONFIG_HASH more_id= ID more_val= CONFIG_VAL )* )
			// SwanExpression.g:71:2: (id= ID val= CONFIG_VAL ) ( CONFIG_HASH more_id= ID more_val= CONFIG_VAL )*
			{
			// SwanExpression.g:71:2: (id= ID val= CONFIG_VAL )
			// SwanExpression.g:71:3: id= ID val= CONFIG_VAL
			{
			id=(Token)match(input,ID,FOLLOW_ID_in_configuration_options120); 
			val=(Token)match(input,CONFIG_VAL,FOLLOW_CONFIG_VAL_in_configuration_options124); 
			}

			config.putString(id.getText(), val.getText().substring(1));
			// SwanExpression.g:73:2: ( CONFIG_HASH more_id= ID more_val= CONFIG_VAL )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==CONFIG_HASH) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// SwanExpression.g:73:3: CONFIG_HASH more_id= ID more_val= CONFIG_VAL
					{
					match(input,CONFIG_HASH,FOLLOW_CONFIG_HASH_in_configuration_options134); 
					more_id=(Token)match(input,ID,FOLLOW_ID_in_configuration_options138); 
					more_val=(Token)match(input,CONFIG_VAL,FOLLOW_CONFIG_VAL_in_configuration_options142); 
					config.putString(more_id.getText(), more_val.getText().substring(1));
					}
					break;

				default :
					break loop2;
				}
			}

			configuration = config;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return configuration;
	}
	// $ANTLR end "configuration_options"



	// $ANTLR start "value_path"
	// SwanExpression.g:79:1: value_path returns [String value_path] : vp= v_p ( '.' more_id= v_p )* ;
	public final String value_path() throws RecognitionException {
		String value_path = null;


		String vp =null;
		String more_id =null;


			StringBuffer buf = new StringBuffer();

		try {
			// SwanExpression.g:83:2: (vp= v_p ( '.' more_id= v_p )* )
			// SwanExpression.g:84:2: vp= v_p ( '.' more_id= v_p )*
			{
			pushFollow(FOLLOW_v_p_in_value_path178);
			vp=v_p();
			state._fsp--;

			buf.append(vp);
			// SwanExpression.g:86:2: ( '.' more_id= v_p )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==44) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// SwanExpression.g:86:3: '.' more_id= v_p
					{
					match(input,44,FOLLOW_44_in_value_path187); 
					pushFollow(FOLLOW_v_p_in_value_path191);
					more_id=v_p();
					state._fsp--;

					buf.append('.'); buf.append(vp);
					}
					break;

				default :
					break loop3;
				}
			}

			value_path = buf.toString();
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value_path;
	}
	// $ANTLR end "value_path"



	// $ANTLR start "v_p"
	// SwanExpression.g:92:1: v_p returns [String vp] : (id= ID |str= STRING );
	public final String v_p() throws RecognitionException {
		String vp = null;


		Token id=null;
		Token str=null;

		try {
			// SwanExpression.g:93:2: (id= ID |str= STRING )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==ID) ) {
				alt4=1;
			}
			else if ( (LA4_0==STRING) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// SwanExpression.g:93:4: id= ID
					{
					id=(Token)match(input,ID,FOLLOW_ID_in_v_p223); 
					 vp = id.getText(); 
					}
					break;
				case 2 :
					// SwanExpression.g:94:4: str= STRING
					{
					str=(Token)match(input,STRING,FOLLOW_STRING_in_v_p232); 
					 vp = str.getText(); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return vp;
	}
	// $ANTLR end "v_p"



	// $ANTLR start "comparator"
	// SwanExpression.g:97:1: comparator returns [Comparator comparator] : ( GT | LT | GTEQ | LTEQ | EQUALS | NOTEQUALS | REGEX | CONTAINS );
	public final Comparator comparator() throws RecognitionException {
		Comparator comparator = null;


		try {
			// SwanExpression.g:98:2: ( GT | LT | GTEQ | LTEQ | EQUALS | NOTEQUALS | REGEX | CONTAINS )
			int alt5=8;
			switch ( input.LA(1) ) {
			case GT:
				{
				alt5=1;
				}
				break;
			case LT:
				{
				alt5=2;
				}
				break;
			case GTEQ:
				{
				alt5=3;
				}
				break;
			case LTEQ:
				{
				alt5=4;
				}
				break;
			case EQUALS:
				{
				alt5=5;
				}
				break;
			case NOTEQUALS:
				{
				alt5=6;
				}
				break;
			case REGEX:
				{
				alt5=7;
				}
				break;
			case CONTAINS:
				{
				alt5=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// SwanExpression.g:98:4: GT
					{
					match(input,GT,FOLLOW_GT_in_comparator249); 
					comparator = Comparator.GREATER_THAN;
					}
					break;
				case 2 :
					// SwanExpression.g:99:4: LT
					{
					match(input,LT,FOLLOW_LT_in_comparator256); 
					comparator = Comparator.LESS_THAN;
					}
					break;
				case 3 :
					// SwanExpression.g:100:4: GTEQ
					{
					match(input,GTEQ,FOLLOW_GTEQ_in_comparator263); 
					comparator = Comparator.GREATER_THAN_OR_EQUALS;
					}
					break;
				case 4 :
					// SwanExpression.g:101:4: LTEQ
					{
					match(input,LTEQ,FOLLOW_LTEQ_in_comparator270); 
					comparator = Comparator.LESS_THAN_OR_EQUALS;
					}
					break;
				case 5 :
					// SwanExpression.g:102:4: EQUALS
					{
					match(input,EQUALS,FOLLOW_EQUALS_in_comparator277); 
					comparator = Comparator.EQUALS;
					}
					break;
				case 6 :
					// SwanExpression.g:103:4: NOTEQUALS
					{
					match(input,NOTEQUALS,FOLLOW_NOTEQUALS_in_comparator284); 
					comparator = Comparator.NOT_EQUALS;
					}
					break;
				case 7 :
					// SwanExpression.g:104:4: REGEX
					{
					match(input,REGEX,FOLLOW_REGEX_in_comparator291); 
					comparator = Comparator.REGEX_MATCH;
					}
					break;
				case 8 :
					// SwanExpression.g:105:4: CONTAINS
					{
					match(input,CONTAINS,FOLLOW_CONTAINS_in_comparator298); 
					comparator = Comparator.STRING_CONTAINS;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return comparator;
	}
	// $ANTLR end "comparator"



	// $ANTLR start "logic_operator"
	// SwanExpression.g:108:1: logic_operator returns [LogicOperator logic_operator] : (binary= binary_logic_operator |unary= unary_logic_operator );
	public final LogicOperator logic_operator() throws RecognitionException {
		LogicOperator logic_operator = null;


		BinaryLogicOperator binary =null;
		UnaryLogicOperator unary =null;

		try {
			// SwanExpression.g:109:2: (binary= binary_logic_operator |unary= unary_logic_operator )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==AND||LA6_0==OR) ) {
				alt6=1;
			}
			else if ( (LA6_0==NOT) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// SwanExpression.g:110:3: binary= binary_logic_operator
					{
					pushFollow(FOLLOW_binary_logic_operator_in_logic_operator320);
					binary=binary_logic_operator();
					state._fsp--;

					logic_operator = binary /* .logic_operator */ ;
					}
					break;
				case 2 :
					// SwanExpression.g:112:4: unary= unary_logic_operator
					{
					pushFollow(FOLLOW_unary_logic_operator_in_logic_operator333);
					unary=unary_logic_operator();
					state._fsp--;

					logic_operator = unary /* .logic_operator */ ;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return logic_operator;
	}
	// $ANTLR end "logic_operator"



	// $ANTLR start "binary_logic_operator"
	// SwanExpression.g:116:1: binary_logic_operator returns [BinaryLogicOperator logic_operator] : ( AND | OR );
	public final BinaryLogicOperator binary_logic_operator() throws RecognitionException {
		BinaryLogicOperator logic_operator = null;


		try {
			// SwanExpression.g:117:2: ( AND | OR )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==AND) ) {
				alt7=1;
			}
			else if ( (LA7_0==OR) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// SwanExpression.g:117:4: AND
					{
					match(input,AND,FOLLOW_AND_in_binary_logic_operator354); 
					logic_operator = BinaryLogicOperator.AND;
					}
					break;
				case 2 :
					// SwanExpression.g:118:4: OR
					{
					match(input,OR,FOLLOW_OR_in_binary_logic_operator361); 
					logic_operator = BinaryLogicOperator.OR;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return logic_operator;
	}
	// $ANTLR end "binary_logic_operator"



	// $ANTLR start "unary_logic_operator"
	// SwanExpression.g:121:1: unary_logic_operator returns [UnaryLogicOperator logic_operator] : NOT ;
	public final UnaryLogicOperator unary_logic_operator() throws RecognitionException {
		UnaryLogicOperator logic_operator = null;


		try {
			// SwanExpression.g:122:2: ( NOT )
			// SwanExpression.g:122:4: NOT
			{
			match(input,NOT,FOLLOW_NOT_in_unary_logic_operator378); 
			logic_operator = UnaryLogicOperator.NOT;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return logic_operator;
	}
	// $ANTLR end "unary_logic_operator"



	// $ANTLR start "math_operator"
	// SwanExpression.g:125:1: math_operator returns [MathOperator math_operator] : (add= additive_math_operator |mult= multiplicative_math_operator );
	public final MathOperator math_operator() throws RecognitionException {
		MathOperator math_operator = null;


		MathOperator add =null;
		MathOperator mult =null;

		try {
			// SwanExpression.g:126:2: (add= additive_math_operator |mult= multiplicative_math_operator )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==MINUS||LA8_0==PLUS) ) {
				alt8=1;
			}
			else if ( (LA8_0==DIV||(LA8_0 >= MOD && LA8_0 <= MULT)) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// SwanExpression.g:126:4: add= additive_math_operator
					{
					pushFollow(FOLLOW_additive_math_operator_in_math_operator397);
					add=additive_math_operator();
					state._fsp--;

					math_operator =add /* .math_operator */ ;
					}
					break;
				case 2 :
					// SwanExpression.g:127:4: mult= multiplicative_math_operator
					{
					pushFollow(FOLLOW_multiplicative_math_operator_in_math_operator406);
					mult=multiplicative_math_operator();
					state._fsp--;

					math_operator =mult /* .math_operator */ ;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return math_operator;
	}
	// $ANTLR end "math_operator"



	// $ANTLR start "additive_math_operator"
	// SwanExpression.g:130:1: additive_math_operator returns [MathOperator math_operator] : ( PLUS | MINUS );
	public final MathOperator additive_math_operator() throws RecognitionException {
		MathOperator math_operator = null;


		try {
			// SwanExpression.g:131:2: ( PLUS | MINUS )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==PLUS) ) {
				alt9=1;
			}
			else if ( (LA9_0==MINUS) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// SwanExpression.g:131:4: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_additive_math_operator423); 
					math_operator = MathOperator.PLUS;
					}
					break;
				case 2 :
					// SwanExpression.g:132:4: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_additive_math_operator430); 
					math_operator = MathOperator.MINUS;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return math_operator;
	}
	// $ANTLR end "additive_math_operator"



	// $ANTLR start "multiplicative_math_operator"
	// SwanExpression.g:135:1: multiplicative_math_operator returns [MathOperator math_operator] : ( MULT | DIV | MOD );
	public final MathOperator multiplicative_math_operator() throws RecognitionException {
		MathOperator math_operator = null;


		try {
			// SwanExpression.g:136:2: ( MULT | DIV | MOD )
			int alt10=3;
			switch ( input.LA(1) ) {
			case MULT:
				{
				alt10=1;
				}
				break;
			case DIV:
				{
				alt10=2;
				}
				break;
			case MOD:
				{
				alt10=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// SwanExpression.g:136:4: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_multiplicative_math_operator448); 
					math_operator = MathOperator.TIMES;
					}
					break;
				case 2 :
					// SwanExpression.g:137:4: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_multiplicative_math_operator455); 
					math_operator = MathOperator.DIVIDE;
					}
					break;
				case 3 :
					// SwanExpression.g:138:4: MOD
					{
					match(input,MOD,FOLLOW_MOD_in_multiplicative_math_operator462); 
					math_operator = MathOperator.MOD;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return math_operator;
	}
	// $ANTLR end "multiplicative_math_operator"



	// $ANTLR start "history_mode"
	// SwanExpression.g:141:1: history_mode returns [HistoryReductionMode history_mode] : ( ALL | MAX | MIN | MEAN | MEDIAN | ANY );
	public final HistoryReductionMode history_mode() throws RecognitionException {
		HistoryReductionMode history_mode = null;


		try {
			// SwanExpression.g:142:2: ( ALL | MAX | MIN | MEAN | MEDIAN | ANY )
			int alt11=6;
			switch ( input.LA(1) ) {
			case ALL:
				{
				alt11=1;
				}
				break;
			case MAX:
				{
				alt11=2;
				}
				break;
			case MIN:
				{
				alt11=3;
				}
				break;
			case MEAN:
				{
				alt11=4;
				}
				break;
			case MEDIAN:
				{
				alt11=5;
				}
				break;
			case ANY:
				{
				alt11=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// SwanExpression.g:142:4: ALL
					{
					match(input,ALL,FOLLOW_ALL_in_history_mode479); 
					history_mode = HistoryReductionMode.ALL;
					}
					break;
				case 2 :
					// SwanExpression.g:143:4: MAX
					{
					match(input,MAX,FOLLOW_MAX_in_history_mode486); 
					history_mode = HistoryReductionMode.MAX;
					}
					break;
				case 3 :
					// SwanExpression.g:144:4: MIN
					{
					match(input,MIN,FOLLOW_MIN_in_history_mode493); 
					history_mode = HistoryReductionMode.MIN;
					}
					break;
				case 4 :
					// SwanExpression.g:145:4: MEAN
					{
					match(input,MEAN,FOLLOW_MEAN_in_history_mode500); 
					history_mode = HistoryReductionMode.MEAN;
					}
					break;
				case 5 :
					// SwanExpression.g:146:4: MEDIAN
					{
					match(input,MEDIAN,FOLLOW_MEDIAN_in_history_mode507); 
					history_mode = HistoryReductionMode.MEDIAN;
					}
					break;
				case 6 :
					// SwanExpression.g:147:4: ANY
					{
					match(input,ANY,FOLLOW_ANY_in_history_mode514); 
					history_mode = HistoryReductionMode.ANY;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return history_mode;
	}
	// $ANTLR end "history_mode"



	// $ANTLR start "sensor_value_expression"
	// SwanExpression.g:152:1: sensor_value_expression returns [SensorValueExpression value_expression] : (location= ID '@' entity= ID ':' path= value_path |location= ID '@' entity= ID ':' path= value_path '?' config= configuration_options |location= ID '@' entity= ID ':' path= value_path '$' http_config= http_configuration_options '{' ( (mode= history_mode ',' time= time_value ) |mode= history_mode |time= time_value ) '}' |location= ID '@' entity= ID ':' path= value_path '?' config= configuration_options '$' http_config= http_configuration_options '{' ( (mode= history_mode ',' time= time_value ) |mode= history_mode |time= time_value ) '}' );
	public final SensorValueExpression sensor_value_expression() throws RecognitionException {
		SensorValueExpression value_expression = null;


		Token location=null;
		Token entity=null;
		String path =null;
		Bundle config =null;
		Bundle http_config =null;
		HistoryReductionMode mode =null;
		Long time =null;

		try {
			// SwanExpression.g:153:2: (location= ID '@' entity= ID ':' path= value_path |location= ID '@' entity= ID ':' path= value_path '?' config= configuration_options |location= ID '@' entity= ID ':' path= value_path '$' http_config= http_configuration_options '{' ( (mode= history_mode ',' time= time_value ) |mode= history_mode |time= time_value ) '}' |location= ID '@' entity= ID ':' path= value_path '?' config= configuration_options '$' http_config= http_configuration_options '{' ( (mode= history_mode ',' time= time_value ) |mode= history_mode |time= time_value ) '}' )
			int alt14=4;
			alt14 = dfa14.predict(input);
			switch (alt14) {
				case 1 :
					// SwanExpression.g:153:4: location= ID '@' entity= ID ':' path= value_path
					{
					location=(Token)match(input,ID,FOLLOW_ID_in_sensor_value_expression535); 
					match(input,47,FOLLOW_47_in_sensor_value_expression537); 
					entity=(Token)match(input,ID,FOLLOW_ID_in_sensor_value_expression541); 
					match(input,45,FOLLOW_45_in_sensor_value_expression543); 
					pushFollow(FOLLOW_value_path_in_sensor_value_expression547);
					path=value_path();
					state._fsp--;

					value_expression = new SensorValueExpression(location.getText(), entity.getText(), path /*.value_path */, null, HistoryReductionMode.ANY, 0,null);
					}
					break;
				case 2 :
					// SwanExpression.g:155:4: location= ID '@' entity= ID ':' path= value_path '?' config= configuration_options
					{
					location=(Token)match(input,ID,FOLLOW_ID_in_sensor_value_expression559); 
					match(input,47,FOLLOW_47_in_sensor_value_expression561); 
					entity=(Token)match(input,ID,FOLLOW_ID_in_sensor_value_expression565); 
					match(input,45,FOLLOW_45_in_sensor_value_expression567); 
					pushFollow(FOLLOW_value_path_in_sensor_value_expression571);
					path=value_path();
					state._fsp--;

					match(input,46,FOLLOW_46_in_sensor_value_expression573); 
					pushFollow(FOLLOW_configuration_options_in_sensor_value_expression577);
					config=configuration_options();
					state._fsp--;

					value_expression = new SensorValueExpression(location.getText(), entity.getText(), path /*.value_path */, config /*.configuration */, HistoryReductionMode.ANY, 0,null);
					}
					break;
				case 3 :
					// SwanExpression.g:157:4: location= ID '@' entity= ID ':' path= value_path '$' http_config= http_configuration_options '{' ( (mode= history_mode ',' time= time_value ) |mode= history_mode |time= time_value ) '}'
					{
					location=(Token)match(input,ID,FOLLOW_ID_in_sensor_value_expression589); 
					match(input,47,FOLLOW_47_in_sensor_value_expression591); 
					entity=(Token)match(input,ID,FOLLOW_ID_in_sensor_value_expression595); 
					match(input,45,FOLLOW_45_in_sensor_value_expression597); 
					pushFollow(FOLLOW_value_path_in_sensor_value_expression601);
					path=value_path();
					state._fsp--;

					match(input,40,FOLLOW_40_in_sensor_value_expression603); 
					pushFollow(FOLLOW_http_configuration_options_in_sensor_value_expression607);
					http_config=http_configuration_options();
					state._fsp--;

					match(input,48,FOLLOW_48_in_sensor_value_expression609); 
					// SwanExpression.g:157:97: ( (mode= history_mode ',' time= time_value ) |mode= history_mode |time= time_value )
					int alt12=3;
					switch ( input.LA(1) ) {
					case ALL:
						{
						int LA12_1 = input.LA(2);
						if ( (LA12_1==43) ) {
							alt12=1;
						}
						else if ( (LA12_1==49) ) {
							alt12=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 12, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case MAX:
						{
						int LA12_2 = input.LA(2);
						if ( (LA12_2==43) ) {
							alt12=1;
						}
						else if ( (LA12_2==49) ) {
							alt12=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 12, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case MIN:
						{
						int LA12_3 = input.LA(2);
						if ( (LA12_3==43) ) {
							alt12=1;
						}
						else if ( (LA12_3==49) ) {
							alt12=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 12, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case MEAN:
						{
						int LA12_4 = input.LA(2);
						if ( (LA12_4==43) ) {
							alt12=1;
						}
						else if ( (LA12_4==49) ) {
							alt12=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 12, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case MEDIAN:
						{
						int LA12_5 = input.LA(2);
						if ( (LA12_5==43) ) {
							alt12=1;
						}
						else if ( (LA12_5==49) ) {
							alt12=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 12, 5, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case ANY:
						{
						int LA12_6 = input.LA(2);
						if ( (LA12_6==43) ) {
							alt12=1;
						}
						else if ( (LA12_6==49) ) {
							alt12=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 12, 6, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case INT:
						{
						alt12=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 12, 0, input);
						throw nvae;
					}
					switch (alt12) {
						case 1 :
							// SwanExpression.g:157:98: (mode= history_mode ',' time= time_value )
							{
							// SwanExpression.g:157:98: (mode= history_mode ',' time= time_value )
							// SwanExpression.g:157:99: mode= history_mode ',' time= time_value
							{
							pushFollow(FOLLOW_history_mode_in_sensor_value_expression615);
							mode=history_mode();
							state._fsp--;

							match(input,43,FOLLOW_43_in_sensor_value_expression617); 
							pushFollow(FOLLOW_time_value_in_sensor_value_expression621);
							time=time_value();
							state._fsp--;

							}

							}
							break;
						case 2 :
							// SwanExpression.g:157:140: mode= history_mode
							{
							pushFollow(FOLLOW_history_mode_in_sensor_value_expression628);
							mode=history_mode();
							state._fsp--;

							}
							break;
						case 3 :
							// SwanExpression.g:157:160: time= time_value
							{
							pushFollow(FOLLOW_time_value_in_sensor_value_expression634);
							time=time_value();
							state._fsp--;

							}
							break;

					}

					match(input,49,FOLLOW_49_in_sensor_value_expression637); 
					if (time == null) {
									value_expression = new SensorValueExpression(location.getText(), entity.getText(), path /* .value_path */, null, mode /*.history_mode */, 0,http_config);
								} else {
									value_expression = new SensorValueExpression(location.getText(), entity.getText(), path /* .value_path */, null, mode /*.history_mode */, time,http_config);
								}
					}
					break;
				case 4 :
					// SwanExpression.g:163:4: location= ID '@' entity= ID ':' path= value_path '?' config= configuration_options '$' http_config= http_configuration_options '{' ( (mode= history_mode ',' time= time_value ) |mode= history_mode |time= time_value ) '}'
					{
					location=(Token)match(input,ID,FOLLOW_ID_in_sensor_value_expression649); 
					match(input,47,FOLLOW_47_in_sensor_value_expression651); 
					entity=(Token)match(input,ID,FOLLOW_ID_in_sensor_value_expression655); 
					match(input,45,FOLLOW_45_in_sensor_value_expression657); 
					pushFollow(FOLLOW_value_path_in_sensor_value_expression661);
					path=value_path();
					state._fsp--;

					match(input,46,FOLLOW_46_in_sensor_value_expression663); 
					pushFollow(FOLLOW_configuration_options_in_sensor_value_expression667);
					config=configuration_options();
					state._fsp--;

					match(input,40,FOLLOW_40_in_sensor_value_expression669); 
					pushFollow(FOLLOW_http_configuration_options_in_sensor_value_expression673);
					http_config=http_configuration_options();
					state._fsp--;

					match(input,48,FOLLOW_48_in_sensor_value_expression675); 
					// SwanExpression.g:163:130: ( (mode= history_mode ',' time= time_value ) |mode= history_mode |time= time_value )
					int alt13=3;
					switch ( input.LA(1) ) {
					case ALL:
						{
						int LA13_1 = input.LA(2);
						if ( (LA13_1==43) ) {
							alt13=1;
						}
						else if ( (LA13_1==49) ) {
							alt13=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 13, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case MAX:
						{
						int LA13_2 = input.LA(2);
						if ( (LA13_2==43) ) {
							alt13=1;
						}
						else if ( (LA13_2==49) ) {
							alt13=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 13, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case MIN:
						{
						int LA13_3 = input.LA(2);
						if ( (LA13_3==43) ) {
							alt13=1;
						}
						else if ( (LA13_3==49) ) {
							alt13=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 13, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case MEAN:
						{
						int LA13_4 = input.LA(2);
						if ( (LA13_4==43) ) {
							alt13=1;
						}
						else if ( (LA13_4==49) ) {
							alt13=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 13, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case MEDIAN:
						{
						int LA13_5 = input.LA(2);
						if ( (LA13_5==43) ) {
							alt13=1;
						}
						else if ( (LA13_5==49) ) {
							alt13=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 13, 5, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case ANY:
						{
						int LA13_6 = input.LA(2);
						if ( (LA13_6==43) ) {
							alt13=1;
						}
						else if ( (LA13_6==49) ) {
							alt13=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 13, 6, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case INT:
						{
						alt13=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 13, 0, input);
						throw nvae;
					}
					switch (alt13) {
						case 1 :
							// SwanExpression.g:163:131: (mode= history_mode ',' time= time_value )
							{
							// SwanExpression.g:163:131: (mode= history_mode ',' time= time_value )
							// SwanExpression.g:163:132: mode= history_mode ',' time= time_value
							{
							pushFollow(FOLLOW_history_mode_in_sensor_value_expression681);
							mode=history_mode();
							state._fsp--;

							match(input,43,FOLLOW_43_in_sensor_value_expression683); 
							pushFollow(FOLLOW_time_value_in_sensor_value_expression687);
							time=time_value();
							state._fsp--;

							}

							}
							break;
						case 2 :
							// SwanExpression.g:163:173: mode= history_mode
							{
							pushFollow(FOLLOW_history_mode_in_sensor_value_expression694);
							mode=history_mode();
							state._fsp--;

							}
							break;
						case 3 :
							// SwanExpression.g:163:193: time= time_value
							{
							pushFollow(FOLLOW_time_value_in_sensor_value_expression700);
							time=time_value();
							state._fsp--;

							}
							break;

					}

					match(input,49,FOLLOW_49_in_sensor_value_expression703); 
					if (time == null) {
									value_expression = new SensorValueExpression(location.getText(), entity.getText(), path /* .value_path */ , config /*.configuration */ , mode /* .history_mode */, 0,http_config);
								} else {
									value_expression = new SensorValueExpression(location.getText(), entity.getText(), path /* .value_path */ , config /*.configuration */ , mode /* .history_mode */ , time,http_config);
								}
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value_expression;
	}
	// $ANTLR end "sensor_value_expression"



	// $ANTLR start "constant_value_expression"
	// SwanExpression.g:171:1: constant_value_expression returns [ConstantValueExpression value_expression] : (i= INT |f= FLOAT |raw= STRING );
	public final ConstantValueExpression constant_value_expression() throws RecognitionException {
		ConstantValueExpression value_expression = null;


		Token i=null;
		Token f=null;
		Token raw=null;

		try {
			// SwanExpression.g:172:2: (i= INT |f= FLOAT |raw= STRING )
			int alt15=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt15=1;
				}
				break;
			case FLOAT:
				{
				alt15=2;
				}
				break;
			case STRING:
				{
				alt15=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// SwanExpression.g:172:4: i= INT
					{
					i=(Token)match(input,INT,FOLLOW_INT_in_constant_value_expression725); 
					value_expression = new ConstantValueExpression(Long.parseLong(i.getText()));
					}
					break;
				case 2 :
					// SwanExpression.g:174:4: f= FLOAT
					{
					f=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_constant_value_expression738); 
					value_expression = new ConstantValueExpression(Double.parseDouble(f.getText()));
					}
					break;
				case 3 :
					// SwanExpression.g:176:5: raw= STRING
					{
					raw=(Token)match(input,STRING,FOLLOW_STRING_in_constant_value_expression752); 
					value_expression = new ConstantValueExpression(raw.getText());
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value_expression;
	}
	// $ANTLR end "constant_value_expression"



	// $ANTLR start "value_expression"
	// SwanExpression.g:180:1: value_expression returns [ValueExpression value_expression] : (constant= constant_value_expression |sensor= sensor_value_expression );
	public final ValueExpression value_expression() throws RecognitionException {
		ValueExpression value_expression = null;


		ConstantValueExpression constant =null;
		SensorValueExpression sensor =null;

		try {
			// SwanExpression.g:181:2: (constant= constant_value_expression |sensor= sensor_value_expression )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==FLOAT||LA16_0==INT||LA16_0==STRING) ) {
				alt16=1;
			}
			else if ( (LA16_0==ID) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// SwanExpression.g:181:4: constant= constant_value_expression
					{
					pushFollow(FOLLOW_constant_value_expression_in_value_expression775);
					constant=constant_value_expression();
					state._fsp--;

					value_expression = constant /* value expression */ ;
					}
					break;
				case 2 :
					// SwanExpression.g:183:5: sensor= sensor_value_expression
					{
					pushFollow(FOLLOW_sensor_value_expression_in_value_expression789);
					sensor=sensor_value_expression();
					state._fsp--;

					value_expression = sensor /* value expression */ ;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value_expression;
	}
	// $ANTLR end "value_expression"



	// $ANTLR start "parentheticalExpression"
	// SwanExpression.g:187:1: parentheticalExpression returns [Expression expression] : (val= value_expression | '(' ( WS )* exp= orExpression ( WS )* ')' );
	public final Expression parentheticalExpression() throws RecognitionException {
		Expression expression = null;


		ValueExpression val =null;
		Expression exp =null;

		try {
			// SwanExpression.g:188:5: (val= value_expression | '(' ( WS )* exp= orExpression ( WS )* ')' )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==FLOAT||(LA19_0 >= ID && LA19_0 <= INT)||LA19_0==STRING) ) {
				alt19=1;
			}
			else if ( (LA19_0==41) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// SwanExpression.g:188:9: val= value_expression
					{
					pushFollow(FOLLOW_value_expression_in_parentheticalExpression818);
					val=value_expression();
					state._fsp--;

					expression = val;
					}
					break;
				case 2 :
					// SwanExpression.g:190:9: '(' ( WS )* exp= orExpression ( WS )* ')'
					{
					match(input,41,FOLLOW_41_in_parentheticalExpression843); 
					// SwanExpression.g:190:13: ( WS )*
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( (LA17_0==WS) ) {
							alt17=1;
						}

						switch (alt17) {
						case 1 :
							// SwanExpression.g:190:13: WS
							{
							match(input,WS,FOLLOW_WS_in_parentheticalExpression845); 
							}
							break;

						default :
							break loop17;
						}
					}

					pushFollow(FOLLOW_orExpression_in_parentheticalExpression850);
					exp=orExpression();
					state._fsp--;

					// SwanExpression.g:190:34: ( WS )*
					loop18:
					while (true) {
						int alt18=2;
						int LA18_0 = input.LA(1);
						if ( (LA18_0==WS) ) {
							alt18=1;
						}

						switch (alt18) {
						case 1 :
							// SwanExpression.g:190:34: WS
							{
							match(input,WS,FOLLOW_WS_in_parentheticalExpression852); 
							}
							break;

						default :
							break loop18;
						}
					}

					match(input,42,FOLLOW_42_in_parentheticalExpression855); 
					expression = exp /* .expression */ ;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expression;
	}
	// $ANTLR end "parentheticalExpression"



	// $ANTLR start "multiplicativeExpression"
	// SwanExpression.g:194:1: multiplicativeExpression returns [Expression expression] : left= parentheticalExpression ( ( WS )* (location= ID '@' )? op= multiplicative_math_operator ( WS )* right= parentheticalExpression )* ;
	public final Expression multiplicativeExpression() throws RecognitionException {
		Expression expression = null;


		Token location=null;
		Expression left =null;
		MathOperator op =null;
		Expression right =null;


		    Stack<ValueExpression> rightStack = new Stack<ValueExpression>();
		    Stack<MathOperator> opStack = new Stack<MathOperator>();
		    Stack<String> locationStack = new Stack<String>();

		try {
			// SwanExpression.g:200:5: (left= parentheticalExpression ( ( WS )* (location= ID '@' )? op= multiplicative_math_operator ( WS )* right= parentheticalExpression )* )
			// SwanExpression.g:200:7: left= parentheticalExpression ( ( WS )* (location= ID '@' )? op= multiplicative_math_operator ( WS )* right= parentheticalExpression )*
			{
			pushFollow(FOLLOW_parentheticalExpression_in_multiplicativeExpression902);
			left=parentheticalExpression();
			state._fsp--;

			// SwanExpression.g:201:5: ( ( WS )* (location= ID '@' )? op= multiplicative_math_operator ( WS )* right= parentheticalExpression )*
			loop23:
			while (true) {
				int alt23=2;
				alt23 = dfa23.predict(input);
				switch (alt23) {
				case 1 :
					// SwanExpression.g:201:6: ( WS )* (location= ID '@' )? op= multiplicative_math_operator ( WS )* right= parentheticalExpression
					{
					// SwanExpression.g:201:6: ( WS )*
					loop20:
					while (true) {
						int alt20=2;
						int LA20_0 = input.LA(1);
						if ( (LA20_0==WS) ) {
							alt20=1;
						}

						switch (alt20) {
						case 1 :
							// SwanExpression.g:201:6: WS
							{
							match(input,WS,FOLLOW_WS_in_multiplicativeExpression909); 
							}
							break;

						default :
							break loop20;
						}
					}

					// SwanExpression.g:201:10: (location= ID '@' )?
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==ID) ) {
						alt21=1;
					}
					switch (alt21) {
						case 1 :
							// SwanExpression.g:201:11: location= ID '@'
							{
							location=(Token)match(input,ID,FOLLOW_ID_in_multiplicativeExpression915); 
							match(input,47,FOLLOW_47_in_multiplicativeExpression917); 
							}
							break;

					}

					pushFollow(FOLLOW_multiplicative_math_operator_in_multiplicativeExpression923);
					op=multiplicative_math_operator();
					state._fsp--;

					// SwanExpression.g:201:61: ( WS )*
					loop22:
					while (true) {
						int alt22=2;
						int LA22_0 = input.LA(1);
						if ( (LA22_0==WS) ) {
							alt22=1;
						}

						switch (alt22) {
						case 1 :
							// SwanExpression.g:201:61: WS
							{
							match(input,WS,FOLLOW_WS_in_multiplicativeExpression925); 
							}
							break;

						default :
							break loop22;
						}
					}

					pushFollow(FOLLOW_parentheticalExpression_in_multiplicativeExpression930);
					right=parentheticalExpression();
					state._fsp--;

					locationStack.push(location == null ? Expression.LOCATION_INFER : location.getText()); opStack.push(op /* .math_operator */ ); rightStack.push((ValueExpression) right /* .expression */ );
					}
					break;

				default :
					break loop23;
				}
			}


			    while(rightStack.size() > 1) {
			        ValueExpression temp = rightStack.pop();
			        rightStack.push(new MathValueExpression(locationStack.pop(), rightStack.pop(), opStack.pop(), temp, HistoryReductionMode.DEFAULT_MODE));
			    }
			    if (rightStack.size() > 0) {
			        expression = new MathValueExpression(locationStack.pop(), (ValueExpression) left /* .expression */ , opStack.pop(), rightStack.pop(), HistoryReductionMode.DEFAULT_MODE);
			    } else {
			        expression = left /* .expression */ ;
			    }

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expression;
	}
	// $ANTLR end "multiplicativeExpression"



	// $ANTLR start "additiveExpression"
	// SwanExpression.g:217:1: additiveExpression returns [Expression expression] : left= multiplicativeExpression ( (location= ID '@' )? op= additive_math_operator right= multiplicativeExpression )* ;
	public final Expression additiveExpression() throws RecognitionException {
		Expression expression = null;


		Token location=null;
		Expression left =null;
		MathOperator op =null;
		Expression right =null;


		    Stack<ValueExpression> rightStack = new Stack<ValueExpression>();
		    Stack<MathOperator> opStack = new Stack<MathOperator>();
		    Stack<String> locationStack = new Stack<String>();

		try {
			// SwanExpression.g:223:5: (left= multiplicativeExpression ( (location= ID '@' )? op= additive_math_operator right= multiplicativeExpression )* )
			// SwanExpression.g:223:7: left= multiplicativeExpression ( (location= ID '@' )? op= additive_math_operator right= multiplicativeExpression )*
			{
			pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression978);
			left=multiplicativeExpression();
			state._fsp--;

			// SwanExpression.g:224:5: ( (location= ID '@' )? op= additive_math_operator right= multiplicativeExpression )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==ID) ) {
					int LA25_2 = input.LA(2);
					if ( (LA25_2==47) ) {
						int LA25_4 = input.LA(3);
						if ( (LA25_4==MINUS||LA25_4==PLUS) ) {
							alt25=1;
						}

					}

				}
				else if ( (LA25_0==MINUS||LA25_0==PLUS) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// SwanExpression.g:224:6: (location= ID '@' )? op= additive_math_operator right= multiplicativeExpression
					{
					// SwanExpression.g:224:6: (location= ID '@' )?
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0==ID) ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// SwanExpression.g:224:7: location= ID '@'
							{
							location=(Token)match(input,ID,FOLLOW_ID_in_additiveExpression988); 
							match(input,47,FOLLOW_47_in_additiveExpression990); 
							}
							break;

					}

					pushFollow(FOLLOW_additive_math_operator_in_additiveExpression996);
					op=additive_math_operator();
					state._fsp--;

					pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1000);
					right=multiplicativeExpression();
					state._fsp--;

					locationStack.push(location == null ? Expression.LOCATION_INFER : location.getText()); opStack.push(op /* .math_operator */ ); rightStack.push((ValueExpression) right /* .expression */ );
					}
					break;

				default :
					break loop25;
				}
			}


			    while(rightStack.size() > 1) {
			        ValueExpression temp = rightStack.pop();
			        rightStack.push(new MathValueExpression(locationStack.pop(), rightStack.pop(), opStack.pop(), temp, HistoryReductionMode.DEFAULT_MODE));
			    }
			    if (rightStack.size() > 0) {
			        expression = new MathValueExpression(locationStack.pop(), (ValueExpression) left /* .expression */ , opStack.pop(), rightStack.pop(), HistoryReductionMode.DEFAULT_MODE);
			    } else {
			        expression = left /* .expression */ ;
			    }

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expression;
	}
	// $ANTLR end "additiveExpression"



	// $ANTLR start "comparativeExpression"
	// SwanExpression.g:240:1: comparativeExpression returns [Expression expression] : left= additiveExpression ( ( WS )* ( (location= ID )? c= comparator ) ( WS )* right= additiveExpression )? ;
	public final Expression comparativeExpression() throws RecognitionException {
		Expression expression = null;


		Token location=null;
		Expression left =null;
		Comparator c =null;
		Expression right =null;


		    Stack<Expression> rightStack = new Stack<Expression>();
		    Stack<Comparator> compareStack = new Stack<Comparator>();
		    Stack<String> locationStack = new Stack<String>();

		try {
			// SwanExpression.g:246:5: (left= additiveExpression ( ( WS )* ( (location= ID )? c= comparator ) ( WS )* right= additiveExpression )? )
			// SwanExpression.g:246:7: left= additiveExpression ( ( WS )* ( (location= ID )? c= comparator ) ( WS )* right= additiveExpression )?
			{
			pushFollow(FOLLOW_additiveExpression_in_comparativeExpression1048);
			left=additiveExpression();
			state._fsp--;

			// SwanExpression.g:247:5: ( ( WS )* ( (location= ID )? c= comparator ) ( WS )* right= additiveExpression )?
			int alt29=2;
			alt29 = dfa29.predict(input);
			switch (alt29) {
				case 1 :
					// SwanExpression.g:247:6: ( WS )* ( (location= ID )? c= comparator ) ( WS )* right= additiveExpression
					{
					// SwanExpression.g:247:6: ( WS )*
					loop26:
					while (true) {
						int alt26=2;
						int LA26_0 = input.LA(1);
						if ( (LA26_0==WS) ) {
							alt26=1;
						}

						switch (alt26) {
						case 1 :
							// SwanExpression.g:247:6: WS
							{
							match(input,WS,FOLLOW_WS_in_comparativeExpression1055); 
							}
							break;

						default :
							break loop26;
						}
					}

					// SwanExpression.g:247:10: ( (location= ID )? c= comparator )
					// SwanExpression.g:247:11: (location= ID )? c= comparator
					{
					// SwanExpression.g:247:11: (location= ID )?
					int alt27=2;
					int LA27_0 = input.LA(1);
					if ( (LA27_0==ID) ) {
						alt27=1;
					}
					switch (alt27) {
						case 1 :
							// SwanExpression.g:247:12: location= ID
							{
							location=(Token)match(input,ID,FOLLOW_ID_in_comparativeExpression1062); 
							}
							break;

					}

					pushFollow(FOLLOW_comparator_in_comparativeExpression1068);
					c=comparator();
					state._fsp--;

					}

					// SwanExpression.g:247:40: ( WS )*
					loop28:
					while (true) {
						int alt28=2;
						int LA28_0 = input.LA(1);
						if ( (LA28_0==WS) ) {
							alt28=1;
						}

						switch (alt28) {
						case 1 :
							// SwanExpression.g:247:40: WS
							{
							match(input,WS,FOLLOW_WS_in_comparativeExpression1071); 
							}
							break;

						default :
							break loop28;
						}
					}

					pushFollow(FOLLOW_additiveExpression_in_comparativeExpression1076);
					right=additiveExpression();
					state._fsp--;

					locationStack.push(location == null ? Expression.LOCATION_INFER : location.getText()); compareStack.push(c /* .comparator */ ); rightStack.push(right /* .expression */ );
					}
					break;

			}


			    while(rightStack.size() > 1) {
			        Expression temp = rightStack.pop();
			        rightStack.push(new ComparisonExpression(locationStack.pop(), (ValueExpression) rightStack.pop(), compareStack.pop(), (ValueExpression) temp));
			    }
			    if (rightStack.size() > 0) {
			        expression = new ComparisonExpression(locationStack.pop(), (ValueExpression) left /* .expression */ , compareStack.pop(), (ValueExpression) rightStack.pop());
			    } else {
			        expression = left /* .expression */ ;
			    }

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expression;
	}
	// $ANTLR end "comparativeExpression"



	// $ANTLR start "unaryExpression"
	// SwanExpression.g:263:1: unaryExpression returns [Expression expression] : ( (location= ID )? NOT exp= comparativeExpression |exp= comparativeExpression );
	public final Expression unaryExpression() throws RecognitionException {
		Expression expression = null;


		Token location=null;
		Expression exp =null;

		try {
			// SwanExpression.g:264:5: ( (location= ID )? NOT exp= comparativeExpression |exp= comparativeExpression )
			int alt31=2;
			switch ( input.LA(1) ) {
			case ID:
				{
				int LA31_1 = input.LA(2);
				if ( (LA31_1==47) ) {
					alt31=2;
				}
				else if ( (LA31_1==NOT) ) {
					alt31=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 31, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case NOT:
				{
				alt31=1;
				}
				break;
			case FLOAT:
			case INT:
			case STRING:
			case 41:
				{
				alt31=2;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}
			switch (alt31) {
				case 1 :
					// SwanExpression.g:264:7: (location= ID )? NOT exp= comparativeExpression
					{
					// SwanExpression.g:264:7: (location= ID )?
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0==ID) ) {
						alt30=1;
					}
					switch (alt30) {
						case 1 :
							// SwanExpression.g:264:8: location= ID
							{
							location=(Token)match(input,ID,FOLLOW_ID_in_unaryExpression1120); 
							}
							break;

					}

					match(input,NOT,FOLLOW_NOT_in_unaryExpression1124); 
					pushFollow(FOLLOW_comparativeExpression_in_unaryExpression1128);
					exp=comparativeExpression();
					state._fsp--;

					expression = new LogicExpression(location == null ? Expression.LOCATION_INFER : location.getText(), UnaryLogicOperator.NOT /* .logic_operator */ , (TriStateExpression) exp /* .expression */ );
					}
					break;
				case 2 :
					// SwanExpression.g:266:7: exp= comparativeExpression
					{
					pushFollow(FOLLOW_comparativeExpression_in_unaryExpression1149);
					exp=comparativeExpression();
					state._fsp--;

					expression = exp /* .expression */ ;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expression;
	}
	// $ANTLR end "unaryExpression"



	// $ANTLR start "andExpression"
	// SwanExpression.g:270:1: andExpression returns [Expression expression] : left= unaryExpression ( (location= ID '@' )? AND right= unaryExpression )* ;
	public final Expression andExpression() throws RecognitionException {
		Expression expression = null;


		Token location=null;
		Expression left =null;
		Expression right =null;


		    Stack<Expression> rightStack = new Stack<Expression>();
		    Stack<String> locationStack = new Stack<String>();

		try {
			// SwanExpression.g:275:5: (left= unaryExpression ( (location= ID '@' )? AND right= unaryExpression )* )
			// SwanExpression.g:275:7: left= unaryExpression ( (location= ID '@' )? AND right= unaryExpression )*
			{
			pushFollow(FOLLOW_unaryExpression_in_andExpression1188);
			left=unaryExpression();
			state._fsp--;

			// SwanExpression.g:276:5: ( (location= ID '@' )? AND right= unaryExpression )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==ID) ) {
					int LA33_1 = input.LA(2);
					if ( (LA33_1==47) ) {
						int LA33_4 = input.LA(3);
						if ( (LA33_4==AND) ) {
							alt33=1;
						}

					}

				}
				else if ( (LA33_0==AND) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// SwanExpression.g:276:6: (location= ID '@' )? AND right= unaryExpression
					{
					// SwanExpression.g:276:6: (location= ID '@' )?
					int alt32=2;
					int LA32_0 = input.LA(1);
					if ( (LA32_0==ID) ) {
						alt32=1;
					}
					switch (alt32) {
						case 1 :
							// SwanExpression.g:276:7: location= ID '@'
							{
							location=(Token)match(input,ID,FOLLOW_ID_in_andExpression1198); 
							match(input,47,FOLLOW_47_in_andExpression1200); 
							}
							break;

					}

					match(input,AND,FOLLOW_AND_in_andExpression1204); 
					pushFollow(FOLLOW_unaryExpression_in_andExpression1208);
					right=unaryExpression();
					state._fsp--;

					locationStack.push(location == null ? Expression.LOCATION_INFER : location.getText()); rightStack.push(right /* .expression */ );
					}
					break;

				default :
					break loop33;
				}
			}


			    while(rightStack.size() > 1) {
			        Expression temp = rightStack.pop();
			        rightStack.push(new LogicExpression(locationStack.pop(), (TriStateExpression) rightStack.pop(), BinaryLogicOperator.AND, (TriStateExpression) temp));
			    }
			    if (rightStack.size() > 0) {
			        expression = new LogicExpression(locationStack.pop(), (TriStateExpression) left /* .expression */ , BinaryLogicOperator.AND, (TriStateExpression) rightStack.pop());
			    } else {
			        expression = left /* .expression */ ;
			    }

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expression;
	}
	// $ANTLR end "andExpression"



	// $ANTLR start "orExpression"
	// SwanExpression.g:292:1: orExpression returns [Expression expression] : left= andExpression ( (location= ID '@' )? OR right= andExpression )* ;
	public final Expression orExpression() throws RecognitionException {
		Expression expression = null;


		Token location=null;
		Expression left =null;
		Expression right =null;


		    Stack<Expression> rightStack = new Stack<Expression>();
		    Stack<String> locationStack = new Stack<String>();

		try {
			// SwanExpression.g:297:5: (left= andExpression ( (location= ID '@' )? OR right= andExpression )* )
			// SwanExpression.g:297:7: left= andExpression ( (location= ID '@' )? OR right= andExpression )*
			{
			pushFollow(FOLLOW_andExpression_in_orExpression1256);
			left=andExpression();
			state._fsp--;

			// SwanExpression.g:298:5: ( (location= ID '@' )? OR right= andExpression )*
			loop35:
			while (true) {
				int alt35=2;
				int LA35_0 = input.LA(1);
				if ( (LA35_0==ID||LA35_0==OR) ) {
					alt35=1;
				}

				switch (alt35) {
				case 1 :
					// SwanExpression.g:298:6: (location= ID '@' )? OR right= andExpression
					{
					// SwanExpression.g:298:6: (location= ID '@' )?
					int alt34=2;
					int LA34_0 = input.LA(1);
					if ( (LA34_0==ID) ) {
						alt34=1;
					}
					switch (alt34) {
						case 1 :
							// SwanExpression.g:298:7: location= ID '@'
							{
							location=(Token)match(input,ID,FOLLOW_ID_in_orExpression1266); 
							match(input,47,FOLLOW_47_in_orExpression1268); 
							}
							break;

					}

					match(input,OR,FOLLOW_OR_in_orExpression1272); 
					pushFollow(FOLLOW_andExpression_in_orExpression1276);
					right=andExpression();
					state._fsp--;

					locationStack.push(location == null ? Expression.LOCATION_INFER : location.getText()); rightStack.push(right /* .expression */ );
					}
					break;

				default :
					break loop35;
				}
			}


			    while(rightStack.size() > 1) {
			        Expression temp = rightStack.pop();
			        rightStack.push(new LogicExpression(locationStack.pop(), (TriStateExpression) rightStack.pop(), BinaryLogicOperator.OR, (TriStateExpression) temp));
			    }
			    if (rightStack.size() > 0) {
			        expression = new LogicExpression(locationStack.pop(), (TriStateExpression) left /* .expression */ , BinaryLogicOperator.OR, (TriStateExpression) rightStack.pop());
			    } else {
			        expression = left /* .expression */ ;
			    }

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expression;
	}
	// $ANTLR end "orExpression"



	// $ANTLR start "expression"
	// SwanExpression.g:314:1: expression returns [Expression expression] : logic= orExpression EOF ;
	public final Expression expression() throws RecognitionException {
		Expression expression = null;


		Expression logic =null;

		try {
			// SwanExpression.g:315:5: (logic= orExpression EOF )
			// SwanExpression.g:316:5: logic= orExpression EOF
			{
			pushFollow(FOLLOW_orExpression_in_expression1326);
			logic=orExpression();
			state._fsp--;

			match(input,EOF,FOLLOW_EOF_in_expression1328); 
			expression = logic /* .expression */ ;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expression;
	}
	// $ANTLR end "expression"



	// $ANTLR start "time_value"
	// SwanExpression.g:321:1: time_value returns [Long time] : val= INT (unit= TIME_UNIT )? (rep_val= INT (rep_unit= TIME_UNIT )? )* ;
	public final Long time_value() throws RecognitionException {
		Long time = null;


		Token val=null;
		Token unit=null;
		Token rep_val=null;
		Token rep_unit=null;

		try {
			// SwanExpression.g:322:5: (val= INT (unit= TIME_UNIT )? (rep_val= INT (rep_unit= TIME_UNIT )? )* )
			// SwanExpression.g:323:5: val= INT (unit= TIME_UNIT )? (rep_val= INT (rep_unit= TIME_UNIT )? )*
			{
			val=(Token)match(input,INT,FOLLOW_INT_in_time_value1366); 
			// SwanExpression.g:323:17: (unit= TIME_UNIT )?
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==TIME_UNIT) ) {
				alt36=1;
			}
			switch (alt36) {
				case 1 :
					// SwanExpression.g:323:17: unit= TIME_UNIT
					{
					unit=(Token)match(input,TIME_UNIT,FOLLOW_TIME_UNIT_in_time_value1370); 
					}
					break;

			}

			 long theTime = convertTime(val, unit); 
			// SwanExpression.g:325:5: (rep_val= INT (rep_unit= TIME_UNIT )? )*
			loop38:
			while (true) {
				int alt38=2;
				int LA38_0 = input.LA(1);
				if ( (LA38_0==INT) ) {
					alt38=1;
				}

				switch (alt38) {
				case 1 :
					// SwanExpression.g:325:6: rep_val= INT (rep_unit= TIME_UNIT )?
					{
					rep_val=(Token)match(input,INT,FOLLOW_INT_in_time_value1387); 
					// SwanExpression.g:325:26: (rep_unit= TIME_UNIT )?
					int alt37=2;
					int LA37_0 = input.LA(1);
					if ( (LA37_0==TIME_UNIT) ) {
						alt37=1;
					}
					switch (alt37) {
						case 1 :
							// SwanExpression.g:325:26: rep_unit= TIME_UNIT
							{
							rep_unit=(Token)match(input,TIME_UNIT,FOLLOW_TIME_UNIT_in_time_value1391); 
							}
							break;

					}

					 theTime += convertTime(rep_val, rep_unit);
					}
					break;

				default :
					break loop38;
				}
			}

			time = new Long(theTime);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return time;
	}
	// $ANTLR end "time_value"

	// Delegated rules


	protected DFA14 dfa14 = new DFA14(this);
	protected DFA23 dfa23 = new DFA23(this);
	protected DFA29 dfa29 = new DFA29(this);
	static final String DFA14_eotS =
		"\24\uffff";
	static final String DFA14_eofS =
		"\5\uffff\2\10\4\uffff\2\10\1\uffff\1\20\4\uffff\1\20";
	static final String DFA14_minS =
		"\1\24\1\57\1\24\1\55\1\24\2\5\1\24\1\uffff\1\24\1\uffff\2\5\1\12\1\5\1"+
		"\24\2\uffff\1\12\1\5";
	static final String DFA14_maxS =
		"\1\24\1\57\1\24\1\55\1\45\2\56\1\45\1\uffff\1\24\1\uffff\2\56\1\12\1\52"+
		"\1\24\2\uffff\1\12\1\52";
	static final String DFA14_acceptS =
		"\10\uffff\1\1\1\uffff\1\3\5\uffff\1\2\1\4\2\uffff";
	static final String DFA14_specialS =
		"\24\uffff}>";
	static final String[] DFA14_transitionS = {
			"\1\1",
			"\1\2",
			"\1\3",
			"\1\4",
			"\1\5\20\uffff\1\6",
			"\1\10\5\uffff\3\10\3\uffff\2\10\1\uffff\1\10\1\uffff\2\10\4\uffff\3"+
			"\10\2\uffff\4\10\2\uffff\1\10\1\12\1\uffff\1\10\1\uffff\1\7\1\uffff\1"+
			"\11",
			"\1\10\5\uffff\3\10\3\uffff\2\10\1\uffff\1\10\1\uffff\2\10\4\uffff\3"+
			"\10\2\uffff\4\10\2\uffff\1\10\1\12\1\uffff\1\10\1\uffff\1\7\1\uffff\1"+
			"\11",
			"\1\13\20\uffff\1\14",
			"",
			"\1\15",
			"",
			"\1\10\5\uffff\3\10\3\uffff\2\10\1\uffff\1\10\1\uffff\2\10\4\uffff\3"+
			"\10\2\uffff\4\10\2\uffff\1\10\1\12\1\uffff\1\10\1\uffff\1\7\1\uffff\1"+
			"\11",
			"\1\10\5\uffff\3\10\3\uffff\2\10\1\uffff\1\10\1\uffff\2\10\4\uffff\3"+
			"\10\2\uffff\4\10\2\uffff\1\10\1\12\1\uffff\1\10\1\uffff\1\7\1\uffff\1"+
			"\11",
			"\1\16",
			"\1\20\1\uffff\1\17\3\uffff\3\20\3\uffff\2\20\1\uffff\1\20\1\uffff\2"+
			"\20\4\uffff\3\20\2\uffff\4\20\2\uffff\1\20\1\21\1\uffff\1\20",
			"\1\22",
			"",
			"",
			"\1\23",
			"\1\20\1\uffff\1\17\3\uffff\3\20\3\uffff\2\20\1\uffff\1\20\1\uffff\2"+
			"\20\4\uffff\3\20\2\uffff\4\20\2\uffff\1\20\1\21\1\uffff\1\20"
	};

	static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
	static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
	static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
	static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
	static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
	static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
	static final short[][] DFA14_transition;

	static {
		int numStates = DFA14_transitionS.length;
		DFA14_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
		}
	}

	protected class DFA14 extends DFA {

		public DFA14(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 14;
			this.eot = DFA14_eot;
			this.eof = DFA14_eof;
			this.min = DFA14_min;
			this.max = DFA14_max;
			this.accept = DFA14_accept;
			this.special = DFA14_special;
			this.transition = DFA14_transition;
		}
		@Override
		public String getDescription() {
			return "152:1: sensor_value_expression returns [SensorValueExpression value_expression] : (location= ID '@' entity= ID ':' path= value_path |location= ID '@' entity= ID ':' path= value_path '?' config= configuration_options |location= ID '@' entity= ID ':' path= value_path '$' http_config= http_configuration_options '{' ( (mode= history_mode ',' time= time_value ) |mode= history_mode |time= time_value ) '}' |location= ID '@' entity= ID ':' path= value_path '?' config= configuration_options '$' http_config= http_configuration_options '{' ( (mode= history_mode ',' time= time_value ) |mode= history_mode |time= time_value ) '}' );";
		}
	}

	static final String DFA23_eotS =
		"\7\uffff";
	static final String DFA23_eofS =
		"\1\2\6\uffff";
	static final String DFA23_minS =
		"\1\5\1\13\1\uffff\1\13\1\uffff\1\5\1\13";
	static final String DFA23_maxS =
		"\1\52\1\57\1\uffff\1\52\1\uffff\1\43\1\57";
	static final String DFA23_acceptS =
		"\2\uffff\1\2\1\uffff\1\1\2\uffff";
	static final String DFA23_specialS =
		"\7\uffff}>";
	static final String[] DFA23_transitionS = {
			"\1\2\5\uffff\1\2\1\4\1\2\3\uffff\2\2\1\uffff\1\1\1\uffff\2\2\4\uffff"+
			"\1\2\2\4\2\uffff\4\2\2\uffff\1\3\2\uffff\1\2",
			"\1\2\1\uffff\1\2\3\uffff\2\2\3\uffff\2\2\11\uffff\1\2\2\uffff\1\2\12"+
			"\uffff\1\5",
			"",
			"\1\2\1\4\1\2\3\uffff\2\2\1\uffff\1\6\1\uffff\2\2\5\uffff\2\4\2\uffff"+
			"\1\2\2\uffff\1\2\2\uffff\1\3\2\uffff\1\2",
			"",
			"\1\2\6\uffff\1\4\17\uffff\1\2\2\4\3\uffff\2\2",
			"\1\2\1\uffff\1\2\3\uffff\2\2\3\uffff\2\2\11\uffff\1\2\2\uffff\1\2\12"+
			"\uffff\1\4"
	};

	static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
	static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
	static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
	static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
	static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
	static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
	static final short[][] DFA23_transition;

	static {
		int numStates = DFA23_transitionS.length;
		DFA23_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
		}
	}

	protected class DFA23 extends DFA {

		public DFA23(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 23;
			this.eot = DFA23_eot;
			this.eof = DFA23_eof;
			this.min = DFA23_min;
			this.max = DFA23_max;
			this.accept = DFA23_accept;
			this.special = DFA23_special;
			this.transition = DFA23_transition;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 201:5: ( ( WS )* (location= ID '@' )? op= multiplicative_math_operator ( WS )* right= parentheticalExpression )*";
		}
	}

	static final String DFA29_eotS =
		"\5\uffff";
	static final String DFA29_eofS =
		"\1\4\4\uffff";
	static final String DFA29_minS =
		"\1\5\2\13\2\uffff";
	static final String DFA29_maxS =
		"\2\52\1\57\2\uffff";
	static final String DFA29_acceptS =
		"\3\uffff\1\1\1\2";
	static final String DFA29_specialS =
		"\5\uffff}>";
	static final String[] DFA29_transitionS = {
			"\1\4\5\uffff\1\3\1\uffff\1\3\3\uffff\2\3\1\uffff\1\2\1\uffff\2\3\11\uffff"+
			"\1\3\1\4\1\uffff\1\3\2\uffff\1\1\2\uffff\1\4",
			"\1\3\1\uffff\1\3\3\uffff\2\3\1\uffff\1\3\1\uffff\2\3\11\uffff\1\3\2"+
			"\uffff\1\3\2\uffff\1\1\2\uffff\1\4",
			"\1\3\1\uffff\1\3\3\uffff\2\3\3\uffff\2\3\11\uffff\1\3\2\uffff\1\3\12"+
			"\uffff\1\4",
			"",
			""
	};

	static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
	static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
	static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
	static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
	static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
	static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
	static final short[][] DFA29_transition;

	static {
		int numStates = DFA29_transitionS.length;
		DFA29_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
		}
	}

	protected class DFA29 extends DFA {

		public DFA29(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 29;
			this.eot = DFA29_eot;
			this.eof = DFA29_eof;
			this.min = DFA29_min;
			this.max = DFA29_max;
			this.accept = DFA29_accept;
			this.special = DFA29_special;
			this.transition = DFA29_transition;
		}
		@Override
		public String getDescription() {
			return "247:5: ( ( WS )* ( (location= ID )? c= comparator ) ( WS )* right= additiveExpression )?";
		}
	}

	public static final BitSet FOLLOW_ID_in_http_configuration_options62 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CONFIG_VAL_in_http_configuration_options66 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_CONFIG_TILT_in_http_configuration_options76 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_http_configuration_options80 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CONFIG_VAL_in_http_configuration_options84 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_ID_in_configuration_options120 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CONFIG_VAL_in_configuration_options124 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_CONFIG_HASH_in_configuration_options134 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_configuration_options138 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_CONFIG_VAL_in_configuration_options142 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_v_p_in_value_path178 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_44_in_value_path187 = new BitSet(new long[]{0x0000002000100000L});
	public static final BitSet FOLLOW_v_p_in_value_path191 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_ID_in_v_p223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_v_p232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GT_in_comparator249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LT_in_comparator256 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GTEQ_in_comparator263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LTEQ_in_comparator270 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQUALS_in_comparator277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOTEQUALS_in_comparator284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REGEX_in_comparator291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONTAINS_in_comparator298 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binary_logic_operator_in_logic_operator320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unary_logic_operator_in_logic_operator333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_binary_logic_operator354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_binary_logic_operator361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_unary_logic_operator378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_additive_math_operator_in_math_operator397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multiplicative_math_operator_in_math_operator406 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_additive_math_operator423 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_additive_math_operator430 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_multiplicative_math_operator448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_multiplicative_math_operator455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_multiplicative_math_operator462 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALL_in_history_mode479 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAX_in_history_mode486 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MIN_in_history_mode493 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MEAN_in_history_mode500 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MEDIAN_in_history_mode507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ANY_in_history_mode514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_sensor_value_expression535 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_sensor_value_expression537 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_sensor_value_expression541 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_sensor_value_expression543 = new BitSet(new long[]{0x0000002000100000L});
	public static final BitSet FOLLOW_value_path_in_sensor_value_expression547 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_sensor_value_expression559 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_sensor_value_expression561 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_sensor_value_expression565 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_sensor_value_expression567 = new BitSet(new long[]{0x0000002000100000L});
	public static final BitSet FOLLOW_value_path_in_sensor_value_expression571 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_sensor_value_expression573 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_configuration_options_in_sensor_value_expression577 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_sensor_value_expression589 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_sensor_value_expression591 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_sensor_value_expression595 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_sensor_value_expression597 = new BitSet(new long[]{0x0000002000100000L});
	public static final BitSet FOLLOW_value_path_in_sensor_value_expression601 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_sensor_value_expression603 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_http_configuration_options_in_sensor_value_expression607 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_48_in_sensor_value_expression609 = new BitSet(new long[]{0x000000000F200050L});
	public static final BitSet FOLLOW_history_mode_in_sensor_value_expression615 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_sensor_value_expression617 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_time_value_in_sensor_value_expression621 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_history_mode_in_sensor_value_expression628 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_time_value_in_sensor_value_expression634 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_sensor_value_expression637 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_sensor_value_expression649 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_sensor_value_expression651 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_sensor_value_expression655 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_sensor_value_expression657 = new BitSet(new long[]{0x0000002000100000L});
	public static final BitSet FOLLOW_value_path_in_sensor_value_expression661 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_sensor_value_expression663 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_configuration_options_in_sensor_value_expression667 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_sensor_value_expression669 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_http_configuration_options_in_sensor_value_expression673 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_48_in_sensor_value_expression675 = new BitSet(new long[]{0x000000000F200050L});
	public static final BitSet FOLLOW_history_mode_in_sensor_value_expression681 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_sensor_value_expression683 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_time_value_in_sensor_value_expression687 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_history_mode_in_sensor_value_expression694 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_time_value_in_sensor_value_expression700 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_sensor_value_expression703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_constant_value_expression725 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_constant_value_expression738 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_constant_value_expression752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constant_value_expression_in_value_expression775 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sensor_value_expression_in_value_expression789 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_expression_in_parentheticalExpression818 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_parentheticalExpression843 = new BitSet(new long[]{0x000002A100310000L});
	public static final BitSet FOLLOW_WS_in_parentheticalExpression845 = new BitSet(new long[]{0x000002A100310000L});
	public static final BitSet FOLLOW_orExpression_in_parentheticalExpression850 = new BitSet(new long[]{0x0000048000000000L});
	public static final BitSet FOLLOW_WS_in_parentheticalExpression852 = new BitSet(new long[]{0x0000048000000000L});
	public static final BitSet FOLLOW_42_in_parentheticalExpression855 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_parentheticalExpression_in_multiplicativeExpression902 = new BitSet(new long[]{0x0000008060101002L});
	public static final BitSet FOLLOW_WS_in_multiplicativeExpression909 = new BitSet(new long[]{0x0000008060101000L});
	public static final BitSet FOLLOW_ID_in_multiplicativeExpression915 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_multiplicativeExpression917 = new BitSet(new long[]{0x0000000060001000L});
	public static final BitSet FOLLOW_multiplicative_math_operator_in_multiplicativeExpression923 = new BitSet(new long[]{0x000002A000310000L});
	public static final BitSet FOLLOW_WS_in_multiplicativeExpression925 = new BitSet(new long[]{0x000002A000310000L});
	public static final BitSet FOLLOW_parentheticalExpression_in_multiplicativeExpression930 = new BitSet(new long[]{0x0000008060101002L});
	public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression978 = new BitSet(new long[]{0x0000000810100002L});
	public static final BitSet FOLLOW_ID_in_additiveExpression988 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_additiveExpression990 = new BitSet(new long[]{0x0000000810000000L});
	public static final BitSet FOLLOW_additive_math_operator_in_additiveExpression996 = new BitSet(new long[]{0x0000022000310000L});
	public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1000 = new BitSet(new long[]{0x0000000810100002L});
	public static final BitSet FOLLOW_additiveExpression_in_comparativeExpression1048 = new BitSet(new long[]{0x0000009200D62802L});
	public static final BitSet FOLLOW_WS_in_comparativeExpression1055 = new BitSet(new long[]{0x0000009200D62800L});
	public static final BitSet FOLLOW_ID_in_comparativeExpression1062 = new BitSet(new long[]{0x0000001200C62800L});
	public static final BitSet FOLLOW_comparator_in_comparativeExpression1068 = new BitSet(new long[]{0x000002A000310000L});
	public static final BitSet FOLLOW_WS_in_comparativeExpression1071 = new BitSet(new long[]{0x000002A000310000L});
	public static final BitSet FOLLOW_additiveExpression_in_comparativeExpression1076 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_unaryExpression1120 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_NOT_in_unaryExpression1124 = new BitSet(new long[]{0x0000022000310000L});
	public static final BitSet FOLLOW_comparativeExpression_in_unaryExpression1128 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comparativeExpression_in_unaryExpression1149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unaryExpression_in_andExpression1188 = new BitSet(new long[]{0x0000000000100022L});
	public static final BitSet FOLLOW_ID_in_andExpression1198 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_andExpression1200 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_AND_in_andExpression1204 = new BitSet(new long[]{0x0000022100310000L});
	public static final BitSet FOLLOW_unaryExpression_in_andExpression1208 = new BitSet(new long[]{0x0000000000100022L});
	public static final BitSet FOLLOW_andExpression_in_orExpression1256 = new BitSet(new long[]{0x0000000400100002L});
	public static final BitSet FOLLOW_ID_in_orExpression1266 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_orExpression1268 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_OR_in_orExpression1272 = new BitSet(new long[]{0x0000022100310000L});
	public static final BitSet FOLLOW_andExpression_in_orExpression1276 = new BitSet(new long[]{0x0000000400100002L});
	public static final BitSet FOLLOW_orExpression_in_expression1326 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_expression1328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_time_value1366 = new BitSet(new long[]{0x0000004000200002L});
	public static final BitSet FOLLOW_TIME_UNIT_in_time_value1370 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_INT_in_time_value1387 = new BitSet(new long[]{0x0000004000200002L});
	public static final BitSet FOLLOW_TIME_UNIT_in_time_value1391 = new BitSet(new long[]{0x0000000000200002L});
}
