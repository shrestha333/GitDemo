package com.zorbasofted;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DummySelenium {
	public static WebDriver driver = null;

	public static void main(String[] args) {
		try {

			System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://demoqa.com/");
			driver.manage().window().maximize();
			
			

			List<WebElement> alertFrameWindow = driver.findElements(By.cssSelector("div.card-up"));
			for (int i = 0; i < alertFrameWindow.size(); i++) {
				if (i == 2) {
					alertFrameWindow.get(i).click();
					break;
				}
			}
			Thread.sleep(5000);
			/*
			 * List<WebElement> alert0 =
			 * driver.findElements(By.xpath("//div[@class='header-text']")); for (int i = 0;
			 * i < alert0.size(); i++) { if (i == 2) { alert0.get(i).click(); break; } }
			 * Thread.sleep(5000);
			 */

			List<WebElement> clickAlert = driver.findElements(By.cssSelector("li#item-1"));
			for (int i = 0; i < clickAlert.size(); i++) {
				if (i == 1) {
					clickAlert.get(i).click();
				}
			}
			//Thread.sleep(5000);

			WebElement click1 = driver.findElement(By.xpath("//button[@id='alertButton' and @type='button' and @class='btn btn-primary']"));
			click1.click();
			driver.switchTo().alert().accept();
			//Thread.sleep(5000);

			WebElement click3 = driver.findElement(By.xpath("//button[@id='confirmButton' ]"));
			click3.click();
			String message = driver.switchTo().alert().getText();
			System.out.println(message);
			driver.switchTo().alert().dismiss();
			
			//Thread.sleep(5000);

		    driver.findElement(By.xpath("//button[@id='promtButton']")).click();
			//click4.click();
			String popupMsg = driver.switchTo().alert().getText();
			System.out.println(popupMsg);
			driver.switchTo().alert().sendKeys("test");
			driver.switchTo().alert().accept();
			Thread.sleep(5000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
