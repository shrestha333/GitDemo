package com.zorbasofted;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainFirefox {
	public static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		try {
			ReadProperty property = new ReadProperty();
			Properties p = property.readFile();

			System.setProperty(p.getProperty("firefoxDrivername"), p.getProperty("firefoxDriverPath"));

			driver = new FirefoxDriver();
			driver.get(p.getProperty("facebookurl"));
			driver.manage().window().maximize();

			WebElement email = driver.findElement(By.name(p.getProperty("facebookEmail")));
			email.sendKeys("abc@gmail.com");

			WebElement pswrd = driver.findElement(By.name(p.getProperty("facebookPassword")));
			pswrd.sendKeys("America@210");

			WebElement login = driver.findElement(By.name(p.getProperty("facebookLogin")));
			login.click();
			Thread.sleep(6000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		
		
		
		
	}
	
	
	
}
