package test.java.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initDriver() {
        if (driver == null) {
            try {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName("Windows 10");
                browserOptions.setBrowserVersion("135");
                HashMap<String, Object> ltOptions = new HashMap<>();
                ltOptions.put("username", ConfigReader.get("lt.username"));
                ltOptions.put("accessKey", ConfigReader.get("lt.accessKey"));
                ltOptions.put("build", "TestNG Lambdatest");
                ltOptions.put("project", "Vinayak");
                ltOptions.put("name", "Sample Hackathon test");
                ltOptions.put("w3c", true);
                ltOptions.put("plugin", "java-testNG");
                browserOptions.setCapability("LT:Options", ltOptions);
                driver = new RemoteWebDriver(
                    new URL("https://hub.lambdatest.com/wd/hub"), browserOptions
                );
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize WebDriver with LambdaTest capabilities.");
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
