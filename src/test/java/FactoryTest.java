import com.codeborne.selenide.Condition;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FactoryTest {

    private String firstName;
    private String lastName;
    private String gender;
    private String mobileNumber;
    public FactoryTest(String firstName, String lastName, String gender, String mobileNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
    }

    @BeforeTest
    public void factorySetup(){
        baseUrl = "https://demoqa.com";
        holdBrowserOpen = false;
        timeout = 5000;
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void factoryDynamicTest(){
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $(By.xpath("//label[text()='"+ gender +"']")).click();
        $("#userNumber").setValue(mobileNumber);
        $("#firstName").shouldHave(Condition.value(firstName));

    }
}
