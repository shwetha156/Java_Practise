package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example2 {

	public static void main(String[] args) 
	{
		//*Realtive locator example from selenium alpha*//
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("trainer@way2automation.com");
		//driver.findElement(By.xpath("//*[@id=\"load_form\"]/div/div[2]/input")).click();
		driver.findElement(RelativeLocator.withTagName("input").below(By.xpath("(//input[@name='password'])[2]"))).click();
	}

}
