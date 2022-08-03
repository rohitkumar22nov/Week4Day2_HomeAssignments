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

public class HomeAsignment_2_ArchitectCertifications {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//		Assignments 2. Architect Certifications
//		==========================
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
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
//		4. Click  On Resources
		Set<String> setHandles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(setHandles);
		String firstHandle = listHandles.get(0);
		String secondHandle = listHandles.get(1);
		
		driver.switchTo().window(secondHandle);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		System.out.println("first Handle " + firstHandle);
		System.out.println("second Handle " + secondHandle);
		
//		5. Select SalesForce Certification Under Learnings
		dom.findElementByXPath("//span[text()='Learning']").click();
		Actions builder = new Actions(driver);
		WebElement learnTrailHead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		builder.moveToElement(learnTrailHead).perform();
		Thread.sleep(10000);
	WebElement certification =	dom.findElementByXPath("//a[text()='Salesforce Certification']");
	builder.moveToElement(certification).click().perform();

			
		
//		6. Choose Your Role as Salesforce Architect
	driver.findElement(By.xpath("//div[text()='Architect']")).click();
	
//		7. Get the Text(Summary) of Salesforce Architect 
	System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Salesforce Architects are the most trusted digital advisors')]")).getText());
	
//		8. Get the List of Salesforce Architect Certifications Available
	 List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='credentials-card ']"));
	 
	 for(WebElement e: findElements) {
		 System.out.println(e.getText());
	 }
	 
	
//		9. Click on Application Architect 
	 driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
	 
//		10.Get the List of Certifications available
	 List<WebElement> cards = driver.findElements(By.partialLinkText("/en/credentials/"));
	 
	 for(WebElement e: cards) {
		 System.out.println(e);
		 System.out.println(e.getText() + " -----");
	 }
		
		

	}

}
