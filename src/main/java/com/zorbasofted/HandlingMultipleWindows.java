package com.zorbasofted;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleWindows {

	public static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\\\chrome driver\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		// storing main window handle(parent windowhandle) after opening above link
		String parentHandle = driver.getWindowHandle();

		// just printing, no logic
		System.out.println("parent window" + " " + parentHandle);

		driver.findElement(By.id("newWindowBtn")).click();
		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				driver.findElement(By.id("firstName")).sendKeys("aawash");
				Thread.sleep(5000);
				driver.close();//close currrent window
			}
			
			
		}
		//switching back to parent window
		driver.switchTo().window(parentHandle);
		driver.findElement(By.id("name")).sendKeys("just for test");

		//driver.quit();//close all the windows.
	}

}
