package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C://Users//Pixel Mechanics//git//repository//Starwood project//StarwoodProjects//Features//paypal.feature:3",
glue="com.starwood.qa.stepdefinitions"
)		
public class TestRunner {

}
