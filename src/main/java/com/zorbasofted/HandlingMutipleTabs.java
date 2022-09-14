package com.zorbasofted;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMutipleTabs {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

		String parentHandle = driver.getWindowHandle();

		driver.findElement(By.id("newTabBtn")).click();

		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				driver.findElement(By.id("alertBox")).click();
				driver.switchTo().alert().accept();
				

			}

		}

	}

}
