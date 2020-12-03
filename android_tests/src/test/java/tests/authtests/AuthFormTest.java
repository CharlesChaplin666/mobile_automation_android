package tests.authtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.BaseClass;

import static tests.pages.MainPage.closePopupIfDisplayed;

public class AuthFormTest extends BaseClass {

    @Test
    public void authFormTest() {
        //Переход в Профиль
        driver.findElementsById("biz.growapp.winline:id/fixed_bottom_navigation_icon").get(4).click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/btnAuth").getText(),"Вход");

        //Переход в раздел ВХОД
        driver.findElementById("biz.growapp.winline:id/btnAuth").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etLogin").getText(),"Логин");

        //1 Валидация полей ЛОГИН и ПАРОЛЬ, авторизация и выход из акка
        findElementByIdClickAndSendKeys("biz.growapp.winline:id/etLogin", "9745314");
        /*driver.findElementById("biz.growapp.winline:id/etLogin").click();
        driver.findElementById("biz.growapp.winline:id/etLogin").setValue("9745314"); */
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etLogin").getText(), "9745314");
        findElementByIdClickAndSendKeys("biz.growapp.winline:id/etPassword", "123456");
       /* driver.findElementById("biz.growapp.winline:id/etPassword").click();
        driver.findElementById("biz.growapp.winline:id/etPassword").setValue("123456"); */
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etPassword").getText(), "123456");
        driver.findElementById("biz.growapp.winline:id/btnLogIn").click();
        //Появляется поп-ап Фрибет
        closePopupIfDisplayed();
        //Выход
        Assertions.assertEquals(driver.findElementsByClassName("android.widget.TextView").get(0).getText(), "Идентификация");
        driver.findElementsById("biz.growapp.winline:id/fixed_bottom_navigation_icon").get(4).click();
        driver.findElementsById("biz.growapp.winline:id/tvText").get(10).click();
        Assertions.assertEquals(driver.findElementById("android:id/message").getText(), "Ты точно хочешь выйти?");
        driver.findElementById("android:id/button1").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/btnAuth").getText(),"Вход");

        //2 Переход в раздел Вход через E-MAIL, валидация полей ЛОГИН и ПАРОЛЬ, авторизация и выход из акка

        driver.findElementById("biz.growapp.winline:id/btnAuth").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etLogin").getText(),"9745314");
        driver.findElementById("biz.growapp.winline:id/tvAuthType2").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etLogin").getText(),"E-mail");
        driver.findElementById("biz.growapp.winline:id/etLogin").setValue("testql1@yandex.ru");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etLogin").getText(), "testql1@yandex.ru");
        driver.findElementById("biz.growapp.winline:id/etPassword").setValue("1234567");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etPassword").getText(), "1234567");
        driver.findElementById("biz.growapp.winline:id/btnLogIn").click();
        //Выход
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvTitle").getText(), "Онлайн-идентификация");
        driver.findElementsById("biz.growapp.winline:id/fixed_bottom_navigation_icon").get(4).click();
        driver.findElementsById("biz.growapp.winline:id/tvText").get(10).click();
        Assertions.assertEquals(driver.findElementById("android:id/message").getText(), "Ты точно хочешь выйти?");
        driver.findElementById("android:id/button1").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/btnAuth").getText(),"Вход");

        //3 Переход в раздел Вход через ТЕЛЕФОН, валидация полей ЛОГИН и ПАРОЛЬ, авторизация и выход из акка
        driver.findElementById("biz.growapp.winline:id/btnAuth").click();
        driver.findElementById("biz.growapp.winline:id/tvAuthType1").click();
        driver.findElementById("biz.growapp.winline:id/etPhoneMask").click();
        driver.findElementById("biz.growapp.winline:id/etLoginByPhone").setValue("9172271187");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etLoginByPhone").getText(), "9172271187");
        driver.findElementById("biz.growapp.winline:id/etPassword").click();
        driver.findElementById("biz.growapp.winline:id/etPassword").setValue("123456");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etPassword").getText(), "123456");
        driver.findElementById("biz.growapp.winline:id/btnLogIn").click();
        //Появляется поп-ап Фрибет
        closePopupIfDisplayed();
        //Выход
        Assertions.assertEquals(driver.findElementsByClassName("android.widget.TextView").get(0).getText(), "Идентификация");
        driver.findElementsById("biz.growapp.winline:id/fixed_bottom_navigation_icon").get(4).click();
        driver.findElementsById("biz.growapp.winline:id/tvText").get(10).click();
        Assertions.assertEquals(driver.findElementById("android:id/message").getText(), "Ты точно хочешь выйти?");
        driver.findElementById("android:id/button1").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/btnAuth").getText(),"Вход");
    }
}
