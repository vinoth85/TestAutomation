package com.website.ui.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class DriverHelper {
    private static List<WebDriver> availableDrivers = Collections.synchronizedList(new ArrayList<WebDriver>());
    private static List<WebDriver> activeDrivers = Collections.synchronizedList(new ArrayList<WebDriver>());
    public static final String BROWSER = (System.getProperty("Browser") == null ? "chrome" : System.getProperty("Browser").toLowerCase());
    public static WebDriver driver;

    public static void closeAll() {
        for (WebDriver driver : availableDrivers) {
            driver.quit();
        }
        driver.quit();
    }

    public WebDriver retrieveDriver() throws Exception {
        WebDriver driver;
        if (availableDrivers.size() > 0) {
            driver = availableDrivers.remove(0);
            activeDrivers.add(driver);
        } else {
            driver = createDriver(BROWSER);
            activeDrivers.add(driver);
        }
        return driver;
    }


    private WebDriver createDriver(String driverType) throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/windows/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "drivers/windows/geckodriver.exe");
        System.setProperty("webdriver.ie.driver", "drivers/windows/IEDriverServer.exe");

        DesiredCapabilities cap;

        if (BROWSER.equals("firefox")) {
            cap = DesiredCapabilities.firefox();
            //allow to share location
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("geo.prompt.testing", true);
            profile.setPreference("geo.prompt.testing.allow", true);
            cap.setCapability(FirefoxDriver.PROFILE, profile);
        } else if (BROWSER.equals("chrome")) {
            cap = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            options.addArguments("–disable-web-security");
            options.addArguments("–allow-running-insecure-content");
            options.addArguments("--dns-prefetch-disable");
            cap.setCapability(ChromeOptions.CAPABILITY, options);
        }else if (BROWSER.equals("ie")){
            cap = DesiredCapabilities.internetExplorer();
           /* InternetExplorerOptions option = new InternetExplorerOptions();
            cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            cap.setJavascriptEnabled(true);
            cap.setCapability("requireWindowFocus", true);
            cap.setCapability("enablePersistentHover", false); */
        }
        else {
            cap = new DesiredCapabilities();
        }


        switch (BROWSER) {
            case "firefox":
                driver = new FirefoxDriver(cap);
                break;
            case "chrome":
                driver = new ChromeDriver(cap);
                break;
            case "ie":
                driver = new InternetExplorerDriver(cap);
                break;
            default:
                throw new Exception("The browser: " + BROWSER + " is not supported yet.");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // 60
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // 120
        return driver;
    }

    public void deleteAllCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    public void close(WebDriver driver) throws Exception {
        deleteAllCookies(driver);
        driver.quit();
    }


}
