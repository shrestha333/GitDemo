package com.zorbasofted;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.Timeout;

public class FacebookCss {
	public static WebDriver driver = null;

	public static void main(String[] args) {

		try {
			ReadProperty property = new ReadProperty();
			Properties p = property.readFile();

			System.setProperty(p.getProperty("chromeDriverName"), p.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			driver.get(p.getProperty("facebookurl"));
			driver.manage().window().maximize();

			// driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));--might be
			// used in another version

			/*--this might work in another version*/

			// Tag and ID--
			// WebElement emailad = driver.findElement(By.cssSelector("input#email"));
			// emailad.sendKeys("a.shrestha33333@gmail.com");

			// Tag and Class--
			// WebElement emailad= driver.findElement(By.cssSelector("input.inputtext "));
			// emailad.sendKeys("a.shrestha33333@gmail.com");

			// Tag and Attribute--
			// WebElement emailad= driver.findElement(By.cssSelector("input[id=email] "));
			// emailad.sendKeys("a.shrestha33333@gmail.com");

			// Tag, class and attribute--
			// WebElement
			// emailad=driver.findElement(By.cssSelector("input.inputtext[name=email]"));
			// emailad.sendKeys("a.shrestha33333@gmail.com");

			// Tag, id and attribute --
			// WebElement
			// emailad=driver.findElement(By.cssSelector("input#email[id=email]"));
			// emailad.sendKeys("a.shrestha33333@gmail.com");

			// xpath

			// WebElement emailad=dri
			// Sub-String matches--
			WebElement emailad = driver.findElement(By.cssSelector("input[id^=em]"));
			emailad.sendKeys("a.shrestha33333@gmail.com");
			//explicit
			/*
			 * WebDriverWait webDriverWait = new WebDriverWait(driver,
			 * Duration.ofMinutes(1));
			 * webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.
			 * cssSelector("input[name=pass]")));
			 */

			// fluentwait object creation

			/*
			 * FluentWait fluentWait= new FluentWait(driver); //wait time
			 * fluentWait.withTimeout(Duration.ofMillis(5000)); //polling time
			 * fluentWait.pollingEvery(Duration.ofMillis(200)); //specify the exception to
			 * ignore fluentWait.ignoring(NoSuchElementException.class); //expected
			 * condition should meet fluentWait.until(ExpectedConditions.alertIsPresent());
			 */
try {
			Wait wait = (Wait) new FluentWait(driver).withTimeout(Duration.ofMillis(5000))
					.pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name=pass]")));
}catch (Exception e) {
	e.printStackTrace();
}

			WebElement pswd = driver.findElement(By.cssSelector("input[name=pass]"));
			pswd.sendKeys("Nepal@123");

			WebElement clickLogin = driver.findElement(By.cssSelector("button.selected[name=login]"));
			clickLogin.click();

			Thread.sleep(6000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();

		}

	}

}
