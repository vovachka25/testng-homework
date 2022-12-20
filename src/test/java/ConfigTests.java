import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Configuration.timeout;

public class ConfigTests {

    @BeforeSuite
    public void setup(){
        WebDriverManager.chromedriver().setup();
        holdBrowserOpen = false;
        timeout = 5000;
    }
}
