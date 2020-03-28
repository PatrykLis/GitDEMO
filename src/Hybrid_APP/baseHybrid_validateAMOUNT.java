package Hybrid_APP;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class baseHybrid_validateAMOUNT extends baseHybrid  {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Thread.sleep(3000);
		WebElement lista= driver.findElementByClassName("android.widget.Spinner");
	    new TouchAction(driver).tap(tapOptions().withElement(element(lista))).waitAction(waitOptions(Duration.ofMillis(250))).perform();
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));").click();
	    //driver.hideKeyboard();   - chowa klawiature
	    driver.findElementByClassName("android.widget.EditText").sendKeys("Piotrunia");
	    driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
	    driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	    
	    driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
	    driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1).click();
	    
	 driver.findElementsByClassName("android.widget.ImageButton").get(1).click();
	 
	    Thread.sleep(4000);
	    	    
	    //sumujemy wartoœci dwóch wybranych produktów by sprawdziæ czy suma ich równa sie to co jest w koszyku
	    	    
String amount1=	  driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText();
 		amount1= amount1.substring(1); //usunie dollara, bo nie mozemy wykonywac dzia³añ matematycznych jak jest jakis znaczek
 		double amount1value= Double.parseDouble(amount1);
 		System.out.println(amount1value+"cena1");
String amount2=	  driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();  
		amount2= amount2.substring(1);
		double amount2value= Double.parseDouble(amount2);
		System.out.println(amount2value+"cena2");
double sumOfProducts=amount1value+amount2value;
System.out.println(sumOfProducts+"sum");

String total=driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
total= total.substring(1);
double totalValue=Double.parseDouble(total);
System.out.println(totalValue+"cena totalna");

Assert.assertEquals(sumOfProducts, totalValue,0.1); //0.1 opisuje delte czyli jaka moze byc roznica
	}

}
