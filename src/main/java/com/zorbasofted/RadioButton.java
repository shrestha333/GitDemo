package com.zorbasofted;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {
	public static WebDriver driver;

	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com/");

			/*
			 * WebDriverWait webDriverWait = new WebDriverWait(driver,
			 * Duration.ofSeconds(5));
			 * webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.
			 * xpath("//a[@role='button' and @id='u_0_0_QF']")));
			 */

			driver.findElement(By.linkText("Create new account")).click();

			driver.findElement(By.name("firstname")).sendKeys("test");
			

		
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
