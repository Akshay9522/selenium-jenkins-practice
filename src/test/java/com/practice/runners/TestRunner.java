package com.practice.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src/test/resources/features", glue={"com.practice.stepdefinitions","com.practice.hooks"}, plugin={"pretty","summary","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","html:target/cucumber-report.html"})
public class TestRunner extends AbstractTestNGCucumberTests { }
