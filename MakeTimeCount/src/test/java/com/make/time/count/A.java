package com.make.time.count;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A {
public static WebDriver driver;

@BeforeSuite
public void openBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}
@BeforeTest
public void enterUrl() {
	driver.get("https://ppnreact.maketimecount.today/login");
}
@BeforeClass
public void maximizeScreen() {
	driver.manage().window().maximize();
}
@BeforeMethod
public void timeout() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
}
@Test(priority = 1)
public void loginPage() throws Exception {
	driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("admin1@gmail.co.uk");
	driver.findElement(By.xpath("//input[@id=\"passwordField\"]")).sendKeys("Mtc@12345");
	driver.findElement(By.xpath("//button[@title=\"Login\"]")).click();
	//Thread.sleep(4000);
}
//@Test(priority = 2)
	System.out.println("Hello");

}
