package com.testproject.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;


public class Driver {

    private Driver() {}

    private static final InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /**
     * TO-DO: add remote drivers with configs to run on Selenium Grid/SauceLabs
     * @return driver
     * enhanced switch - no need for break statements
     */

    public static WebDriver get() {
        String browser = ConfigurationReader.getProperty("browser");
        if (driverPool.get() == null) {
            switch (browser) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                }
                case "chrome-headless" -> {
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                }
                case "firefox-headless" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                }
                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                }
                case "edge-headless" -> {
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver(new EdgeOptions().setHeadless(true)));
                }
                case "safari" -> {
                    WebDriverManager.safaridriver().setup();
                    driverPool.set(new SafariDriver());
                }
            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
