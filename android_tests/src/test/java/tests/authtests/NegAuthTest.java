package tests.authtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.BaseClass;

public class NegAuthTest extends BaseClass {
    @Test
    public void negAuthTest() {
        //скрываем поп-ап
        if (driver.findElementById("biz.growapp.winline:id/rvItems").isDisplayed()) { //bannerId
            driver.findElementById("biz.growapp.winline:id/registrationBanner").click(); //register button id
        }
        //В связи с тем, что теперь стартовой страницей является страница Реги и нет нижней панели разделов, добавлены следующие шаги
        //Открываем выпадающее меню
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
        //Переход на Главную
        driver.findElementById("biz.growapp.winline:id/ivImage").click();

        //Переход в Профиль
        driver.findElementsById("biz.growapp.winline:id/fixed_bottom_navigation_icon").get(4).click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/btnAuth").getText(),"Вход");

        //Переход в раздел ВХОД
        driver.findElementById("biz.growapp.winline:id/btnAuth").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etLogin").getText(),"Логин");

        //1 Авторизация с пустыми полями
        driver.findElementById("biz.growapp.winline:id/btnLogIn").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvTitle").getText(), "Не удалось войти");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvMessage").getText(), "Данные указаны неверно, попробуй еще раз");
        driver.findElementById("biz.growapp.winline:id/btnCancel").click();

        //2 Авторизация с несуществующим ЛОГИНом
        findElementByIdClickAndSendKeys("biz.growapp.winline:id/etLogin", "razraz");
        /*driver.findElementById("biz.growapp.winline:id/etLogin").click();
        driver.findElementById("biz.growapp.winline:id/etLogin").setValue("razraz");*/
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etLogin").getText(), "razraz");
        findElementByIdClickAndSendKeys("biz.growapp.winline:id/etPassword", "123456");
        /*driver.findElementById("biz.growapp.winline:id/etPassword").click();
        driver.findElementById("biz.growapp.winline:id/etPassword").setValue("123456");*/
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etPassword").getText(), "123456");
        driver.findElementById("biz.growapp.winline:id/btnLogIn").click();
        Assertions.assertEquals(driver.findElementById("android:id/alertTitle").getText(), "Не удалось войти");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvMessage").getText(), "Клиент с таким логином не зарегистрирован на сайте Winline.RU. Возможно, ты являешься клиентом зарубежного букмекера Winlinebet.COM.");
        driver.findElementById("android:id/button2").click();
        driver.findElementById("biz.growapp.winline:id/ivClearLogin").click();

        //3 Авторизация с неккоректным паролем
        findElementByIdClickAndSendKeys("biz.growapp.winline:id/etLogin", "9745314");
        /*driver.findElementById("biz.growapp.winline:id/etLogin").click();
        driver.findElementById("biz.growapp.winline:id/etLogin").setValue("9745314");*/
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etLogin").getText(), "9745314");
        findElementByIdClickAndSendKeys("biz.growapp.winline:id/etPassword", "1234567");
        /*driver.findElementById("biz.growapp.winline:id/etPassword").click();
        driver.findElementById("biz.growapp.winline:id/etPassword").setValue("1234567");*/
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etPassword").getText(), "1234567");
        driver.findElementById("biz.growapp.winline:id/btnLogIn").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvTitle").getText(), "Не удалось войти");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvMessage").getText(), "Данные указаны неверно, попробуй еще раз");
        driver.findElementById("biz.growapp.winline:id/btnCancel").click();

        //4 Авторизация с пустым паролем
        driver.findElementById("biz.growapp.winline:id/btnLogIn").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvTitle").getText(), "Не удалось войти");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvMessage").getText(), "Данные указаны неверно, попробуй еще раз");
        driver.findElementById("biz.growapp.winline:id/btnCancel").click();

        //5 Авторизация с несуществующим E-MAILом
        driver.findElementById("biz.growapp.winline:id/tvAuthType2").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etLogin").getText(),"E-mail");
        driver.findElementById("biz.growapp.winline:id/etLogin").setValue("test@test.test");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etLogin").getText(), "test@test.test");
        driver.findElementById("biz.growapp.winline:id/etPassword").setValue("123456");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etPassword").getText(), "123456");
        driver.findElementById("biz.growapp.winline:id/btnLogIn").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvTitle").getText(), "Не удалось войти");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvMessage").getText(), "Данные указаны неверно, попробуй еще раз");
        driver.findElementById("biz.growapp.winline:id/btnCancel").click();
        driver.findElementById("biz.growapp.winline:id/ivClearLogin").click();


        //6 Авторизация по E-MAIL с неккоректным паролем
        driver.findElementById("biz.growapp.winline:id/etLogin").setValue("testql1@yandex.ru");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etLogin").getText(), "testql1@yandex.ru");
        driver.findElementById("biz.growapp.winline:id/etPassword").setValue("123456");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etPassword").getText(), "123456");
        driver.findElementById("biz.growapp.winline:id/btnLogIn").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvTitle").getText(), "Не удалось войти");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvMessage").getText(), "Данные указаны неверно, попробуй еще раз");
        driver.findElementById("biz.growapp.winline:id/btnCancel").click();


        //7 Авторизация по E-MAIL с пустым паролем
        driver.findElementById("biz.growapp.winline:id/btnLogIn").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvTitle").getText(), "Не удалось войти");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvMessage").getText(), "Данные указаны неверно, попробуй еще раз");
        driver.findElementById("biz.growapp.winline:id/btnCancel").click();
        driver.findElementById("biz.growapp.winline:id/ivClearLogin").click();

        //8 Авторизация по E-MAIL с пустыми полями
        driver.findElementById("biz.growapp.winline:id/btnLogIn").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvTitle").getText(), "Не удалось войти");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvMessage").getText(), "Данные указаны неверно, попробуй еще раз");
        driver.findElementById("biz.growapp.winline:id/btnCancel").click();

        //9 Авторизация по ТЕЛефону с пустыми полями
        driver.findElementById("biz.growapp.winline:id/tvAuthType1").click();
        driver.findElementById("biz.growapp.winline:id/btnLogIn").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvTitle").getText(), "Не удалось войти");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvMessage").getText(), "Данные указаны неверно, попробуй еще раз");
        driver.findElementById("biz.growapp.winline:id/btnCancel").click();

        //10 Авторизация по ТЕЛефону с неккоректным паролем
        driver.findElementById("biz.growapp.winline:id/etPhoneMask").click();
        driver.findElementById("biz.growapp.winline:id/etLoginByPhone").setValue("9172271187");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etLoginByPhone").getText(), "9172271187");
        driver.findElementById("biz.growapp.winline:id/etPassword").click();
        driver.findElementById("biz.growapp.winline:id/etPassword").setValue("1234567");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etPassword").getText(), "1234567");
        driver.findElementById("biz.growapp.winline:id/btnLogIn").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvTitle").getText(), "Не удалось войти");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvMessage").getText(), "Данные указаны неверно, попробуй еще раз");
        driver.findElementById("biz.growapp.winline:id/btnCancel").click();
        driver.findElementById("biz.growapp.winline:id/ivClearLogin").click();

        //11 Авторизация по ТЕЛефону с неккоректным номером
        driver.findElementById("biz.growapp.winline:id/etPhoneMask").click();
        driver.findElementById("biz.growapp.winline:id/etLoginByPhone").setValue("917227118");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etLoginByPhone").getText(), "917227118");
        driver.findElementById("biz.growapp.winline:id/etPassword").click();
        driver.findElementById("biz.growapp.winline:id/etPassword").setValue("123456");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etPassword").getText(), "123456");
        driver.findElementById("biz.growapp.winline:id/btnLogIn").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvTitle").getText(), "Не удалось войти");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvMessage").getText(), "Данные указаны неверно, попробуй еще раз");
        driver.findElementById("biz.growapp.winline:id/btnCancel").click();

        //12 Авторизация по ТЕЛефону с пустым номером
        driver.findElementById("biz.growapp.winline:id/btnLogIn").click();
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvTitle").getText(), "Не удалось войти");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvMessage").getText(), "Данные указаны неверно, попробуй еще раз");
        driver.findElementById("biz.growapp.winline:id/btnCancel").click();


    }
}
