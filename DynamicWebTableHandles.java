package automation.basic.selenium;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandles {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\browserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.freecrm.com/");
		
		//ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Praveenk");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()", loginBtn);
		 
		 Thread.sleep(3000);
			driver.switchTo().frame("mainpanel");
			
			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
			
			//*[@id='vContactsForm']/table/tbody/tr[4]/td[2]/a
			//*[@id='vContactsForm']/table/tbody/tr[8]/td[2]/a
			
			String before_xpath="//*[@id='vContactsForm']/table/tbody/tr[";
			String after_xpath="]/td[2]/a";
			
			/*for(int i=4;i<=8;i++)
			{
				String name=driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
				System.out.println(name);
				
				if(name.contains("Natwar Lal"))
				{
					//*[@id='vContactsForm']/table/tbody/tr[7]/td[1]
					driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[1]")).click();
				}
			}*/
			
			driver.findElement(By.xpath("//input[@name='contact_id' and @value='51319034']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'nandam Nathan')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		
			

	}

}
