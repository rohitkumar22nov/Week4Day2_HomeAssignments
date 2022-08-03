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

public class HomeAssignment_3_Customer_Service_Options {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		Assignments 3.Customer_Service_Options
//		====================================
//		1. Launch Salesforce application https://login.salesforce.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Shadow dom = new Shadow(driver);

		
//		2. Login with Provided Credentials
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();

		
//		3. Click on Learn More link in Mobile Publisher
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
//		4. Clilck on Products and Mousehover on Service 
		Set<String> setHandles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(setHandles);
		String firstHandle = listHandles.get(0);
		String secondHandle = listHandles.get(1);
		
		driver.switchTo().window(secondHandle);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		System.out.println("first Handle " + firstHandle);
		System.out.println("second Handle " + secondHandle);
		dom.findElementByXPath("//span[text()='Products']").click();
		Actions builder = new Actions(driver);
		
		WebElement learnTrailHead = dom.findElementByXPath("//span[text()='Service']");
		builder.moveToElement(learnTrailHead).perform();

			
//		5. Click on Customer Services
		Thread.sleep(10000);
	WebElement customerServices =	dom.findElementByXPath("//a[text()='Customer Service']");
	builder.moveToElement(customerServices).click().perform();
		
//		6. Get the names Of Services Available ////a[@class='page-list-item ']
	List<WebElement> serviceList = driver.findElements(By.xpath("//a[@class='page-list-item ']"));
	
		
	for(WebElement e: serviceList) {
		System.out.println(e.getText());
	}
	
	
//		7. Verify the title

		System.out.println(driver.getTitle());
	}

}
