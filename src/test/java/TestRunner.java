package runner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/features", // مسار ملفات .feature
            glue = "steps" // مسار تعريف الخطوات
    )
    public class TestRunner {

    }

