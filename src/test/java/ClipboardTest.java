import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.GooglePage;
import pages.MainPage;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class ClipboardTest {
    private WebDriver driver;

    @BeforeTest
    @Parameters({"url", "timeout", "driverPath"})
    public void setUp(String url, int timeout, String driverPath) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Parameters({"str", "url2"})
    @Test
    private void clipboardTest(String str, String url2) throws IOException, UnsupportedFlavorException {
        MainPage mainPage = new MainPage(driver);
        GooglePage googlePage = new GooglePage(driver);

        Assert.assertEquals(mainPage.getClipboard(), mainPage.getTextOfInput());
        driver.get(url2);
        googlePage.pasteText(str);
        Assert.assertEquals(googlePage.getPastedText(), str);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}