package main.java.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JSAlertsPage {
    private WebDriver driver;

    private By alertButton = By.xpath("//button[text()='Click for JS Alert']");
    private By confirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private By promptButton = By.xpath("//button[text()='Click for JS Prompt']");
    private By resultText = By.id("result");

    public JSAlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void triggerJSAlert() {
        driver.findElement(alertButton).click();
    }

    public void triggerJSConfirm() {
        driver.findElement(confirmButton).click();
    }

    public void triggerJSPrompt() {
        driver.findElement(promptButton).click();
    }

    public String handleAlert(boolean accept, String promptInput) {
        Alert alert = driver.switchTo().alert();
        if (promptInput != null) {
            alert.sendKeys(promptInput);
        }
        String text = alert.getText();
        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
        return text;
    }

    public String getResultText() {
        return driver.findElement(resultText).getText();
    }
}
