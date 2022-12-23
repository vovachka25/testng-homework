import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParameterTest {

    @BeforeTest
    public void ParameterSetup(){
        baseUrl = "https://demoqa.com";
        holdBrowserOpen = false;
        timeout = 5000;
        WebDriverManager.chromedriver().setup();
    }

    @Test
    @Parameters({"firstName","lastName","gender", "mobileNumber"})
    public void fillDynamicallyTest(String firstName, String lastName,String gender, String mobileNumber){
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $(By.xpath("//label[text()='"+ gender +"']")).click();
        $("#userNumber").setValue(mobileNumber);
        $("#firstName").shouldHave(Condition.value(firstName));
    }

    @Test(dataProvider = "inputs",dataProviderClass = Data.class)
    public void dataProviderTest(String firstName, String lastName, String gender, String mobileNumber){
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $(By.xpath("//label[text()='"+ gender +"']")).click();
        $("#userNumber").setValue(mobileNumber);
        $("#firstName").shouldHave(Condition.value(firstName));

    }

}
