import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Utils.CheckboxUtils.check;
import static Utils.CheckboxUtils.uncheck;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.reportsFolder;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class CheckboxTests extends ConfigTests{

    @BeforeTest(groups = {"FrontEnd", "BackEnd"})
    public void configure(){
        baseUrl = "http://the-internet.herokuapp.com";
        reportsFolder = "resources/CheckboxFailedTests";
    }

    SoftAssert softAssert = new SoftAssert();
    @Test(groups = {"FrontEnd"})
    public void unCheckboxTest() {
        open("/checkboxes");
        ElementsCollection checkboxes = $$("input[type=checkbox]");
        for (SelenideElement checkbox :
                checkboxes) {
            uncheck(checkbox);
        }
        softAssert.assertTrue(checkboxes.get(0).is(Condition.checked));
        softAssert.assertAll();

    }
    @Test(groups = {"BackEnd"})
    public void checkboxTest(){
        open("/checkboxes");
        ElementsCollection checkboxes = $$("input[type=checkbox]");
        for (SelenideElement checkbox :
            checkboxes) {
            check(checkbox);
        }
        softAssert.fail();
    }
}
