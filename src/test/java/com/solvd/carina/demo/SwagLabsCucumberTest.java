package com.solvd.carina.demo;

import com.zebrunner.carina.cucumber.CucumberBaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/SwagLabsOrders.feature",
        glue = "com.solvd.carina.demo.cucumber.steps.SwagLabsOrdersSteps",
        plugin={"pretty",
                "html:target/cucumber-core-test-report",
                "pretty:target/cucumber-core-test-report.txt",
                "json:target/cucumber-core-test-report.json",
                "junit:target/cucumber-core-test-report.xml"}
)
public class SwagLabsCucumberTest extends CucumberBaseTest {
}