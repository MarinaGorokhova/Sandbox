import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void checkLogin() throws InterruptedException {
        loginPage.open();
        loginPage.loginThruZip("12345");
    }

    @Test
    public void checkErrorLogin() {
        loginPage.open();
        loginPage.loginThruZip("12");
        String errorMsg = browser.findElement(By.cssSelector(".error_message")).getText();
        assertEquals(errorMsg, "Oops, error on page. ZIP code should 5 digits");
    }

    @Test
    public void checkSignUp() {
        loginPage.open();
        loginPage.loginThruZip("12345");
        boolean isPresent = browser.findElement(By.xpath("//*[text()='Sign Up']")).isDisplayed();
        assertTrue(isPresent);
    }
}
