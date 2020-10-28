package com.starwood.qa.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.starwood.qa.base.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaypalStepsTest extends BaseClass {
	//WebDriver driver;
	
	
	
//	public paypalsteps(WebDriver driver) {
//	this.driver=driver;
//		
//	}

	public PaypalStepsTest() {      
		super(); 
		   
	}

	@And("^click on the search bar$")
	public void searchBar() {
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("buche");
		System.out.println("it clicked on the search bar");
	}
	
	
	
	@And("^Mouse hover on the products menu$")
	public void mouseHover() {
		Actions act=new Actions(driver);
		WebElement submenu=driver.findElement(By.xpath("(//span[text()='Produkte'])[1]"));
		act.moveToElement(submenu).build().perform();
		
	}
	
	
	@When("^click on the spindeltreppen$")
	public void click_on_the_spindeltreppen() {
		driver.findElement(By.xpath("(//span[contains(text(),'Spindeltreppen')])[1]")).click();
	    
	}
	@When("^click on the first product of category page$")
	public void click_on_the_first_product_of_category_page() {
		driver.findElement(By.xpath("//a[contains(text(),'Spindeltreppe ZIP-0 Wendeltreppe aus Stahl mit Holzstufen')]")).click();
	    
	}
	@Then("^PDP will open$")
	public void pdp_will_open() {
		String url=driver.getCurrentUrl();
		System.out.println(url);
	    
	}
	@Then("^click on the paypal button$")
	public void click_on_the_paypal_button() {
		driver.findElement(By.xpath("//input[@alt='Mit PayPal bezahlen']")).click();

	
	}


// hello i am starwood

}
