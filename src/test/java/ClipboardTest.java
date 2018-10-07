import helpers.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.GooglePage;
import pages.ClipboardPage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Тест-сьют для проверки буфера обмена
 */
public class ClipboardTest {
    private WebDriver driver;

    /**
     * Подготовка и установка параметров вебрдайвера
     *
     * @param timeout    - время ожидания
     * @param driverPath - путь до chromedriver.exe
     */
    @BeforeMethod
    @Parameters({"timeout", "driverPath"})
    public void setUp(int timeout, String driverPath) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    /**
     * Тест проверки копирования текста в буфер обмена
     *
     * @param clipboardPageUrl - адрес страницы
     * @param timeout          - время ожидания
     */
    @Parameters({"clipboardPageUrl", "timeout"})
    @Test
    private void copyToClipboardTest(String clipboardPageUrl, Integer timeout) throws IOException, UnsupportedFlavorException {
        ClipboardPage clipboardPage = new ClipboardPage(driver, timeout);

        driver.get(clipboardPageUrl);
        clipboardPage.copyTextToClipboard();
        Assert.assertEquals(Helper.getClipboardText(), clipboardPage.getInputFooText());
    }

    /**
     * Тест проверки вставки текста из буфера обмена
     *
     * @param text          - текст для вставки
     * @param googlePageUrl - адрес страницы
     * @param timeout       - время ожидания
     */
    @Parameters({"text", "googlePageUrl", "timeout"})
    @Test
    private void pasteFromClipboardTest(String text, String googlePageUrl, Integer timeout) throws IOException, UnsupportedFlavorException {
        GooglePage googlePage = new GooglePage(driver, timeout);

        driver.get(googlePageUrl);
        Helper.inputTextIntoClipboard(text);
        googlePage.pasteTextIntoInputFieldFromClipboard();
        Assert.assertEquals(googlePage.getInputFieldText(), text);
    }

    /**
     * Метод закрытия браузера
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
