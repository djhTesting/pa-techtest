package techtest.bdd.run;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)

@CucumberOptions(

		features = {"src/"},
		
		plugin = {"pretty",
		
		"html:target/cucumber-html-report",
		
		"junit:target/cucumber-junit-report/allcukes.xml"},
		
		glue = {"techtest.bdd.steps"}
		
		,tags = {"@failTest"}

)

public class RunCukesTests {
}