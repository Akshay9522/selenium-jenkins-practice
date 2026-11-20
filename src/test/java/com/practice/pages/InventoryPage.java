package com.practice.pages;
import com.practice.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class InventoryPage {
 private final WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(15));
 public String heading() {return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='title']"))).getText();}
 public void logout() {
  wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn"))).click();
  wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();
 }
}
