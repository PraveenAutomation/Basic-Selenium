package automation.basic.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandleConcept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\browserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.freecrm.com/");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Praveenk");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()", loginBtn);
		
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("mainpanel");
		
		//Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("leftpanel");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Messages')]")).click();
		
		String crm=driver.getTitle();
		System.out.println(crm);
		
		//driver.close();
		
		
		



	}

}
