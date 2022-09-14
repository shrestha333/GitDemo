package com.zorbasofted;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.org.apache.xpath.internal.operations.Div;

public class WaitConcept {
	public static WebDriver driver = null;

	public static void main(String[] args) {
		try {
			ReadProperty property = new ReadProperty();
			Properties p = property.readFile();

			System.setProperty(p.getProperty("chromeDriverName"), p.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			driver.get("https://demoqa.com/");
			driver.manage().window().maximize();

			WebElement click1 = driver.findElement(By.cssSelector("div.card-up"));
			click1.click();
			Thread.sleep(5000);

			/*
			 * List<WebElement> click2 =
			 * driver.findElements(By.cssSelector("li.btn btn-light A")); for(int i = 0; i<
			 * click2.size() ; i ++) { if( i == 2) { click2.get(i).click(); break; } }
			 */

			/*
			 * WebElement alertFrame=driver.findElement(By.
			 * xpath("//li[@class='btn btn-light' and @id='item-1']")); alertFrame.click();
			 * Thread.sleep(5000);
			 */

			List<WebElement> alert0 = driver.findElements(By.xpath("//div[@class='header-text']"));
			for (int i = 0; i < alert0.size(); i++) {
				if (i == 2) {
					alert0.get(i).click();
					break;
				}
			}

			List<WebElement> clickAlert = driver
					.findElements(By.xpath("//li[@class='btn btn-light active' and @id='item-1']"));
			for (int i = 0; i < clickAlert.size(); i++) {
				if (i == 0) {
					clickAlert.get(i).click();
					break;
				}
			}

			Thread.sleep(5000);

			WebElement alert1 = driver.findElement(By.id("alertButton"));
			alert1.click();
			driver.switchTo().alert().accept();

			Thread.sleep(5000);

			WebElement alert2 = driver.findElement(By.id("confirmButton"));
			alert2.click();
			String value = driver.switchTo().alert().getText();
			System.out.println(value);
			driver.switchTo().alert().dismiss();

			Thread.sleep(5000);

			WebElement alert3 = driver.findElement(By.id("promtButton"));
			alert3.click();
			String value1 = driver.switchTo().alert().getText();
			System.out.println(value1);
			driver.switchTo().alert().sendKeys("this is for test");
			driver.switchTo().alert().accept();

			Thread.sleep(6000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();

		}

	}

}
