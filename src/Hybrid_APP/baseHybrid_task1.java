package Hybrid_APP;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.junit.Assert.assertEquals;


import java.net.MalformedURLException;
import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class baseHybrid_task1 extends baseHybrid {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
		WebElement lista= driver.findElementByClassName("android.widget.Spinner");
	    new TouchAction(driver).tap(tapOptions().withElement(element(lista))).waitAction(waitOptions(Duration.ofMillis(250))).perform();
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));").click();
	    //driver.hideKeyboard();   - chowa klawiature
	    driver.findElementByClassName("android.widget.EditText").sendKeys("Piotrunia");
	    driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
	    driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	    
	    //android.widget.Toast   = dotyczy "pop'ów" czyli wyskakuj¹cych powiadomieñ - zawsze taaka klasa
	    
	   /* String toastMessage= driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
	    System.out.println(toastMessage);
	    Assert.assertEquals("Please enter your name", toastMessage); //je¿eli assert jest przekreslone to musisz importowaæ z junit.assert*/
	   
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
                + "new UiSelector().text(\"Jordan 6 Rings\"));");
	    int count=  driver.findElementsById("com.androidsample.generalstore:id/productName").size();
	    
	    for(int i=0;i<count;i++)
	    {
	    	String text=driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
	    if(text.equalsIgnoreCase("Jordan 6 Rings"))
	    {
	    driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
	    break;
	    }
	    
	    } 
	    driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
	    
	    AndroidElement lastpageText=driver.findElementsById("com.androidsample.generalstore:id/productName").get(1);
	    
	   Assert.assertEquals("Jordan 6 Rings", lastpageText);
	}

}
