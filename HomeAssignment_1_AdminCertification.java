package week4.Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class HomeAssignment_1_AdminCertification {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
//		Assignments 1. Administrator Certifications
//		==============================
//		1. Launch Salesforce application https://login.salesforce.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Shadow dom = new Shadow(driver);
			
//		2. Login with username as "ramkumar.ramaiah@testleaf.com " and password as "Password$123"
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();
		
		
//		3. Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
//		4. Click confirm on Confirm redirect
		Set<String> setHandles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(setHandles);
		String firstHandle = listHandles.get(0);
		String secondHandle = listHandles.get(1);
		
		driver.switchTo().window(secondHandle);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		System.out.println("first Handle " + firstHandle);
		System.out.println("second Handle " + secondHandle);
				
//		5. Click Resources and mouse hover on Learning On Trailhead
		dom.findElementByXPath("//span[text()='Resources']").click();
		Actions builder = new Actions(driver);
		WebElement learnTrailHead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		builder.moveToElement(learnTrailHead).perform();
		
		
//		6. Clilck on Salesforce Certifications
	//	driver.switchTo().frame(0);
		Thread.sleep(10000);
	WebElement certification =	dom.findElementByXPath("//a[text()='Salesforce Certification']");
	builder.moveToElement(certification).click().perform();
		
		
//		6. Click on Ceritification Administrator
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();

		
		
//		7. Navigate to Certification - Administrator Overview window
		driver.switchTo().window(firstHandle);
		
		

	}

}
