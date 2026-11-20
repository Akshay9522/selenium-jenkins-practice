package com.practice.tests;

import com.practice.base.BaseTest;
import com.practice.pages.InventoryPage;
import com.practice.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test(groups = {"smoke", "regression"})
    public void validLogin() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        Assert.assertEquals(new InventoryPage(driver).heading(), "Products");
    }

    @Test(groups = {"regression"})
    public void invalidLogin() {
        LoginPage page = new LoginPage(driver);
        page.login("invalid_user", "wrong_password");
        Assert.assertTrue(page.errorMessage().contains("Username and password do not match"));
    }

    @Test(groups = {"regression"})
    public void logout() {

        // Step 1: Login
        new LoginPage(driver)
                .login("standard_user", "secret_sauce");

        // Step 2: Open the menu
        driver.findElement(By.id("react-burger-menu-btn")).click();

        // Step 3: Click Logout
        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(10)
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("logout_sidebar_link")
                )
        ).click();

        // Step 4: Verify login page is displayed
        WebElement loginButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("login-button")
                )
        );

        Assert.assertTrue(loginButton.isDisplayed());
    }
}
