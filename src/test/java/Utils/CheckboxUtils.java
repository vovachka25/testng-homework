package Utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.checked;

public class CheckboxUtils {
    public static void uncheck(SelenideElement checkbox){
        if(checkbox.is(checked)){
            checkbox.click();
        }
    }

    public static void check(SelenideElement checkbox){
        if(!checkbox.is(checked)){
            checkbox.click();
        }
    }
}
