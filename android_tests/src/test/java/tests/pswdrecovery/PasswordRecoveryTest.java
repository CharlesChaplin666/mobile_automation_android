package tests.pswdrecovery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.BaseClass;

public class PasswordRecoveryTest extends BaseClass {
  @Test
  public void paswdRecoveryTest(){
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

    //Переход в Забыл пароль?
    //кнопка Вход
    driver.findElementById("biz.growapp.winline:id/btnAuth").click();
    //Кнопка Забыли пароль?
    driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView").click();
    Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvToolbarTitle").getText(), "Восстановление пароля");

    //Проверка дизактивности кнопки Продолжить
    driver.findElementById("biz.growapp.winline:id/btnContinue").click(); //кнопка не активна- ок
    Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvToolbarTitle").getText(), "Восстановление пароля");

    //Валидация поля телефон с разными значениями
    driver.findElementById("biz.growapp.winline:id/etPhone").setValue("12345678901");
    Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etPhone").getText(), "12345678901");
    driver.findElementById("biz.growapp.winline:id/btnContinue").click(); //кнопка не активна- ок
    Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvToolbarTitle").getText(), "Восстановление пароля");

    //Установка даты рождения (текущей датой по умолчанию)
    driver.findElementById("biz.growapp.winline:id/etBdate").click();
    driver.findElementById("android:id/button1").click();

    driver.findElementById("biz.growapp.winline:id/btnContinue").click();


  }
}
