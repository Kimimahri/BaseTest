package pages;

import helpers.Helper;
import helpers.Waiter;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Класс pageObject страницы Google
 */
public class GooglePage {
    private WebDriver driver;
    private Integer timeout;

    private By inputField = By.id("lst-ib");

    /**
     * Конструктор класса
     *
     * @param driver  - вебдрайвер
     * @param timeout - время ожидания
     */
    public GooglePage(WebDriver driver, Integer timeout) {
        this.driver = driver;
        this.timeout = timeout;
    }

    /**
     * Метод вставки текста в поисковое поле из буфера обмена
     */
    public void pasteTextIntoInputFieldFromClipboard() {
        WebElement element = driver.findElement(inputField);
        Helper.focusToElement(driver, element, timeout);
        element.sendKeys(Keys.CONTROL + "v");
    }

    /**
     * Метод получения текста из поискового поля
     *
     * @return Возвращает значение поискового поля
     */
    public String getInputFieldText() {
        WebElement element = driver.findElement(inputField);
        return Waiter.waitUntilElementVisible(driver, element, timeout).getAttribute("value");
    }
}
