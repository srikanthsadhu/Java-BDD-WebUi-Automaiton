package com.example.automation;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//        features = {"classpath:com.example.automation.features"},
        plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber.json"},
//        tags = {"@tag1"},
//        glue={"helpers","step"},
//		dryRun = true,
        monochrome = true
)
public class RunCukesTest{

}

