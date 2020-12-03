package tests.regtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.BaseClass;

public class RegFormTest extends BaseClass {
    @Test
    public void regFormTest(){
        //Переход на страницу Регистрации
        driver.findElementById("biz.growapp.winline:id/btnRegister").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvToolbarTitle").getText(),
                "Регистрация");

        //Ввод номера телефона
        findElementByIdClickAndSendKeys("biz.growapp.winline:id/etPhone","1234567890");
       /* driver.findElementById("biz.growapp.winline:id/etPhone").click();
        driver.findElementById("biz.growapp.winline:id/etPhone").setValue("1234567890"); */
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etPhone").getText(),
                "+7 (123) 456 78 90");

        //Ввод пароля
        findElementByIdClickAndSendKeys("biz.growapp.winline:id/etPassword", "123456");
        /* driver.findElementById("biz.growapp.winline:id/etPassword").click();
        driver.findElementById("biz.growapp.winline:id/etPassword").setValue("123456"); */
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etPassword").getText(),
                "123456");

        //Ввод Даты рождения
        driver.findElementById("biz.growapp.winline:id/tvBirthdayHint").click();
        Assertions.assertTrue(driver.findElementById("android:id/pickers").isDisplayed());
        driver.findElementById("android:id/button1").click();

        //Ввод Промокода
        findElementByIdClickAndSendKeys("biz.growapp.winline:id/tvHavePromoCode", "123456");
        /*driver.findElementById("biz.growapp.winline:id/tvHavePromoCode").click();
        driver.findElementById("biz.growapp.winline:id/etPromoCode").setValue("123456");*/
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etPromoCode").getText(), "123456");

        //Активация чек-бокса и проверка активации кнопки "Продолжить"
        driver.findElementById("biz.growapp.winline:id/cbAgreement").click();
        Assertions.assertTrue(driver.findElementById("biz.growapp.winline:id/btnGetSmsCode").isEnabled());

        //Очистка полей Номера, даты
        driver.findElementById("biz.growapp.winline:id/etPhone").click();
        driver.findElementById("biz.growapp.winline:id/ivClearPhone").click();
        driver.findElementById("biz.growapp.winline:id/ivClearBirthday").click();

        //Проверка отображения/скрытия пароля
        driver.findElementById("biz.growapp.winline:id/btnVisibilityPassword").click();
        driver.findElementById("biz.growapp.winline:id/btnVisibilityPassword").click();

        //Очистка поля пароля
        driver.findElementById("biz.growapp.winline:id/etPassword").click();
        driver.findElementById("biz.growapp.winline:id/etPassword").clear();

    }
}
