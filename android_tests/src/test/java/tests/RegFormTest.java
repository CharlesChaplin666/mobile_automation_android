package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegFormTest extends BaseClass {
    @Test
    public void regFormTest(){
        driver.findElementById("biz.growapp.winline:id/btnRegister").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvToolbarTitle").getText(),
                "Регистрация");
        driver.findElementById("biz.growapp.winline:id/etPhone").click();
        driver.findElementById("biz.growapp.winline:id/etPhone").setValue("1234567890");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etPhone").getText(),
                "+7 (123) 456 78 90");
        driver.findElementById("biz.growapp.winline:id/etPassword").click();
        driver.findElementById("biz.growapp.winline:id/etPassword").setValue("123456");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etPassword").getText(),
                "123456");
        driver.findElementById("biz.growapp.winline:id/tvBirthdayHint").click();
        Assertions.assertTrue(driver.findElementById("android:id/pickers").isDisplayed());
        driver.findElementById("android:id/button1").click();
        driver.findElementById("biz.growapp.winline:id/tvHavePromoCode").click();
        driver.findElementsById("biz.growapp.winline:id/ivSport").get(3).setValue("123456");
        Assertions.assertEquals(driver.findElementsById("biz.growapp.winline:id/ivSport").get(3).getText(), "123456");


        /*if (driver.findElementById("biz.growapp.winline:id/btnGetSmsCode").isEnabled()) {
            System.out.println("Enabled");
        }
        else {
            System.out.println("Disabled");
        }*/
        /*Assertions.assertTrue(driver.findElementById("biz.growapp.winline:id/btnGetSmsCode").isEnabled());
biz.growapp.winline:id/cbAgreement
         */


    }
}
