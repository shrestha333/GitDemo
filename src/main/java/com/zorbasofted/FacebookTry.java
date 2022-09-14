package com.zorbasofted;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.Timeout;

public class FacebookTry {
	public static WebDriver driver = null;

	public static void main(String[] args) {
		try {
			ReadProperty prop = new ReadProperty();
			Properties p = prop.readFile();

			System.setProperty(p.getProperty("chromeDriverName"), p.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(p.getProperty("facebookurl"));

			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys("a.shrestha33333@gmail.com");

			WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
			webDriverWait.until(ExpectedConditions.visibilityOf(email));

			WebElement psw = driver.findElement(By.cssSelector("input[name=pass]"));
			psw.sendKeys("Nepal@123");

			/*
			 * WebDriverWait webDriverWait = new WebDriverWait(driver,
			 * Duration.ofMinutes(1));
			 * webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.
			 * cssSelector("input[name=pass]")));
			 */

			WebElement clickElement = driver.findElement(By.cssSelector("button.selected[name=login]"));
			clickElement.click();
try {
			Wait wait = (Wait) new FluentWait(driver).withTimeout(Duration.ofMillis(5000))
					.pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name=pass]")));
}catch (Exception e) {
	e.printStackTrace();
}
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
