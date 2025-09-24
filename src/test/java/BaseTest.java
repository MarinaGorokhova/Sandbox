import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public  WebDriver browser;
    LoginPage loginPage;

    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        browser = new ChromeDriver(options);
        browser.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        loginPage = new LoginPage(browser);
    }

    @AfterTest
    public void close(){
        browser.quit();
    }
}
