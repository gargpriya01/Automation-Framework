package drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    private static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();

    public static WebDriver getDriver(String browser){
        if(tlDriver.get()==null){
            tlDriver.set(createDriver(browser));
        }
        return tlDriver.get();
    }

    private static WebDriver createDriver(String browser) {
        browser= browser == null ? "chrome": browser.toLowerCase();
        switch (browser) {
            case "firefox":
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                return new FirefoxDriver(ffOptions);
            case "chrome-headless":
                ChromeOptions headless = new ChromeOptions();
                headless.addArguments("--headless=new");
                headless.addArguments("--no-sandbox");
                headless.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                return new ChromeDriver(headless);
            case "chrome":
            default:
                ChromeOptions options = new ChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                return new ChromeDriver(options);
        }
    }


    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
}}
