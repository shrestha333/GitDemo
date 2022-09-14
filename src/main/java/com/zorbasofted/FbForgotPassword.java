package com.zorbasofted;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbForgotPassword {
	public static WebDriver driver = null;

	public static void main(String[] args) {

		try {
			ReadProperty property = new ReadProperty();
			Properties p = property.readFile();

			System.setProperty(p.getProperty("chromeDriverName"), p.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			driver.get(p.getProperty("facebookurl"));
			driver.manage().window().maximize();

			WebElement forget_pswd = driver.findElement(By.linkText(p.getProperty("forgetFbPswd")));
			forget_pswd.click();
			WebElement search_email = driver.findElement(By.id(p.getProperty("searchAccount")));
			search_email.sendKeys("abc@gmail.com");
			WebElement click_search = driver.findElement(By.id(p.getProperty("searchClick")));
			click_search.click();

			WebElement clickoption = driver.findElement(By.xpath("//*[text()='Continue']"));
			clickoption.click();

			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();

		}

	}

}
