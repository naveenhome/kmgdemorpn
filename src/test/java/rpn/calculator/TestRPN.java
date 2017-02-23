package rpn.calculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRPN {
	
	RPNCalculator rpn;
	
	@Before
	public void setup()
	{
		rpn = new RPNCalculator();
	}
	
	@After
	public void tearDown()
	{
		rpn=null;
	}
	@Test
	public void testTwoOperandAndOneOperator() throws Exception
	{
		
		String expression = "20,25,+";
		assertEquals(45, rpn.Calculate(expression));
	}
	
	@Test
	public void testTwoOperandAndOneOperatorForCrossCheck() throws Exception
	{
		
		String expression = "25,25,+";
		assertEquals(50, rpn.Calculate(expression));
	}
	@Test public void testEmptyExpression()
	{
		try{
			String expression = " ";
			@SuppressWarnings("unused")
			int result = rpn.Calculate(expression);
			
		}catch(Exception ex)
		{
			assertEquals("Expression is empty", ex.getMessage());
		}
	}
	@Test public void testOneValueAndOperator()
	{
		try{
			String expression = "2,+";
			@SuppressWarnings("unused")
			int result = rpn.Calculate(expression);
			
		}catch(Exception ex)
		{
			assertEquals("Expression is not valid", ex.getMessage());
		}
	}
	@Test
	public void testMultiplyWithtwoValue() throws Exception
	{
		String expression = "2,3,*";
		assertEquals(5, rpn.Calculate(expression));
	}
	@Test public void testTwoValueAndNoOperator()
	{
		try{
			String expression = "2,2";
			@SuppressWarnings("unused")
			int result = rpn.Calculate(expression);
			fail();
			
		}catch(Exception ex)
		{
			assertEquals("Expression is not valid", ex.getMessage());
		}
	}
	@Test public void testThreeValueAndOneOperator()
	{
		try{
			String expression = "2,2,+,2";
			@SuppressWarnings("unused")
			int result = rpn.Calculate(expression);
			fail();
			
		}catch(Exception ex)
		{
			assertEquals("Expression is not valid", ex.getMessage());
		}
	}
	@Test public void testThreeValueAndOneOperatorAtEnd()
	{
		try{
			String expression = "2,2,5,+";
			@SuppressWarnings("unused")
			int result = rpn.Calculate(expression);
			fail();
			
		}catch(Exception ex)
		{
			assertEquals("Expression is not valid", ex.getMessage());
		}
	}
	@Test public void testOneValueAndNoOperator()
	{
		try{
			String expression = "2";
			@SuppressWarnings("unused")
			int result = rpn.Calculate(expression);
			fail();
			
		}catch(Exception ex)
		{
			assertEquals("Expression length must be minimum 2 in case of unary and 2 in case of binary operator.", ex.getMessage());
		}
	}
	@Test public void testAlphabetsInExpression()
	{
		try{
			String expression = "2,2,a";
			@SuppressWarnings("unused")
			int result = rpn.Calculate(expression);
			fail();
			
		}catch(Exception ex)
		{
			assertEquals("Alphabets are not allowed.", ex.getMessage());
		}
	}
	@Test
	public void testSubstractWithTwoValueAndOneOperator() throws Exception
	{
		String expression = "25,24,-";
		assertEquals(1, rpn.Calculate(expression));
	}
	@Test
	public void testSubstractWithThreeValueAndTwoOperator() throws Exception
	{
		String expression = "25,24,-,4,+";
		assertEquals(5, rpn.Calculate(expression));
	}
	@Test
	public void testFactoryForAdittion()
	{
		assertTrue(RPNFactory.calculatorMap.get("+") instanceof AdditionOperation);
		AdditionOperation obj = new AdditionOperation();
		assertSame(obj.getClass(), (RPNFactory.calculatorMap.get("+")).getClass());
	}
	@Test
	public void testFactoryForSubstract()
	{
		assertTrue(RPNFactory.calculatorMap.get("-") instanceof SubstractionOperation);
		SubstractionOperation obj = new SubstractionOperation();
		assertSame(obj.getClass(), (RPNFactory.calculatorMap.get("-")).getClass());
	}
	@Test
	public void testFactoryForPercentage()
	{
		assertTrue(RPNFactory.calculatorMap.get("%") instanceof PercentageOperation);
		PercentageOperation obj = new PercentageOperation();
		assertSame(obj.getClass(), (RPNFactory.calculatorMap.get("%")).getClass());
	}
	@Test
	public void testPercentageWithOneValueAndOneOperator() throws Exception
	{
		String expression = "200,%";
		assertEquals(2, rpn.Calculate(expression));	
	}
}
