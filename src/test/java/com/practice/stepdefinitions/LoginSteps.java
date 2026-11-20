package com.practice.stepdefinitions;
import com.practice.pages.InventoryPage;
import com.practice.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
public class LoginSteps {
 private final LoginPage login = new LoginPage();
 private final InventoryPage inventory = new InventoryPage();
 @Given("I am on the SauceDemo login page") public void onLoginPage() { Assert.assertTrue(login.isLoginVisible()); }
 @When("I log in with username {string} and password {string}") public void logIn(String user,String pass) {login.login(user,pass);}
 @Then("I should see the Products page") public void productsPage() {Assert.assertEquals(inventory.heading(),"Products");}
 @Then("I should see an invalid credentials error") public void invalidCredentials() {Assert.assertTrue(login.errorMessage().contains("Username and password do not match"));}
 @When("I log out") public void logOut() {inventory.logout();}
 @Then("I should return to the login page") public void returnedToLogin() {Assert.assertTrue(login.isLoginVisible());}
}
