package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Вспомогательный класс
 */
public class Helper {

    /**
     * Метод скрола до элемента
     *
     * @param driver  - вебдрайвер
     * @param element - вебелемет
     * @param timeout - время ожидания
     */
    public static void scrollToElement(WebDriver driver, WebElement element, Integer timeout) {
        Waiter.waitUntilElementVisible(driver, element, timeout);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * Метод получения текста из буфера обмена
     *
     * @return Возвращает содержимое буфера обмена
     */
    public static String getClipboardText() throws IOException, UnsupportedFlavorException {
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }

    /**
     * Метод наполнения буфера обмена текстом
     *
     * @param text - текст для наполнения
     */
    public static void inputTextIntoClipboard(String text) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text), null);
    }

    /**
     * Метод фокусировки на элемент
     *
     * @param driver  - вебдрайвер
     * @param element - вебэлемент
     * @param timeout - время ожидания
     */
    public static void focusToElement(WebDriver driver, WebElement element, Integer timeout) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        Waiter.waitUntilElementClickable(driver, element, timeout);
        jsExecutor.executeScript("arguments[0].focus()", element);
    }
}