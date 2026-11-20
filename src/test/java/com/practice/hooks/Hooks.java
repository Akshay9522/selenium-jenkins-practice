package com.practice.hooks;
import com.practice.base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class Hooks {
 @Before public void setup() {
  DriverFactory.createDriver();
  DriverFactory.getDriver().get(System.getProperty("baseUrl", "https://www.saucedemo.com/"));
 }
 @After public void teardown(Scenario scenario) {
  try {
   if(scenario.isFailed() && DriverFactory.getDriver()!=null) {
    byte[] png=((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    scenario.attach(png,"image/png","Failure screenshot");
   }
  } finally {DriverFactory.quitDriver();}
 }
}
