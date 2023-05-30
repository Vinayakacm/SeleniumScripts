

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Amazon {
	@Test
	public static void project() {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.amazon.in");
		 
		String parent = driver.getWindowHandle();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		
		Actions act = new Actions(driver);
		
		act.click(search).sendKeys("city of dijins:a year in delhi",Keys.ENTER).build().perform();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.cssSelector("img[src='https://m.media-amazon.com/images/I/51u8SeCRi1L._AC_UY218_.jpg'")).click();
		
		Set<String> handle= driver.getWindowHandles();
		
		for(String e : handle) {
			
			if(!e.equalsIgnoreCase(parent)) {
				
				driver.switchTo().window(e);
			}
		}
			driver.findElement(By.id("buy-now-button")).click();	
			
			WebElement email=driver.findElement(By.name("email"));
			
			email.sendKeys("7411993703",Keys.ENTER);
			
			WebElement pass = driver.findElement(By.name("password"));
			
			pass.sendKeys("Vinni@2000",Keys.ENTER);
	
		
	}	

}

