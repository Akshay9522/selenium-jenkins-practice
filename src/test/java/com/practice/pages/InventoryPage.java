package com.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InventoryPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By title = By.cssSelector("[data-test='title']");
    private final By menu = By.id("react-burger-menu-btn");
    private final By logout = By.id("logout_sidebar_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String heading() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
    }
}
