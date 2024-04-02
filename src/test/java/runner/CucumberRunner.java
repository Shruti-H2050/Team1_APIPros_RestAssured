package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"D:\\Keertana SDET Course\\workspace\\Team1_APIPros_RestAssured\\src\\test\\resources\\featurefiles\\a_ProgMod_Positive.feature",
    "D:\\Keertana SDET Course\\workspace\\Team1_APIPros_RestAssured\\src\\test\\resources\\featurefiles\\b_ProgBat_Positive.feature"},
    glue = {"stepdefinition"},
    tags = "", // Tags to include (logical OR)
    		monochrome = true, plugin =  {"pretty","html:target/html folder/html reports.html",
    				  "pretty","json: target/json folder/json reports.json",
    				  "pretty","junit: target/junit folder/junit reports.xml"}
)
public class CucumberRunner {
    // This class doesn't have any code, it's just for running Cucumber tests
}
//@Post1 or @Post2 or @PutProgramid or @PutProgramName1