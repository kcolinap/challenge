package org.challenge.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.challenge.core.managers.driver.DriverManager;
import org.challenge.core.utils.Utils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"org.challenge.steps" },
        plugin = { "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"},
        monochrome = true,
        tags = "@Challenge"
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public static void setUp() throws IOException {
        Utils.setProperties();
        DriverManager.init();
    }

    @AfterSuite
    public static void tearDown() throws IOException {
        DriverManager.finish();
    }
}
