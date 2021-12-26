package co.com.sofka.page.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CommonActionOnpages extends BaseSikulix{
    private WebDriver driver;
    private WebDriverWait ewait;

    public CommonActionOnpages (WebDriver driver) {
        this.driver = driver;
        explicitWait();
    }

    // funciones

    protected void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    protected void clearText(By locator){
        driver.findElement(locator).clear();
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }

    protected void pathFile(By locator, String path){
        driver.findElement(locator).sendKeys(path);
    }

    protected void pressEnter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    protected  String getText (By locator){
        return driver.findElement(locator).getText();
    }

    protected void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    protected void scrollUp(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-200)");
    }

    protected void typeInto(WebElement webElement, String value){
        webElement.sendKeys(value);
    }

    protected void clearText(WebElement webElement){
        webElement.clear();
    }

    protected void click(WebElement webElement){
                webElement.click();

    }

    protected void ewaitClick(WebElement webElement){
        ewaitGeneral(webElement);
        webElement.click();

    }

    protected void pathFile(WebElement webElement, String path){
        webElement.sendKeys(path);
    }

    protected void pressEnter(WebElement webElement) {
        webElement.sendKeys(Keys.ENTER);
    }

    public void scrollTo(WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    protected  String getText (WebElement webElement){
        return webElement.getText();
    }

    protected void explicitWait (){
        ewait = new WebDriverWait(driver,10);
        }

    protected void ewaitGeneral(WebElement webElement){
        ewait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

}

