package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class A1_HomePage {
	
@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
public WebElement Preferences;

//findElementByXPath("//android.widget.TextView[@text='Preference']");



}
