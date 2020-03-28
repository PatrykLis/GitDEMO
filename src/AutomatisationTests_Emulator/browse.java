package AutomatisationTests_Emulator;
import java.awt.AWTException;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;

import Automatisation_MobileChrome.baseCROME;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;


public class browse extends baseCROME {

	public static void main(String[] args) throws MalformedURLException, AWTException {
		// TODO Auto-generated method stub
			AndroidDriver<AndroidElement> driver=Capabilities();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);	
 	
			driver.get("https://m.cricbuzz.com/");
			driver.findElementByXPath("//*[@id=\"top\"]/div/div[3]/div[2]/a").click();
			driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
			System.out.println(driver.getCurrentUrl());
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,720)", "");
			Assert.assertTrue(driver.findElementByXPath("//*[@id=\"top\"]/div/div[8]/h4").getAttribute("class").contains("header"));
			//assert is a validation so it will say if above is true or not
			
			/*driver.get("http://poczta.wp.pl");
			driver.findElementByXPath("//*[@id=\"login\"]").sendKeys("kesiloo");
			driver.findElementByXPath("//*[@id=\"password\"]").sendKeys("Sirlisek12");
			driver.findElementByXPath("//*[@type='submit']").click();
			//driver.findElementByCssSelector("button.").click();     */
			
			//when something is not working, and device is not known eg.
			//adb devices - Unauthorized
			//adb kill-server
			//adb start-server
			//adb devices
	}

}
