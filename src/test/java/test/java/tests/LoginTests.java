package test.java.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import main.java.pages.LoginPage;
import test.java.utils.BaseTest;
import test.java.utils.ConfigReader;

public class LoginTests extends BaseTest {

    private LoginPage loginPage;
    private String username;
    private String password;
    private String wusername;
    private String wpassword;

    @BeforeMethod
    public void setUpTest() {
        loginPage = new LoginPage(driver);
        username = ConfigReader.get("username");
        password = ConfigReader.get("password");
        wusername = ConfigReader.get("wrongusername");
        wpassword = ConfigReader.get("wrongpassword");
    }

    @Test
    public void validLoginTest() {
        test = extent.createTest("Valid Login Test", "Verify valid login functionality");
        test.log(Status.INFO, "Navigating to the login page");
        driver.get("https://the-internet.herokuapp.com/login");
        test.log(Status.INFO, "Navigated to the login page");
        loginPage.login(username, password);
        test.log(Status.INFO, "Entered valid credentials and clicked login");
        Assert.assertTrue(loginPage.getAlertMessage().contains("You logged into a secure area!"));
        test.log(Status.PASS, "Verified successful login message");
    }

    @Test
    public void invalidLoginTest() {
        test = extent.createTest("Invalid Login Test", "Verify invalid login functionality");
        test.log(Status.INFO, "Navigating to the login page");
        driver.get("https://the-internet.herokuapp.com/login");
        test.log(Status.INFO, "Navigated to the login page");
        loginPage.login(wusername, wpassword);
        test.log(Status.INFO, "Entered invalid credentials and clicked login");
        Assert.assertTrue(loginPage.getAlertMessage().contains("Your username is invalid!"));
        test.log(Status.PASS, "Verified invalid login message");
    }
}
