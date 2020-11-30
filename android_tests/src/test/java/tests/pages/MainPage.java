package tests.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import tests.BaseClass;

public class MainPage extends BaseClass {
    public MainPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }
    public static void closePopupIfDisplayed() {
        if (driver.findElementById("biz.growapp.winline:id/parentPanel").isDisplayed()) { //bannerId
            driver.findElementById("biz.growapp.winline:id/parentPanel").click(); //logoId
        }
    }
}
