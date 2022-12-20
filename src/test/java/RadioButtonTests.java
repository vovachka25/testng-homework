import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Utils.RadioButtonUtils.clickYesRadioButton;
import static Utils.RadioButtonUtils.isRadioButtonEnable;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RadioButtonTests extends ConfigTests{
    @BeforeTest
    public void configureTests(){
        baseUrl = "https://demoqa.com";
        reportsFolder = "resources/RadioButtonFailedTests";
        ScreenShooter.captureSuccessfulTests = false;
        savePageSource = false;
    }

    @Test
    public void radioButton(){
        open("/radio-button");
        clickYesRadioButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isRadioButtonEnable($("#noRadio")));
        softAssert.assertAll();
    }
}
