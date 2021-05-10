package utils;

import config.GlobalPaths;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

public class DriverUtil {
    //driver initialization
    protected static AppiumDriver<?> driver;
    static String currentPath = System.getProperty("user.dir");
    static Properties properties = new Properties();
    static DesiredCapabilities capabilities;

    public static AppiumDriver<?> getDefaultWebDriver() {
        if (driver != null) {
            return driver;
        }
        String environment = null;
        String platform = null;
        String config = "local_android_app_nexus30";

        try {
            environment = config.split("_")[0].toLowerCase();
            platform = config.split("_")[1].toLowerCase();
            InputStream inputStream = new FileInputStream(GlobalPaths.getPropertyPath(config));
            capabilities = getCapabilities(inputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        switch (environment) {
            case "local":
                if (platform.equals("android"))
                    driver = androidDriver(capabilities);
                else {
                    System.out.println("unsupported platform");
                    System.exit(0);
                }
                break;
            case "browserstack":
                break;
            default:
                System.out.println("\nException : Invalid platform " + environment);
        }
        return driver;
    }

    private static AppiumDriver<?> androidDriver(DesiredCapabilities capabilities) {
        String port = "4723";
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:" + port + "/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static DesiredCapabilities getCapabilities(InputStream inputStream) {
        capabilities = new DesiredCapabilities();
        if (System.getProperty("app", "").isEmpty()) {
            String appPath = currentPath + "\\src\\main\\java\\appUnderTest\\ApiDemos-debug.apk";
            System.setProperty("app", appPath);
            capabilities.setCapability(MobileCapabilityType.APP, appPath);

        }

        try {
            //set capabilities
            properties.load(inputStream);

            Enumeration<Object> keys = properties.keys();
            while (keys.hasMoreElements()) {
                String key = String.valueOf(keys.nextElement());
                String value = properties.getProperty(key);
                capabilities.setCapability(key, value);
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return capabilities;


    }
}
