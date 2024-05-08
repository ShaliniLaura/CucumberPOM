package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="src//test//resources//features//PlaceOrder.feature",
		glue={"stepDefs"},
		dryRun=false,
		monochrome=true,
		plugin={"pretty", "html:target/reports/HtmlReport.html"}
		)

public class MyTestRunner extends AbstractTestNGCucumberTests {

}
