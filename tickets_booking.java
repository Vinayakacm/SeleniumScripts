import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class tickets_booking {
	@Test
	public static void book() {
		//Departure date
		
			String Dmonth = "July 2023";
		
	     	String Dday = "7";
		
				
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.ixigo.com/");
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[1]/div/div[1]/div")).click();
		
		WebElement from = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[1]/div/div[1]/input"));
		
		from.sendKeys("bengaluru");
		
		from.sendKeys(Keys.ENTER);
		
		WebElement to = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[3]/div/div[1]/input"));
		
		to.sendKeys("delhi");
		
		to.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[4]/div/div[1]/div/input")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		while(true) {
			
			String text1 = driver.findElement(By.className("rd-month-label")).getText();
			
			if(text1.equals(Dmonth)) {
			
				break;
			}
			
			else {
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/button")).click();
			}
			
		}
		
		 	List<WebElement> alldates =driver.findElements(By.xpath("/html/body/div[2]/div[2]/div[1]/table/tbody/tr/td/div[1]"));
		 	
		 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			for(WebElement ele : alldates) {
				
				String date = ele.getText();
				
				if(date.equals(Dday)) {
					
					ele.click();
					
					break;
				}
				
			}  
			
			//Return date
			
			String Rmonth = "November 2023";
			
			String Rday = "7";
			
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[4]/div/div[2]/div/input")).click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			while(true) {
				
			String text2 = driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div")).getText();
			
			if(text2.equals(Rmonth)) {
				
				break;
			}
			
			else {
				
				driver.findElement(By.xpath("/html/body/div[7]/div[2]/div[2]/button")).click();
			}
	}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			List<WebElement> ddates = driver.findElements(By.xpath("/html/body/div[7]/div[2]/div[1]/table/tbody/tr/td/div[1]"));
			
			for(WebElement elee : ddates) {
				
				String dates = elee.getText();
				
				if(dates.equals(Rday)) {
					
					elee.click();
					
					break;
					
				}
				
			}
			
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[6]/button/div")).click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	}
}
