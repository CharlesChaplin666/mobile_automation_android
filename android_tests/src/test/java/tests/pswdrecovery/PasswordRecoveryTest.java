package tests.pswdrecovery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.BaseClass;

public class PasswordRecoveryTest extends BaseClass {
  @Test
  public void paswdRecoveryTest(){
    if (driver.findElementById("biz.growapp.winline:id/rvItems").isDisplayed()) { //bannerId
      driver.findElementById("biz.growapp.winline:id/btnRegister").click(); //register button id
    }
    //Переход в Профиль
    driver.findElementsById("biz.growapp.winline:id/fixed_bottom_navigation_icon").get(4).click();
    Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/btnAuth").getText(),"Вход");

    //Переход в Забыл пароль?
    driver.findElementByClassName("android.widget.TextView").click();
    Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvToolbarTitle").getText(), "Восстановление пароля");

    //Проверка дизактивности кнопки Продолжить
    driver.findElementById("biz.growapp.winline:id/btnContinue").click(); //кнопка не активна- ок
    Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvToolbarTitle").getText(), "Восстановление пароля");

    //Валидация поля телефон с разными значениями
    driver.findElementById("biz.growapp.winline:id/etPhone").setValue("12345678901");
    Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/etPhone")).getText(), "12345678901";
    driver.findElementById("biz.growapp.winline:id/btnContinue").click(); //кнопка не активна- ок
    Assertions.assertEquals(driver.findElementById("biz.growapp.winline:id/tvToolbarTitle").getText(), "Восстановление пароля");

    //Установка даты рождения (текущей датой по умолчанию)
    driver.findElementById("biz.growapp.winline:id/etBdate").click();
    Assertions.assertEquals(driver.findElementById("android:id/pickers"));
    driver.findElementById("android:id/button1");

    driver.findElementById("biz.growapp.winline:id/btnContinue").click();


  }
}
