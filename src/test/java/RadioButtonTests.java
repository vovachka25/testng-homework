import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Utils.RadioButtonUtils.isRadioButtonEnable;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.reportsFolder;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RadioButtonTests extends ConfigTests{

    @BeforeTest(groups = {"FrontEnd", "BackEnd"})
    public void configure(){
        baseUrl = "https://demoqa.com";
        reportsFolder = "resources/RadioButtonFailedTests";
    }

    SoftAssert softAssert = new SoftAssert();
    @Test(groups = {"FrontEnd"}, priority = 1)
    public void radioButtonClickTest(){
        open("/radio-button");
        $("#yesRadio").doubleClick();
        softAssert.assertAll();
    }

    @Test(groups = {"BackEnd"}, priority = 1)
    public void radioButtonDisableTest(){
        open("/radio-button");
        softAssert.assertTrue(isRadioButtonEnable($("#noRadio")));
        softAssert.assertAll();
    }

}
