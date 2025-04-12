package test.java.tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import main.java.pages.JSAlertsPage;
import test.java.utils.BaseTest;

public class JSAlertTests extends BaseTest {

    @Test
    public void testJSAlert() {
        test = extent.createTest("Test JS Alert", "Verify JS Alert functionality");
        test.log(Status.INFO, "Navigating to the JS Alert page");
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        test.log(Status.INFO, "Navigated to the JS Alert page");
        JSAlertsPage alertsPage = new JSAlertsPage(driver);
        alertsPage.triggerJSAlert();
        test.log(Status.INFO, "Triggered JS Alert");
        String alertText = alertsPage.handleAlert(true, null);
        Assert.assertEquals(alertText, "I am a JS Alert");
        test.log(Status.PASS, "Verified JS Alert text");
    }

    @Test
    public void testJSConfirmDismiss() {
        test = extent.createTest("Test JS Confirm Dismiss", "Verify JS Confirm dismiss functionality");
        test.log(Status.INFO, "Navigating to the JS Confirm page");
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        test.log(Status.INFO, "Navigated to the JS Confirm page");
        JSAlertsPage alertsPage = new JSAlertsPage(driver);
        alertsPage.triggerJSConfirm();
        test.log(Status.INFO, "Triggered JS Confirm");
        String alertText = alertsPage.handleAlert(false, null);
        Assert.assertEquals(alertText, "I am a JS Confirm");
        test.log(Status.INFO, "Verified JS Confirm text");
        Assert.assertTrue(alertsPage.getResultText().contains("Cancel"));
        test.log(Status.PASS, "Verified JS Confirm result text");
    }

    @Test
    public void testJSPrompt() {
        test = extent.createTest("Test JS Prompt", "Verify JS Prompt functionality");
        test.log(Status.INFO, "Navigating to the JS Prompt page");
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        test.log(Status.INFO, "Navigated to the JS Prompt page");
        JSAlertsPage alertsPage = new JSAlertsPage(driver);
        alertsPage.triggerJSPrompt();
        test.log(Status.INFO, "Triggered JS Prompt");
        String alertText = alertsPage.handleAlert(true, "Vinayak");
        Assert.assertEquals(alertText, "I am a JS prompt");
        test.log(Status.INFO, "Verified JS Prompt text");
        Assert.assertTrue(alertsPage.getResultText().contains("Vinayak"));
        test.log(Status.PASS, "Verified JS Prompt result text");
    }
}
