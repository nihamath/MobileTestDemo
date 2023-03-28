package MobileAutomation.AppiumTest;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EndToEndTest extends BaseTest {
	
	
	@Test
	public void fillFormVlaidData() throws MalformedURLException, InterruptedException {	
		
		
		
	
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Nihamath");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		int productCount= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for (int i =0; i<productCount;i++) {
			
			
			 String name = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			 if(name.equalsIgnoreCase("Jordan 6 Rings")) {
				 System.out.println(name);
				 driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			 }
			
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(3000);
		WebElement title = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBePresentInElementValue(title, "Cart"));
		
		String selectedProduct= driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(selectedProduct, "Jordan 6 Rings");
		
	}
	
	
	@Test
	public void fillFormInVlaidData() throws MalformedURLException, InterruptedException {	
		
		
		
	
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toast=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toast, "Please enter your name");
		
	}
	
	

}
