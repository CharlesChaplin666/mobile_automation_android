package tests.regtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.BaseClass;

public class RegFormTest extends BaseClass {
    @Test
    public void regFormTest(){
        //скрываем поп-ап
        if (driver.findElementById("biz.growapp.winline:id/rvItems").isDisplayed()) { //bannerId
            driver.findElementById("biz.growapp.winline:id/registrationBanner").click(); // id свободного поля на странице регистрации
        }
        //В связи с тем, что теперь стартовой страницей является страница Реги и нет нижней панели разделов, добавлены следующие шаги
        //Открываем выпадающее меню
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
        //Переход на Главную
        driver.findElementById("biz.growapp.winline:id/ivImage").click();

        //Переход на страницу Регистрации
        driver.findElementById("biz.growapp.winline:id/btnRegister").click();
        //Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvToolbarTitle").getText(), "Регистрация"); СТРАНИЦА РЕГИСТРАЦИИ ИЗМЕНЕНА, ВСЕ НАДПИСИ УБРАЛИ

        //Ввод номера телефона
        findElementByIdClickAndSendKeys("biz.growapp.winline:id/etRegMask","1234567890");
        //driver.findElementById("biz.growapp.winline:id/etRegMask").setValue("1234567890");
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etRegMask").getText(), "+7 (123) 456 78 90");

        //Ввод пароля
        findElementByIdClickAndSendKeys("biz.growapp.winline:id/etReg", "123456");
        /* driver.findElementById("biz.growapp.winline:id/etPassword").click();
        driver.findElementById("biz.growapp.winline:id/etPassword").setValue("123456"); */
        Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etReg").getText(),
                "123456");

        //Ввод Даты рождения
        driver.findElementById("biz.growapp.winline:id/tvBirthdayHint").click();
        Assertions.assertTrue(driver.findElementById("android:id/pickers").isDisplayed());
        driver.findElementById("android:id/button1").click();

        //Ввод Промокода
        //findElementByIdClickAndSendKeys("biz.growapp.winline:id/tvHavePromoCode", "123456"); ??? Почему-то не срабатывает
        driver.findElementById("biz.growapp.winline:id/tvHavePromoCode").click();
        driver.findElementsById("biz.growapp.winline:id/etReg").get(1).setValue("123456");
        Assertions.assertEquals(driver.findElementsById("biz.growapp.winline:id/etReg").get(1).getText(), "123456");


        //Активация чек-бокса и проверка активации кнопки "Продолжить" --> Ч/Б поменяли на свитч
        driver.findElementById("biz.growapp.winline:id/switchAgreement").click();
        Assertions.assertTrue(driver.findElementById("biz.growapp.winline:id/btnGetSmsCode").isEnabled());

        //Очистка полей Номера, даты
        driver.findElementById("biz.growapp.winline:id/etRegMask").click();
        driver.findElementById("biz.growapp.winline:id/ivClearPhone").click();
        driver.findElementById("biz.growapp.winline:id/ivClearBirthday").click();

        //Проверка отображения/скрытия пароля
        driver.findElementById("biz.growapp.winline:id/btnVisibilityPassword").click();
        driver.findElementById("biz.growapp.winline:id/btnVisibilityPassword").click();

        //Очистка поля пароля
        driver.findElementsById("biz.growapp.winline:id/etReg").get(0).click();
        driver.findElementsById("biz.growapp.winline:id/etReg").get(0).clear();

    }
}
