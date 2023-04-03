package testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class FacebookTest {
  public static void main(String[] args) {

    //Set the path to the chromedriver executable file
    System.setProperty("webdriver.chrome.driver","C:/Users/sonu/Downloads/chromedriver_win32/chromedriver.exe");

    //Create a new instance of the Chrome driver
    WebDriver driver = new ChromeDriver();

    //Navigate to Facebook.com
    driver.get("https://www.facebook.com/");

    //Verify that the page title is correct
    String expectedTitle = "Facebook - Log In or Sign Up";
    String actualTitle = driver.getTitle();
    Assert.assertEquals(expectedTitle, actualTitle);

    //Enter email and password and click login button
    WebElement email = driver.findElement(By.id("email"));
    WebElement password = driver.findElement(By.id("pass"));
    WebElement loginButton = driver.findElement(By.id("loginbutton"));

    email.sendKeys("udaykiran6747@gmail.com");
    password.sendKeys("***************");
    loginButton.click();

    //Verify that login was successful by checking for the presence of the user's name on the page
    WebElement userName = driver.findElement(By.xpath("//span[contains(@class, 'fwb')]"));
    Assert.assertEquals("udaykiran", userName.getText());

    //Close the browser
    driver.quit();
  }
}