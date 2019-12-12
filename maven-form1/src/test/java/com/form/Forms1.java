package com.form;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Forms1 {
WebDriver driver;
	
	@DataProvider(name="MSData") 
	public Object[][] getdata() {
		Object[][] data = new Object[5][5];
		
		data[0][0] = "Cust1"; //Output: Getting an error message to enter valid email address
		data[0][1] = "Cust2";
		data[0][2] = "Test Subject1";
		data[0][3] = "Cust4";
		data[0][4] = "Test Comments.\n Test.";
		
		data[1][0] = "";  //Output: Report is generated successfully 
		data[1][1] = "";
		data[1][2] = "";
		data[1][3] = "";
		data[1][4] = "";
		
		data[2][0] = "TestUser3"; //Output: Report is generated successfully
		data[2][1] = "User2@yahoo.com";
		data[2][2] = "Test Subject3";
		data[2][3] = "User4";
		data[2][4] = "Test Comments.\nTest behavior.\n Testing.\n Comments.";
		
		data[3][0] = "TestUser4"; //Output: Getting an error message to enter valid email address
		data[3][1] = "abcdefghijklmnopqrstuvwxyz1234567890123456789@gmail.com";
		data[3][2] = "Test Subject4";
		data[3][3] = "User4";
		data[3][4] = "Test Comments.\nTest behavior.\n Testing.\n Comments.";
		
		data[4][0] = "TestUser5"; //Output: Successful
		data[4][1] = "User 5@yahoo.com";
		data[4][2] = "Test Subject5";
		data[4][3] = "User5";
		data[4][4] = "Test Comments.\n Test behavior.\n Testing.\n Comments.\n Battery is very slow. \n Testing. \n Testing. \n Testing. \n Testing. \n Testing. \n Testing. \n Testing.";
		
		
		return data;
	}
	
	
	@Test(dataProvider="MSData")
	
	public void MsForm(String custName, String email1, String sub, String ft, String com) throws Exception {
		
		
		WebElement name = driver.findElement(By.name("customer_name"));
		// name.sendKeys("Cust_name");
		name.sendKeys(custName);
		
		WebElement email = driver.findElement(By.name("customer_email"));
		//email.sendKeys("test1@gmail.com");
		email.sendKeys(email1);
		
		WebElement subject = driver.findElement(By.name("subject"));
	//	subject.sendKeys("Battery Performance");
		subject.sendKeys(sub);
		
		 WebElement feedbacktype = driver.findElement(By.tagName("select"));
		  Select typeDrop = new Select(feedbacktype);
		  typeDrop.selectByIndex(3);
		  //typeDrop.selectByVisibleText(ft);
		  
		  WebElement comments= driver.findElement(By.name("feedback_comment"));
		 // System.out.println("Enter Comments:");
		  comments.sendKeys(com);
		  Thread.sleep(3000);
		  
			 WebElement subButton = driver.findElement(By.name("submit"));
			  subButton.click();
			  
			  
		}
		
		 @BeforeClass
		  public void beforeClass() {
			  
					System.setProperty("webdrive.chrome.driver","/Users/leena/eclipse-workspace/SeleniumTests/chromedriver");
				    driver = new ChromeDriver();
				    driver.get("https://xw05.miao.apple.com/feedback/imac.html"); 
				    
				/*  Scanner scan = new Scanner (System.in);
					  System.out.println("Enter URL:");
					  String url = scan.nextLine();
					  driver.get(url);*/
		  }

		  @AfterClass
		  public void afterClass() throws InterruptedException {
			  Thread.sleep(5000);
			  driver.close();
		  }


}
