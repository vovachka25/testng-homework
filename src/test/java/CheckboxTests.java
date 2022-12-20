import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Utils.CheckboxUtils.check;
import static Utils.CheckboxUtils.uncheck;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class CheckboxTests extends ConfigTests{
    @BeforeTest
    public void configureBaseUrl(){
        baseUrl = "http://the-internet.herokuapp.com";
        reportsFolder = "resources/CheckboxFailedTests";
        ScreenShooter.captureSuccessfulTests = false;
        savePageSource = false;
    }

    @Test
    public void checkbox(){
        open("/checkboxes");
        ElementsCollection checkboxes = $$("input[type=checkbox]");
        for (SelenideElement checkbox :
                checkboxes) {
            uncheck(checkbox);
        }
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkboxes.get(0).is(Condition.checked));

        for (SelenideElement checkbox :
                checkboxes) {
            check(checkbox);
        }

        softAssert.assertFalse(!checkboxes.get(1).is(Condition.checked));
        softAssert.assertAll();
    }
}
