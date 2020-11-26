package tests;

import org.junit.jupiter.api.Test;
import static tests.pages.MainPage.closePopupIfDisplayed;
public class RegFormTest extends BaseClass {
    @Test
    public void regFormTest(){
        closePopupIfDisplayed();
        driver.findElementById("biz.growapp.winline:id/ivLogo").click();
        //метод теста
    }
}
