package testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example1 {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		System.out.println("First Window:"+driver.getTitle());
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.facebook.com/");
		System.out.println("Second Window:"+driver.getTitle());
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("http://gmail.com");
		System.out.println("Third Window:"+driver.getTitle());
		
		driver.findElement(By.linkText("Sign in")).click();
		Set<String>winHandles=driver.getWindowHandles();
		Iterator<String>iterator=winHandles.iterator();
		String firstWindow=iterator.next();
		String secondWindow=iterator.next();
		String thirdWindow=iterator.next();
		String fourthwindow=iterator.next();
		driver.switchTo().window(fourthwindow);
		System.out.println("Fourth Window:"+driver.getTitle());
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("shwethashenoy156@gmail.com");
		driver.quit();
	}

}
