package com.practice.pages;
import com.practice.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class LoginPage {
 private final WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(15));
 public void login(String username, String password) {
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);
  DriverFactory.getDriver().findElement(By.id("password")).sendKeys(password);
  DriverFactory.getDriver().findElement(By.id("login-button")).click();
 }
 public String errorMessage() {return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']"))).getText();}
 public boolean isLoginVisible() {return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).isDisplayed();}
}
