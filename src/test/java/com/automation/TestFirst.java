package com.automation;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestFirst {

	@AfterSuite
	public void Test() {
		System.out.println("this is test");

	}

	@Test(groups = { "smoketest","sanity" })
	public void Test1() {

		System.out.println("this is test1");

	}

	@Test(groups = { "smoketest" })
	public void Test2() {

		System.out.println("this is test2");

	}

	@Test(groups = {"sanity"})
	public void Test3() {

		System.out.println("this is test3");

	}
}