package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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
        @AfterAll
        public static void teardown() {
            driver.quit();
        }

    }
}
public class RegFormTest extends BaseClass {
    @Test
    public static void regFormTest(){
        //метод теста
    }
}