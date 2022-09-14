package com.zorbasofted;

import java.util.List;import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PractiseDropDown {

	public static WebDriver driver = null;

	public static void main(String[] args) {
		try {

			System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(); //automation starts with
			driver.get("https://demoqa.com/");
			driver.manage().window().maximize();

			List<WebElement> forms = driver.findElements(By.xpath("//div[@class='card-body']"));
			for (int i = 0; i < forms.size(); i++) {
				if (i == 1) {
					forms.get(i).click();
				}
			}

			List<WebElement> practice = driver.findElements(By.cssSelector("li#item-0"));
			for (int i = 0; i < practice.size(); i++) {
				if (i == 1) {
					practice.get(i).click();

				}
				Thread.sleep(5000);
			}
			
		Select select =driver.findElement(By.xpath("//div[@class=' css-1hwfws3']"));
		for(int i=0;i<select.sele) {
			
		}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
