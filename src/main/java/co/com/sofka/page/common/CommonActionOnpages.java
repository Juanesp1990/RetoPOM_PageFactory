package co.com.sofka.page.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static co.com.sofka.util.LimitTimeWait.TEN_SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CommonActionOnpages extends BaseSikulix {
    private final WebDriver driver;
    private WebDriverWait typeWait;

    /*Constructor*/

    public CommonActionOnpages (WebDriver driver) {
        this.driver = driver;
        explicitWaitInit();
    }

    /*General functions*/

    protected void explicitWaitInit () {
        typeWait = new WebDriverWait(driver, TEN_SECONDS.getValue());
    }

    protected void waitGeneral (WebElement webElement) {
        typeWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void scrollDown () {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    protected void scrollUp () {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-200)");
    }

    /* functions for element type By*/

    protected void clearText (By locator) {
        driver.findElement(locator).clear();
    }

    protected void typeInto (By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    protected void click (By locator) {
        typeWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void pathFile (By locator, String path) {
        driver.findElement(locator).sendKeys(path);
    }

    protected void pressEnter (By locator) {
        typeWait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Keys.ENTER);
    }

    protected void pressTab (By locator) {
        typeWait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Keys.TAB);
    }

    protected void arrowDowm (By locator) {
        typeWait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(Keys.ARROW_DOWN);
    }

    public void scrollTo (By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    protected String getText (By locator) {
        return driver.findElement(locator).getText();
    }

    /* functions for web element*/

    protected void clearText (WebElement webElement) {
        typeWait.until(elementToBeClickable(webElement)).clear();
    }

    protected void typeInto (WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    protected void click (WebElement webElement) {
        typeWait.until(elementToBeClickable(webElement)).click();

    }

    protected void pathFile (WebElement webElement, String path) {
        webElement.sendKeys(path);
    }

    protected void pressEnter (WebElement webElement) {
        typeWait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(Keys.ENTER);
    }

    public void scrollTo (WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    protected String getText (WebElement webElement) {
        return  webElement.getText();
    }

    protected boolean getStatusElement (WebElement webElement) {
        return webElement.isDisplayed();
    }


}

