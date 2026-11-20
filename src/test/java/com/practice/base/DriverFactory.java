package com.practice.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public final class DriverFactory {
 private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
 private DriverFactory() {}
 public static void createDriver() {
  ChromeOptions options = new ChromeOptions();
  if (Boolean.parseBoolean(System.getProperty("headless", "false"))) options.addArguments("--headless=new", "--window-size=1440,900");
  DRIVER.set(new ChromeDriver(options));
  getDriver().manage().window().maximize();
 }
 public static WebDriver getDriver() { return DRIVER.get(); }
 public static void quitDriver() { WebDriver driver=DRIVER.get(); if(driver!=null) {driver.quit(); DRIVER.remove();} }
}
