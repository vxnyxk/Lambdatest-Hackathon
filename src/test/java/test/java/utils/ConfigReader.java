package test.java.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try (FileInputStream fis = new FileInputStream("src/main/resources/application.properties")) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load application.properties file.");
        }
    }

    public static String get(String key) {
        if (properties == null) {
            throw new IllegalStateException("Properties file not loaded.");
        }
        return properties.getProperty(key);
    }
}
