package co.com.sofka.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/zona_fit.feature"},
        glue ={"co.com.sofka.stepdefinition"},
        publish = true
)
public class ZonaFitTestCucumber {

}
