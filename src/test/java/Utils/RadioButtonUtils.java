package Utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RadioButtonUtils {

    public static void clickYesRadioButton(){
        $("#yesRadio").doubleClick();
    }

    public static boolean isRadioButtonEnable(SelenideElement radioButton){
        return !radioButton.is(Condition.disabled);
    }
}
