package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BaseClass {
    public static AndroidDriver<MobileElement> driver; // объявляем статическую переменную, чтобы доступ был из всех классов
    @BeforeAll
    public static void setup() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            // для реального девайса
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Xiaomi Redmi 5");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
            capabilities.setCapability("appPackage", "biz.growapp.winline");
            capabilities.setCapability("appActivity", "biz.growapp.winline.presentation.splash.SplashActivity");
            capabilities.setCapability("appWaitActivity", "biz.growapp.winline.presentation.splash.SplashActivity");
            capabilities.setCapability(MobileCapabilityType.UDID, "4e25e0ee7cf5");
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<MobileElement>(url, capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (Exception ex) {
            System.out.println("Cause is : " + ex.getCause());
            System.out.println("Message is : " + ex.getMessage());
            ex.printStackTrace();
        }
    }
        @AfterAll
        public static void teardown() {
            driver.quit();
        }
    public WebElement findElementByIdClickAndSendKeys(String id, String value){
        WebElement element = driver.findElementById(id);
        element.click();
        element.sendKeys(value);
        return element;
    }
    public WebElement findElementsByIdClickAndSendKeys(String id, int get_number, String value){
        WebElement element = driver.findElementsById(id).get(get_number);
        element.click();
        element.sendKeys(value);
        return element;
    }
    /*public WebElement waitForElementPresentById(String Id, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        By by = By.xpath(Id);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
    public WebElement waitForElementPresentById(String Id, String error_message){
        return waitForElementPresentById(Id, error_message, 5);

    }
    public WebElement waitForElementByIdAndClick(String Id, String error_message, long timeoutInSeconds){
        WebElement element = waitForElementPresentById(Id, error_message, timeoutInSeconds);
        element.click();
        return element;
    }
    public WebElement waitForElementByIdAndSendKeys(String Id, String value, String error_message, long timeoutInSeconds){
        WebElement element = waitForElementPresentById(Id, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }*/
        }
