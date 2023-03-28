package MobileAutomation.AppiumTest;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class GuesturesTest extends BaseTest {
	
	

	@Test
	public void longPressElement() throws MalformedURLException, InterruptedException {
		
		
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement ele= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		longPress(ele);
		 String text=driver.findElement(By.id("android:id/title")).getText();
		 Assert.assertEquals(text, "Sample menu");
		 Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		
	
		
		
	}
	
	
	@Test
	public void scrollToElemenet() throws MalformedURLException, InterruptedException {
		
		
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//use if we know about the target element
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		//use this when not having idea about target element
		boolean canScrollMore;
		
		do
		{
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 10.0
			));
		}while(canScrollMore);
		
		Thread.sleep(3000);
		
	
		
		
	}
	
	
	@Test
	public void swipeDemoTest() throws MalformedURLException, InterruptedException {
		
		
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		WebElement ele = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		Assert.assertEquals(ele.getAttribute("focusable"), "true");
		
		swipeAction(ele,"left");
	
		Assert.assertEquals(ele.getAttribute("focusable"), "false");
		
		
	}
	
	
	@Test
	public void dragAndDropTest() throws MalformedURLException, InterruptedException {
		
		
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement ele=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", 641,
			    "endY", 685
			));
		
		String msg=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		
		Assert.assertEquals(msg, "Dropped!");
		
		
	}


}
