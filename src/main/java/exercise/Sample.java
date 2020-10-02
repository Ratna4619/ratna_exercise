package exercise;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;
import org.testng.annotations.Test;



public class Sample {
	
	public static void TakeScreenshot (WebDriver webdriver,String fileWithPath) throws IOException {
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);	
		File DestFile=new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
		
	}
	
	@Test
	public static void Example () throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\AutomationExercise\\lib\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(opt);
		driver.navigate().to("http://stage-newstuck.onemindindia.com");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		  // Verify an error for username field if enter a wrong username
		  
		  driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("Ratna");
		  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("$tageN3w5tuckCu6ato6");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@value='Login']")).click();
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");

		  WebElement UsrTxtErrMsg = driver.findElement(By.
		  xpath("//div[contains(text(),'Username Or Password Is Incorrect')]"));
		  String expectedErrTxt = "Username Or Password Is Incorrect";
		  String actualErrTxt = UsrTxtErrMsg.getText();
		  //Comparing error text messages
		  if(actualErrTxt.equals(expectedErrTxt))
		  { 
			  System.out.println(" The Actual and Expected Error messages are same. An Error messgae is "+actualErrTxt);
		  } 
		  else 
		  {	  
			  System.out.println(" The Actual and Expected Error messages are Not same. Displayed Error messgae is "+actualErrTxt); 
		  }	  
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  
		
		  //Verify an error messgae for password field if enter a wrong password
		  
		  driver.findElement(By.xpath("//input[@formcontrolname='username']")).clear();
		  driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("StageCurator");
		  driver.findElement(By.xpath("//input[@type='password']")).clear();
		  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("$Ratna");
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//input[@value='Login']")).click();
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  
		  WebElement PswdTxtErrMsg = driver.findElement(By.xpath("//div[contains(text(),'Username Or Password Is Incorrect')]")); String
		  expectedErrTxt1 = "Username Or Password Is Incorrect";
		  String actualErrTxt1 = PswdTxtErrMsg.getText();
		  //Comparing error text messages
		  if(actualErrTxt1.equals(expectedErrTxt1))
		  { 
			  System.out.println(" The Actual and Expected Error messages are same. An Error messgae is "+actualErrTxt1);
			  } 
		  else
		  {
			  System.out.println(" The Actual and Expected Error messages are Not same. Displayed Error messgae is "+actualErrTxt1); 
			  }
		  Assert.assertTrue(true);
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  
		  
		  //Verify error messages for both username and password empty fields
		  
		  driver.navigate().to("http://stage-newstuck.onemindindia.com");
		  driver.findElement(By.xpath("//input[@formcontrolname='username']")).clear();
		  driver.findElement(By.xpath("//input[@type='password']")).clear();
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//input[@value='Login']")).click();
		  Thread.sleep(5000);
		  WebElement UsrfldErrMsg =driver.findElement(By.xpath("//small[contains(text(),'User ID is Required')]"));
		  String expectedErrTxt_User = "User ID is Required";
		  String actualErrTxt_User = UsrfldErrMsg.getText(); 
		  //Comparing error text messages
		  if(actualErrTxt_User.equals(expectedErrTxt_User)) 
		  {
			  System.out.println(" The Actual and Expected Error messages are same. An Error messgae is "+actualErrTxt_User);
		  }
		  else
		  {
			  System.out.
		  println(" The Actual and Expected Error messages are Not same. Displayed Error messgae is "+ actualErrTxt_User); 
		  }
		  Thread.sleep(5000);
		  
		  WebElement PswdfldErrMsg = driver.findElement(By.xpath("//small[contains(text(),'Password is Required')]"));
		  String expectedErrTxt_Pswd = "Password is Required";
		  String actualErrTxt_Pswd = PswdfldErrMsg.getText();
		  //Comparing error text messages
		  if(actualErrTxt_Pswd.equals(expectedErrTxt_Pswd)) 
		  {
			  System.out.println(" The Actual and Expected Error messages are same. An Error messgae is "+ actualErrTxt_Pswd);
		  } 
		  else
		  {
			  System.out.println(" The Actual and Expected Error messages are Not same. Displayed Error messgae is "+ actualErrTxt_Pswd); 
		  }
		  Assert.assertTrue(true);	
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  
		  // Verify the preview button to see the password text for verification purpose.	  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("$Ratna");		  
		  driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-login[1]/div[1]/div[1]/form[1]/div[2]/i[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-login[1]/div[1]/div[1]/form[1]/div[2]/i[1]")).click();
		  Thread.sleep(2000);
		  System.out.println("Preview icon is verified sucessfylly");
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  Assert.assertTrue(true); 		
		  
		  //Verify the system should Navigated from Login page to NewsTack Application Home page after click on Login button 
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("StageCurator");
		  driver.findElement(By.xpath("//input[@type='password']")).clear();
		  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("$tageN3w5tuckCu6ato6"); Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@value='Login']")).click();
		  Thread.sleep(6000);
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  WebElement headerText = driver.findElement(By.xpath("//a[contains(text(),'NEWSTUCK')]")); 
		  String expectedTxt = "NEWSTUCK"; 
		  String actualtxt = headerText.getText();
		  //Comparing error text messages 
		  if(actualtxt.equals(expectedTxt)) 
		  {
		  System.out.println(" The Actual and Expected Headers are same. Header is " + actualtxt); 
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  } 
		  else 
		  {
			  System.out. println(" The Actual and Expected Headers are Not same. Displayed Header is "+ actualtxt);
		  }
		  System.out.println("Header verification is Sucessfully");
		  Assert.assertTrue(true);	  
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  
		  //Verify the system should display the the current day’s news as default and should be able to change the dates and view the result based on dates selected
		  
		  driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-layout[1]/app-subeditorview[1]/div[1]/div[1]/div[1]/div[2]/i[1]")).click();
		  Thread.sleep(6000);
		  driver.findElement(By.xpath("//li[contains(text(),'Last 5 hours')]")).click();
		  System.out.println("Selected Last 5 hours ");
		  Thread.sleep(6000);
		  driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-layout[1]/app-subeditorview[1]/div[1]/div[1]/div[1]/div[2]/i[1]")).click(); Thread.sleep(5000);
		  driver.findElement(By.xpath("//li[contains(text(),'Last 3 days')]")).click();
		  System.out.println("Selected Last 3 days "); Thread.sleep(5000);
		  Assert.assertTrue(true);	
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  
		  // Verify the system should display details of news which are  category and Time of publication of news
		  
		  WebElement detailsOfNews = driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-layout[1]/app-subeditorview[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[1]/div[1]/ul")); 
		  String detailsOfNewsTxt = detailsOfNews.getText();
		  System.out.println(" The Details of First news is :" + detailsOfNewsTxt);
		  Thread.sleep(2000);
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  
		  driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-layout[1]/app-subeditorview[1]/div[1]/div[1]/div[1]/div[2]/i[1]")).click(); Thread.sleep(2000);
		  driver.findElement(By.xpath("//li[contains(text(),'Last 3 days')]")).click();
		  Thread.sleep(2000);
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  
		  WebElement detailsOfNews_3days = driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-layout[1]/app-subeditorview[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[1]/div[1]/ul"));
		  String detailsOfNewsTxt_3days = detailsOfNews_3days.getText();
		  System.out.println(" The Details of First news is :" +detailsOfNewsTxt_3days);
		  System.out.println("Verified last 3 days categiry and publication time");
		  Thread.sleep(2000); 
		  Assert.assertTrue(true);
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  
		  driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-layout[1]/app-subeditorview[1]/div[1]/div[1]/div[1]/div[2]/i[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//li[contains(text(),'Last 5 hours')]")).click();
		  Thread.sleep(2000);
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  
		  WebElement detailsOfNews_5hours = driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-layout[1]/app-subeditorview[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[1]/div[1]/ul"));
		  String detailsOfNewsTxt_5hrs = detailsOfNews_5hours.getText();
		  System.out.println(" The Details of First news is :" +detailsOfNewsTxt_5hrs);
		  System.out.println("Verified last 5 hours categiry and publication time");
		  Thread.sleep(2000); 
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  Assert.assertTrue(true);
		  
		  
		  //Verify the system should open the news in a different tab,On clicking of the news from the list view
		  
		  driver.findElement(By.xpath("/html/body/app-root/div/app-layout/app-subeditorview/div[2]/div[2]/div/div/div[1]/a")).click();
		  String title = driver.getTitle();
		  System.out.println("Title of the Current Window is :"+title);
		  Thread.sleep(5000);
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  String winHandleBefore = driver.getWindowHandle();
		  driver.switchTo().window(winHandleBefore);
		  System.out.println("Moved from Child Window to Parent window");
		  Assert.assertTrue(true);
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  
		  
		  //Verify Sub-Editor should be able to give the rating between 1-5
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-layout[1]/app-subeditorview[1]/div[2]/div[2]/div[1]/div[2]/ul[1]/li[4]/app-select[1]/div[1]/div[1]")).click();
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-layout[1]/app-subeditorview[1]/div[2]/div[2]/div[1]/div[2]/ul[1]/li[4]/app-select[1]/div[1]/ul[1]/li[5]")).click(); 
		  Thread.sleep(5000);
		  System.out.println("Rating Given sucessfully");
		  Assert.assertTrue(true);
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  
		  //Verify Sub-Editor should be able to send the reviewed news to the editor for review.
		  
		  driver.findElement(By.xpath("(//input[@id='defaultCheck1'])[1]")).click();
		  Thread.sleep(5000); 
		  driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-layout[1]/app-subeditorview[1]/div[1]/div[1]/div[1]/div[3]/label[1]/span[1]")).click();
		  Thread.sleep(5000);
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  driver.findElement(By.xpath("//a[text()= 'Send']")).click();
		  Thread.sleep(5000);
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  
		  WebElement PopUpText = driver.findElement(By.xpath("//p[contains(text(),'1 item sent to Editor')]")); 
		  String txtmsg = PopUpText.getText();
		  System.out.println("The Pop Up Message is :" + txtmsg);
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//a[contains(text(),'Browse Again')]")).click();
		  Thread.sleep(5000);
		  System.out.println("Sent the reviewed news to the editor is completed");
		  TakeScreenshot(driver, "./exercise/Screenshots/img.png");
		  driver.quit();
		  
		 
		 
		

	}

}
