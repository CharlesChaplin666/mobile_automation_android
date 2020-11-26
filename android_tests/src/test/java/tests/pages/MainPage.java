package tests.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import tests.BaseClass;

public class MainPage extends BaseClass {
    public MainPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }
    public static void closePopupIfDisplayed() {
        if (driver.findElementById(bannerId).isDisplayed()) { //bannerId
            driver.findElementById(LogoId).click(); //logoId
        }
    }
}
