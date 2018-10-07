package pages;

import helpers.Helper;

import helpers.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Класс pageObject страницы Clipboard
 */
public class ClipboardPage {
    private WebDriver driver;
    private Integer timeout;
    private By buttonCopyClipboard = By.xpath("//div[@id='example-target']//button");
    private By inputFoo = By.id("foo");

    /**
     * Конструктор класса
     *
     * @param driver  - вебдрайвер
     * @param timeout - время ожидания
     */
    public ClipboardPage(WebDriver driver, Integer timeout) {
        this.driver = driver;
        this.timeout = timeout;
    }

    /**
     * Метод копирования текста в буфер обмена через кнопку buttonCopyClipboard
     */
    public void copyTextToClipboard() throws IOException, UnsupportedFlavorException {
        WebElement element = driver.findElement(buttonCopyClipboard);
        Helper.scrollToElement(driver, element, timeout);
        element.click();
    }

    /**
     * Метод получения значения поля inputFoo
     *
     * @return Возвращает значение поля inputFoo
     */
    public String getInputFooText() {
        WebElement element = driver.findElement(inputFoo);
        return Waiter.waitUntilElementClickable(driver, element, timeout).getAttribute("value");
    }
}
