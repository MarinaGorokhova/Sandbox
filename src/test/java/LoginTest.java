import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest {

    @Test
    public void checkLogin() throws InterruptedException {
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("12345");
        Thread.sleep(2000);
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys(Keys.CONTROL + "A");
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys(Keys.BACK_SPACE);
        browser.findElement(By.cssSelector("*[value='Continue']")).click();
        browser.quit();
    }

    @Test
    public void checkErrorLogin() {
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.cssSelector("input[name='zip_code']")).sendKeys("12");
        browser.findElement(By.cssSelector("*[value='Continue']")).click();
        String errorMsg = browser.findElement(By.cssSelector(".error_message")).getText();
        assertEquals(errorMsg, "Oops, error on page. ZIP code should 5 digits");
        browser.quit();
    }

    @Test
    public void checkSignUp() {
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("12345");
        browser.findElement(By.cssSelector("*[value='Continue']")).click();
        browser.findElement(By.xpath("//*[text()='Sign Up']")).isDisplayed();
        browser.quit();
    }
}
