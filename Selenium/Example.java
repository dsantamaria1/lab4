import java.util.ArrayList;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Example extends TestCase  {

    public void testValidLogin(){
        WebDriver driver = new HtmlUnitDriver();
  	//get the website
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        
     	// Find the text user name and password elements by their name
        WebElement userName = driver.findElement(By.name("userId"));
        WebElement password = driver.findElement(By.name("userPassword"));
 
       //clear elements
	userName.clear();
	password.clear();

 	userName.sendKeys("andy");
	password.sendKeys("apple");
        
	// Now submit the form. WebDriver will find the form for us from the element
        password.submit();

        // Check the title of the page
        assertEquals("Online temperature conversion calculator", driver.getTitle());

        driver.quit();
    }
   

    public void testInvalidLogin(){

	ArrayList<String> testUserNames = new ArrayList<String>();
	ArrayList<String> testPassWords = new ArrayList<String>();

	testUserNames.add("bob");
	testUserNames.add("bobby");
	testUserNames.add("bo b");
	testUserNames.add("bob");

  	testPassWords.add("bath");
  	testPassWords.add("bathtub");
  	testPassWords.add("bathtub");
  	testPassWords.add("bath tub");

        WebDriver driver = new HtmlUnitDriver();
  	//get the website
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        
     	// Find the text user name and password elements by their name
        WebElement userName;
        WebElement password;
 
       //clear elements
        for(int i = 0; i < testUserNames.size(); i++){
          System.out.println("iteration is " + i);   
  	  //get the website
          driver.get("http://apt-public.appspot.com/testing-lab-login.html");
          if(i == 0){
            userName = driver.findElement(By.name("userId"));
            password = driver.findElement(By.name("userPassword"));
          }
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
    public void testUserNameCaseSensitive(){} 
    public void testPassWordCaseSensitive(){}




    public static void main(String[] args) {
        String[] testCaseName = { Example.class.getName() };
        junit.textui.TestRunner.main(testCaseName);

//        // Create a new instance of the html unit driver
//        // Notice that the remainder of the code relies on the interface, 
//        // not the implementation.
//        WebDriver driver = new HtmlUnitDriver();
//
//        // And now use this to visit Google
//        driver.get("http://www.google.com");
//
//        // Find the text input element by its name
//        WebElement element = driver.findElement(By.name("q"));
//
//        // Enter something to search for
//        element.sendKeys("Cheese!");
//
//        // Now submit the form. WebDriver will find the form for us from the element
//        element.submit();
//
//        // Check the title of the page
//        System.out.println("Page title is: " + driver.getTitle());
//
//        driver.quit();
    }
}
