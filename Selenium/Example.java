import java.util.ArrayList;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


//test all three valid logins (1, 2, 3)
//test user name case insensitive (4)
//test password case sensitivity (5)
//test trailing/leading spaces in username and password (6, 7, 8 ,9)
//test lockout (10)
//test 2 decimal places in result precision for 0 - 212, 1 place of precision for anything else (11, 12, 13)
//test inputs are floating point (14)
//test invalid input (15)
//test parameters valid, invalid, case sensitive (16, 17, 18)
//test invalid login (19)
//test exception

public class Example extends TestCase  {

    //focus on one user profile
    public void testResultAccuracy(){
        WebDriver driver = new HtmlUnitDriver();
  	    //get the website
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        
     	// Find the text user name and password elements by their name
        WebElement userName = driver.findElement(By.name("userId"));
        WebElement password = driver.findElement(By.name("userPassword"));
 
        //clear elements
        userName.clear();
        password.clear();

        userName.sendKeys(" CharLey ");
        password.sendKeys(" china ");
        
        // Now submit the form. WebDriver will find the form for us from the element
        password.submit();

        // Check the title of the page
        assertEquals("Online temperature conversion calculator", driver.getTitle()); //(3) (4) (6) (7) (8) (9)

        // checking farenheit 0
        WebElement tempInput = driver.findElement(By.name("farenheitTemperature"));
        tempInput.clear();
        tempInput.sendKeys("0.00");
	
        tempInput.submit();
        WebElement tempResult = driver.findElement(By.tagName("h2"));
        assertEquals("0.00 Farenheit = -17.78 Celsius", tempResult.getText()); //(11) (13)
	
        // checking farenheit 212
        driver.get("http://apt-public.appspot.com/testing-lab-calculator.html");
        WebElement tempInput2 = driver.findElement(By.name("farenheitTemperature"));
        tempInput2.clear();
        tempInput2.sendKeys("212.00");
	
        tempInput2.submit();
        WebElement tempResult2 = driver.findElement(By.tagName("h2"));
        assertEquals("212.00 Farenheit = 100 Celsius", tempResult2.getText()); //(12)


        driver.get("http://apt-public.appspot.com/testing-lab-calculator.html");
        WebElement tempInput3 = driver.findElement(By.name("farenheitTemperature"));
        tempInput3.clear();
        tempInput3.sendKeys("212.25");
	
        tempInput3.submit();
        WebElement tempResult3 = driver.findElement(By.tagName("h2"));
        assertEquals("212.25 Farenheit = 100.1 Celsius", tempResult3.getText()); // (13)

        driver.quit();
    }
    
 
    public void testLockout(){
        WebDriver driver = new HtmlUnitDriver();

        //get the website
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement userName = driver.findElement(By.name("userId"));
        WebElement password = driver.findElement(By.name("userPassword"));

        //clear elements
        userName.clear();
        password.clear();
        userName.sendKeys(" a andy");
        password.sendKeys("apple");
        password.submit();
        assertEquals("Bad Login", driver.getTitle());	//(17)
          
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        userName = driver.findElement(By.name("userId"));
        password = driver.findElement(By.name("userPassword"));
        userName.clear();
        password.clear();
        userName.sendKeys("andy");
        password.sendKeys(" aapple");
        password.submit();
        assertEquals("Bad Login", driver.getTitle());	//(19)
        
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        userName = driver.findElement(By.name("userId"));
        password = driver.findElement(By.name("userPassword"));
        userName.clear();
        password.clear();
        userName.sendKeys("andy");
        password.sendKeys("Apple");
        password.submit();
        assertEquals("Frequent Login", driver.getTitle()); //(5) //(10)
        
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        userName = driver.findElement(By.name("userId"));
        password = driver.findElement(By.name("userPassword"));
        userName.clear();
        password.clear();
        userName.sendKeys(" andy");
        password.sendKeys(" apple");
        password.submit();
        assertEquals("Frequent Login", driver.getTitle()); //(10)
        
        driver.quit();
    }

    public void testParameters(){
        WebDriver driver = new HtmlUnitDriver();
        
        //get the website
        driver.get("http://apt-public.appspot.com/testing-lab-conversion?farenheitTemperature=100");
        
        WebElement tempResult = driver.findElement(By.tagName("h2"));
        assertEquals("100 Farenheit = 37.78 Celsius", tempResult.getText()); // (16)
        
        driver.get("http://apt-public.appspot.com/testing-lab-conversion?FarenheiTtemPerature=100");
        
        tempResult = driver.findElement(By.tagName("h2"));
        assertEquals("100 Farenheit = 37.78 Celsius", tempResult.getText()); // (18)
        
        driver.quit();
    }
    
    public void testInvalidParameters(){
        WebDriver driver = new HtmlUnitDriver();
        
        //get the website
        driver.get("http://apt-public.appspot.com/testing-lab-conversion?farenheitTemperature=10E3");
        
        WebElement tempResult = driver.findElement(By.tagName("h2"));
        assertEquals("Need to enter a valid temperature!Got a NumberFormatException on 10E3", tempResult.getText()); // (17)
    }
    
    public void testInvalidParameters2(){
        WebDriver driver = new HtmlUnitDriver();
        
        //get the website
        driver.get("http://apt-public.appspot.com/testing-lab-conversion?farenheitTemperature=10xE3");
        
        WebElement tempResult = driver.findElement(By.tagName("h2"));
        assertEquals("Need to enter a valid temperature!Got a NumberFormatException on 10xE3", tempResult.getText()); // (19)
    }

    public static void main(String[] args) {
        String[] testCaseName = { Example.class.getName() };
        junit.textui.TestRunner.main(testCaseName);
    }
}
