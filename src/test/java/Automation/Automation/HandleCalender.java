package Automation.Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCalender {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// driver.manage().window().maximize();

		driver.get("https://www.path2usa.com/travel-companions");
		
		Thread.sleep(5000);

		driver.findElement(By.id("travel_date")).click();
		
			
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='datepicker-switch']")).getText().contains("August")) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}

		List<WebElement> dates = driver.findElements(By.className("day"));
		int count = dates.size();

		for (int i = 0; i < count; ++i) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if (text.equalsIgnoreCase("19")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}

	}

}
