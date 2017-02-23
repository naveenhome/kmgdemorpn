package rpn.calculator;
import java.util.*;

public class RPNFactory {
	public static final Map<String, Operation> calculatorMap = new HashMap<String, Operation>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		put("+", new AdditionOperation());
		put("%", new PercentageOperation());
		put("-", new SubstractionOperation());
		put("*", new MultiplyOperation());
	}};
	public RPNFactory()
	{
		super();
	}
}
