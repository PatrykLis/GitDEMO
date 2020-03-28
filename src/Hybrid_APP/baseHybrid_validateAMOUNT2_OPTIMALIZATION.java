package Hybrid_APP;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class baseHybrid_validateAMOUNT2_OPTIMALIZATION extends baseHybrid  {

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
		int count=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();

		double sum=0;

		for(int i=0;i<count;i++)

		{

		String amount1= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();

		double amount=getAmount(amount1);

		sum=sum+amount;//280.97+116.97

		}

		System.out.println(sum+"sum of products");


		String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();


		total= total.substring(1);

		double totalValue=Double.parseDouble(total);

		System.out.println(totalValue+"Total value of products");

		Assert.assertEquals(sum, totalValue,0.1); 


		//Mobile Gestures
		driver.findElementByClassName("android.widget.CheckBox").click();
		WebElement terms= driver.findElementById("com.androidsample.generalstore:id/termsButton");
	    new TouchAction(driver).longPress(longPressOptions().withElement(element(terms))).waitAction(waitOptions(Duration.ofMillis(1000))).perform();
	    driver.findElementById("android:id/button1").click();
	    driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		}
		public static double getAmount(String value)
		{
		value= value.substring(1);
		double amount2value=Double.parseDouble(value);
		return amount2value;

		}

		}