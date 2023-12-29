import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeTimeCount {
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
@Test(priority = 2)
public void CreateNew() {
	Actions a1=new Actions(driver);
	a1.moveToElement(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/main/section/div[1]/div/div[2]/div/div[2]/button"))).build().perform();
	driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[3]/span")).click();
	
}
@Test(priority = 3)
public void basicInformation() {
	driver.findElement(By.xpath("//input[@name=\"title\"]")).sendKeys("QA");
	driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Rohit ");
	driver.findElement(By.xpath("//input[@placeholder='Surname']")).sendKeys("Sharma");
	driver.findElement(By.xpath("//input[@placeholder='Officer Code']")).sendKeys("MUM213");
	
	WebElement w1=driver.findElement(By.xpath("//select[@placeholder='Employment Status']"));
	Select s1=new Select(w1);
	s1.selectByValue("Full-Time");
	
	//driver.findElement(By.xpath("//input[@placeholder='e.g House number and street name']")).click();
	
	driver.findElement(By.xpath("//input[@id='rc_select_8']")).click();
	
	List<WebElement> listRole=driver.findElements(By.xpath("//div[@class=\"rc-virtual-list-holder-inner\"]/div"));
	System.out.println("Number Of Dropdown in Roles value="+listRole.size());
	
	
	
	
}
}
