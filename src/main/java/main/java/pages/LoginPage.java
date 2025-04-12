package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton   = By.cssSelector(".radius");
    private By alertMessage  = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String usernamee) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(usernamee);
    }

    public void enterPassword(String passwordd) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(passwordd);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String usernamee, String passwordd) {
        enterUsername(usernamee);
        enterPassword(passwordd);
        clickLogin();
    }

    public String getAlertMessage() {
        return driver.findElement(alertMessage).getText();
    }
}
