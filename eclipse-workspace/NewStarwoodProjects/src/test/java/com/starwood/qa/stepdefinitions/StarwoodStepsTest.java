package com.starwood.qa.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.starwood.qa.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StarwoodStepsTest extends BaseClass {	

@Given("^I launch chrome browser$")
public void i_launch_chrome_browser() {
	
	System.out.println("chrome browser launched");
   
}

@When("^I open Starwood homepage$")
public void i_open_starwood_homepage() throws Throwable {
	driver.findElement(By.xpath("//i[contains(@class,'fa fa-user')]")).click();
	driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("kumar.saurabh@pixelmechanics.de");
	driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("Saurabh@12345");
	driver.findElement(By.xpath("(//span[contains(text(),'Anmelden')])[1]")).click();
	driver.findElement(By.xpath("//button[@id='btn-cookie-allow']")).click();
	
   
}
@Before
public void setupApplication() {
	Reporter.log("====Browser session started===", true);
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://demo:20pixel19!@m2.dev.starwood-treppenshop.de/");
	Reporter.log("====Application started===", true);
	
}


@Then("^I verify that logo present on the page$")
public void i_verify_that_logo_present_on_the_page() {
	boolean status=driver.findElement(By.xpath("//img[@title='StarWood Treppenshop']")).isDisplayed();
	Assert.assertEquals(true, status);
   
}

@And("^close the browser$")
public void close_the_browser() {
	System.out.println("Browser closed");
    
}

@After
public void closeApplication() {
	driver.quit();
	Reporter.log("====Browser session End===", true);
}


//code for the mouse hover
@And("^I do mouse hover on products tab$")
public void mouseHover() throws Throwable {
	Actions act=new Actions(driver);
	WebElement submenu=driver.findElement(By.xpath("(//span[text()='Produkte'])[1]"));
	act.moveToElement(submenu).build().perform();
	System.out.println("Mouse hover done successfully");
	Thread.sleep(1000);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//span[starts-with(text(),'Auﬂentreppen')]")).click();
	driver.findElement(By.xpath("//button[@id='btn-cookie-allow']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[contains(text(),'Spindeltreppe PINIO aus massiven Stahl mit Gel‰nder und Podest  - feuerverzinkt')]")).click();
	driver.findElement(By.xpath("//select[@class='super-attribute-select']")).click();
	Select sel=new Select(driver.findElement(By.id("attribute141")));
	sel.selectByIndex(1);
	driver.findElement(By.xpath("//span[contains(text(),'In den Warenkorb')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[contains(.,'Zur Kasse')]")).click();
	driver.findElement(By.xpath("(//span[contains(text(),'Anmelden')])[1]")).click();
	Thread.sleep(1000);
	WebElement ele=driver.findElement(By.xpath("//span[starts-with(text(),'Weiter')]"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", ele);
	
	driver.findElement(By.xpath("//span[contains(text(),'Vorkasse')]")).click();
	
	driver.findElement(By.xpath("//input[contains(@id,'agreement__1')]")).click();
	driver.findElement(By.xpath("//input[contains(@id,'agreement__2')]")).click();
	
	driver.findElement(By.xpath("(//button[contains(.,'Zahlungspflichtig bestellen')])[4]")).click();
	

	



}




}
