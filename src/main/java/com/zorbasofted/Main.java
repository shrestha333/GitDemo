package com.zorbasofted;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

	public static WebDriver driver = null;

	public static void main(String[] args) {

		// --setting the path for chromedriver in JVM

		// --this is for chrome
		try {

			ReadProperty property = new ReadProperty();
			Properties p = property.readFile();

			// System.setProperty("webdriver.chrome.driver", "C:\\chrome
			// driver\\chromedriver_win32\\chromedriver.exe");
			// mathiko sato tala ko lekheko haai
			System.setProperty(p.getProperty("chromeDriverName"), p.getProperty("chromeDriverPath"));

			// ---creating chromedriver object

			driver = new ChromeDriver();

			// driver.get("https://youtube.com");
			// mathi ko sato ttala ko gareko
			driver.get(p.getProperty("facebookurl"));

			driver.manage().window().maximize(); // just to maximize when open
 
			// WebElement searchbox =
			// driver.findElement(By.name(p.getProperty("googleSearchName")));

			// searchbox.sendKeys("China");
			// Thread.sleep(5000);
			
			List<WebElement>  emails = driver.findElements(By.tagName("input"));
			for(int i = 0; i< emails.size() ; i ++) {
				if( i == 2) {
				emails.get(i).sendKeys("abc@gmail.com");
				break;
				}
			}
			
			//email.sendKeys("abc@gmail.com");
			
			
			WebElement pswrd=driver.findElement(By.id(p.getProperty("facebookPassword")));
			pswrd.sendKeys("America@210");
			
			WebElement forgot_password = driver.findElement(By.partialLinkText("Forgot password?"));
			forgot_password.click();
			
			WebElement login = driver.findElement(By.className("selected"));
			login.click();
			Thread.sleep(6000);

			/*
			 * WebElement click =
			 * driver.findElement(By.name(p.getProperty("googleSearchclick")));
			 * click.click(); WebElement
			 * youtube=driver.findElement(By.name(p.getProperty("youtubesearch")));
			 * youtube.sendKeys("Apple"); Thread.sleep(5000); WebElement
			 * facebook=driver.findElement(By.name(p.getProperty("facebookSearch")));
			 * facebook.sendKeys("aawash.shrestha@gmail.com"); Thread.sleep(5000);
			 */

			// --this is for firefox

			// System.setProperty("webdriver.gecko.driver", "C:\\Firefox
			// driver\\geckodriver.exe");
			// driver= new FirefoxDriver();

			// --this is for microsoft edge

			// System.setProperty("webdriver.edge.driver", "C:\\microsoftedge
			// driver\\msedgedriver.exe");
			// driver= new EdgeDriver();

			// launch the browser with url

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
