import java.util.ArrayList;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Example extends TestCase  {

    public void testInvalidLogin(){

	ArrayList<String> testUserNames = new ArrayList<String>();
	ArrayList<String> testPassWords = new ArrayList<String>();

	testUserNames.add("bob");
	testUserNames.add("bobby");
	testUserNames.add("bo b");
	testUserNames.add("bob");

  	testPassWords.add("Bathtub");
  	testPassWords.add("bath");
  	testPassWords.add("bathtub");
  	testPassWords.add("bath tub");

        WebDriver driver = new HtmlUnitDriver();
  	//get the website
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        
     	// Find the text user name and password elements by their name
        WebElement userName;
        WebElement password;
 
        //for(int i = 0; i < testUserNames.size(); i++){
        for(int i = 0; i < 1; i++){
          //System.out.println("iteration is " + i);   
  	  //get the website
          driver.get("http://apt-public.appspot.com/testing-lab-login.html");
          userName = driver.findElement(By.name("userId"));
          password = driver.findElement(By.name("userPassword"));
          
          //clear elements
	  userName.clear();
	  password.clear();

 	  userName.sendKeys(testUserNames.get(0));
	  password.sendKeys(testPassWords.get(0));
          
	  // Now submit the form. WebDriver will find the form for us from the element
          password.submit();

          // Check the title of the page
          assertEquals("Bad Login", driver.getTitle());

          driver.close();
       }
    }


    //focus on one user profile
    public void testUserNameCaseSensitive(){
        WebDriver driver = new HtmlUnitDriver();
  	//get the website
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        
     	// Find the text user name and password elements by their name
        WebElement userName = driver.findElement(By.name("userId"));
        WebElement password = driver.findElement(By.name("userPassword"));
 
        //clear elements
	userName.clear();
	password.clear();

 	userName.sendKeys(" CharLey");
	password.sendKeys(" china ");
        
	// Now submit the form. WebDriver will find the form for us from the element
        password.submit();

        // Check the title of the page
        assertEquals("Online temperature conversion calculator", driver.getTitle());

//// checking farenheit 0
	WebElement tempInput = driver.findElement(By.name("farenheitTemperature"));
	tempInput.clear();
	tempInput.sendKeys("0.00");
	
	tempInput.submit();
	WebElement tempResult = driver.findElement(By.tagName("h2"));
        assertEquals("0.00 Farenheit = -17.78 Celsius", tempResult.getText());
	
//// checking farenheit 212
	driver.get("http://apt-public.appspot.com/testing-lab-calculator.html");
	WebElement tempInput2 = driver.findElement(By.name("farenheitTemperature"));
	tempInput2.clear();
	tempInput2.sendKeys("212.00");
	
	tempInput2.submit();
	WebElement tempResult2 = driver.findElement(By.tagName("h2"));
        assertEquals("212.00 Farenheit = 100 Celsius", tempResult2.getText());


	driver.get("http://apt-public.appspot.com/testing-lab-calculator.html");
	WebElement tempInput3 = driver.findElement(By.name("farenheitTemperature"));
	tempInput3.clear();
	tempInput3.sendKeys("212.25");
	
	tempInput3.submit();
	WebElement tempResult3 = driver.findElement(By.tagName("h2"));
        assertEquals("212.25 Farenheit = 100.1 Celsius", tempResult3.getText());

        driver.quit();
    }
 
    public void testLockout(){
        WebDriver driver = new HtmlUnitDriver();
        //get the website
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");

        // Find the text user name and password elements by their name

          //get the website
          driver.get("http://apt-public.appspot.com/testing-lab-login.html");
          WebElement userName = driver.findElement(By.name("userId"));
          WebElement password = driver.findElement(By.name("userPassword"));

          //clear elements
          userName.clear();
          password.clear();
          userName.sendKeys("aandy");
          password.sendKeys("apple");
          password.submit();
          assertEquals("Bad Login", driver.getTitle());	
          
          driver.get("http://apt-public.appspot.com/testing-lab-login.html");
	  userName = driver.findElement(By.name("userId"));
          password = driver.findElement(By.name("userPassword"));
	  userName.clear();
          password.clear();
          userName.sendKeys("andy");
          password.sendKeys("aapple");
          password.submit();
          assertEquals("Bad Login", driver.getTitle());	
          
	  driver.get("http://apt-public.appspot.com/testing-lab-login.html");
	  userName = driver.findElement(By.name("userId"));
          password = driver.findElement(By.name("userPassword"));
	  userName.clear();
          password.clear();
          userName.sendKeys("andy");
          password.sendKeys("Apple");
          password.submit();
          assertEquals("Frequent Login", driver.getTitle());	
    }

    public void testParameters(){
	
    }

    public static void main(String[] args) {
        String[] testCaseName = { Example.class.getName() };
        junit.textui.TestRunner.main(testCaseName);
    }
}
