package rpn.calculator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.*;;

public class RPNSteps {
	String input;
	@Given("^User enter \"([^\"]*)\" in format below$")
	public void user_enter_in_format_below(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		input = arg1;
	}

	@Then("^Result should be \"([^\"]*)\" in below format$")
	public void result_should_be_in_below_format(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		RPNCalculator calculator = new RPNCalculator();
		Assert.assertEquals(arg1, String.valueOf(calculator.Calculate(input)));
	}


}
