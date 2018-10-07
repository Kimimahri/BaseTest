package pages;

import helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class MainPage {
    private By buttonCopyClipboard = By.xpath("//div[@id='example-target']//button");
    private By inputFoo = By.id("foo");
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getClipboard() throws IOException, UnsupportedFlavorException {
        Helper.scrollToElement(driver, buttonCopyClipboard);
        driver.findElement(buttonCopyClipboard).click();
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }

    public String getTextOfInput() {
        WebElement element = driver.findElement(inputFoo);
        return element.getAttribute("value");
    }
}
