package com.zorbasofted;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookSignup {

	public static WebDriver driver = null;

	public static void main(String[] args) {
		
		try{
			ReadProperty property= new ReadProperty();
			Properties p=property.readFile();
			
			System.setProperty(p.getProperty("chromeDriverName"), p.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			driver.get(p.getProperty("facebookurl"));
			driver.manage().window().maximize();
			
			WebElement create_ac=driver.findElement(By.linkText("Create new account"));
			create_ac.click();
			
			WebElement firstName=driver.findElement(By.cssSelector("input#u_c_b_JM[name=firstname]"));
			firstName.sendKeys("aawash");
		
			
			Thread.sleep(5000);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			driver.quit();
			
		}
		
		
		
		
	}

}
