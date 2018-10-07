package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс ожиданий состояния элементов
 */
public class Waiter {

    /**
     * Метод ожидания видимости элемента
     *
     * @param driver  - вебдрайвер
     * @param element - вебэлемент
     * @param timeout - время ожидания
     * @return Возвращает вебэлемент
     */
    public static WebElement waitUntilElementVisible(WebDriver driver, WebElement element, Integer timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    /**
     * Метод ожидания активности элемента
     *
     * @param driver  - вебдрайвер
     * @param element - вебэлемент
     * @param timeout - время ожидания
     * @return Возвращает вебэлемент
     */
    public static WebElement waitUntilElementClickable(WebDriver driver, WebElement element, Integer timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
