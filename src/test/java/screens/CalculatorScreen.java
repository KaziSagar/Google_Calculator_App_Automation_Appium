package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.Setup.PACKAGE_ID;

public class CalculatorScreen {
    @FindBy(id = PACKAGE_ID+ ":id/digit_1")
    AndroidElement btn1;
    @FindBy(id = PACKAGE_ID+ ":id/digit_5")
    AndroidElement btn5;
    @FindBy(id = PACKAGE_ID+ ":id/op_add")
    AndroidElement btnPlus;
    @FindBy(id = "com.google.android.calculator:id/result_preview")
    AndroidElement txtPreview;

    public CalculatorScreen(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public String doSum(){
        btn1.click();
        btnPlus.click();
        btn5.click();
        return txtPreview.getText();
    }

}
