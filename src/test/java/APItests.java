import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:cucumber/cucumber.html", "json:cucumber/cucumber.json", "junit:cucumber/cucumber.xml"},
        features = {"classpath:features"},
        glue = {"steps"},
        monochrome = true
)
public class APItests {
}
