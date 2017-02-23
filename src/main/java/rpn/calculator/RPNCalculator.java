package rpn.calculator;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RPNCalculator {

	public int Calculate(String expression) throws Exception {
		String [] input;
		Stack<Integer> RPNStack = new Stack<Integer>();
		input = SplitExpression(expression);
		for(int i=0; i<input.length;i++)
		{
			if(IsOperator(input[i]))
			{
				if(input[i].equals("%"))
				{
					int firstValue;
					Validate(RPNStack, input[i]);
					UnaryOperation calculation = (UnaryOperation) RPNFactory.calculatorMap.get(input[i]);
					firstValue=RPNStack.pop();
					RPNStack.push(calculation.Calculate(firstValue));
				}
				else
				{
					int firstValue, secondValue;
					Validate(RPNStack, input[i]);
					BinaryOperation calculation = (BinaryOperation) RPNFactory.calculatorMap.get(input[i]);
					secondValue=RPNStack.pop();
					firstValue=RPNStack.pop();
					RPNStack.push(calculation.Calculate(firstValue, secondValue));
				}
			}
			else
			{
				Pattern pattern = Pattern.compile(new String ("^[a-zA-Z]"));
			    Matcher matcher = pattern.matcher(input[i]);
			    if(matcher.matches())
			    {
			    	throw new Exception("Alphabets are not allowed.");
			    }
				RPNStack.push(Integer.parseInt(input[i]));
			}
		}
		if(RPNStack.size()>1)
			throw new Exception("Expression is not valid");
		return RPNStack.pop();
	}

	private boolean IsOperator(String operator) {
		return RPNFactory.calculatorMap.containsKey(operator);
	}

	private void Validate(Stack<Integer> RPNStack, String operator) throws Exception {
		if(operator.equals("+"))
		{
			if(RPNStack.size()<2)
				throw new Exception("Expression is not valid");
		}
	}

	private String[] SplitExpression(String expression) throws Exception {
		if(expression.length()<=0||expression.equals(" "))
			throw new Exception ("Expression is empty");
		else if(expression.length()==1)
			throw new Exception ("Expression length must be minimum 2 in case of unary and 2 in case of binary operator.");
		else
			return expression.split(",");
	}

}
