package test2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Medical {

	@Test
	public void createPatient() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.openemr.io/a/openemr");
		
		driver.findElement(By.name("authUser")).sendKeys("admin");
		driver.findElement(By.name("clearPass")).sendKeys("pass");
		Select language=new Select(driver.findElement(By.name("languageChoice")));
		language.selectByValue("18");
		driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[3]/div[1]/div[5]/button")).click();
		
		Actions act = new Actions(driver);
		
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu_logo\"]/div/div/span[5]/div/div"))).build().perform();
		
		act.click(driver.findElement(By.xpath("//*[@id=\"menu_logo\"]/div/div/span[5]/div/ul/li[2]/div"))).build().perform();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"framesDisplay\"]/div[3]/iframe")));
		Thread.sleep(5000);
		
		driver.findElement(By.name("form_fname")).sendKeys("xyz");
		driver.findElement(By.name("form_lname")).sendKeys("abc");
		driver.findElement(By.name("form_DOB")).sendKeys("2020-03-05");
		//driver.findElement(arg0)
		Select gender=new Select(driver.findElement(By.id("form_sex")));
		gender.selectByVisibleText("Female");
		driver.findElement(By.name("create")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"modalframe\"]")));
		driver.findElement(By.xpath("/html/body/center/input")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.name("bdayreminder")));
		driver.findElement(By.name("bdayreminder")).getText();
	}
	
	
	
	
}
