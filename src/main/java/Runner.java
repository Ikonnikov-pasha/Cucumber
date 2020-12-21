import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/scenarios/firstScenario.feature",
        glue = "steps",
        tags = "@1"
)
public class Runner {

    @Test
    public static void run(String[] args) {

    }
}