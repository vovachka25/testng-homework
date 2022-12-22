package Utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class RadioButtonUtils {

    public static boolean isRadioButtonEnable(SelenideElement radioButton){
        return radioButton.is(Condition.enabled);
    }
}
