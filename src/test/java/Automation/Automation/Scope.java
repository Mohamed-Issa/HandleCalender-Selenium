package Automation.Automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.findElements(By.tagName("a")).size());

		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		WebElement colElement = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

		System.out.println(colElement.findElements(By.tagName("a")).size());

		int size = colElement.findElements(By.tagName("a")).size();

		for (int i = 1; i < size; ++i) {

			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			colElement.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(5000);

		}

		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
