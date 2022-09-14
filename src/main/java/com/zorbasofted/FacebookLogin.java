package com.zorbasofted;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {
	public static WebDriver driver = null;

	public static void main(String[] args) {

		try {
			ReadProperty property = new ReadProperty();
			Properties p = property.readFile();

			System.setProperty(p.getProperty("chromeDriverName"), p.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			driver.get(p.getProperty("facebookurl"));
			driver.manage().window().maximize();

			WebElement emailad = driver.findElement(By.id(p.getProperty("facebookEmail")));
			emailad.sendKeys("a.shrestha33333@gmail.com");
			WebElement pswd = driver.findElement(By.id(p.getProperty("facebookPassword")));
			pswd.sendKeys("Nepal@123");
			WebElement clicklogin = driver.findElement(By.name(p.getProperty("facebookLogin")));
			clicklogin.click();
			
			//this is used for css
			
			/*
			 * WebElement element= driver.findElement(By.cssSelector("input#email"));
			 * element.sendKeys("ahjsdhjs");
			 */
			
			Thread.sleep(6000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();

		}

	}

}
