package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;


public class GooglePage {
    private By inputField = By.id("lst-ib");
    private WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void pasteText(String str) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(inputField);
        StringSelection stringSelection = new StringSelection(str);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        jsExecutor.executeScript("arguments[0].focus()", element);
        element.sendKeys(Keys.CONTROL + "v");
    }

    public String getPastedText() {
        return driver.findElement(inputField).getAttribute("value");
    }
}