package com.zorbasofted;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingPractise {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

		String parentHandle = driver.getWindowHandle();

		driver.findElement(By.id("newWindowsBtn")).click();

		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {

			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				driver.findElement(By.name("name")).sendKeys("aawash");
				driver.manage().window().maximize();
				Thread.sleep(5000);
				driver.close();

			}

		}
		/*
		 * for (String handle : handles) {
		 * 
		 * if (!handle.equals(parentHandle)) { driver.switchTo().window(handle);
		 * driver.findElement(By.name("name")).click();
		 * driver.manage().window().maximize(); Thread.sleep(5000); }
		 * 
		 * }
		 */
	}
}