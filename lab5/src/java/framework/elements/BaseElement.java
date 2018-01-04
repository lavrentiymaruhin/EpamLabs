package framework.elements;

import framework.BaseEntity;
import framework.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BaseElement extends BaseEntity {

    private static final String LINK = "link=";
    private static final String ID = "id=";
    private static final String CSS = "css=";
    private static final int TIMEOUT_WAIT_0 = 0;

    protected String name;
    protected By locator;
    protected WebElement element;
    protected Select select;

    public WebElement getElement() {
        waitForIsElementPresent();
        return element;
    }

    public void setElement(final WebElement elementToSet) {
        element = elementToSet;
    }

    protected BaseElement(final By loc) {
        locator = loc;
    }

    protected BaseElement(final By loc, final String nameOf) {
        locator = loc;
        name = nameOf;
    }

    protected BaseElement(String stringLocator, final String nameOfElement) {
        String clearLoc = null;
        if (stringLocator.contains(CSS)) {
            clearLoc = stringLocator.replaceFirst(CSS, "");
            locator = By.cssSelector(clearLoc);
            name = nameOfElement;
        } else if (stringLocator.contains(ID)) {
            clearLoc = stringLocator.replaceFirst(ID, "");
            locator = By.id(clearLoc);
            name = nameOfElement;
        } else if (stringLocator.contains(LINK)) {
            clearLoc = stringLocator.replaceFirst(LINK, "");
            locator = By.linkText(clearLoc);
            name = nameOfElement;
        }
    }

    public By getLocator() {
        return locator;
    }



    protected abstract String getElementType();

    public void sendKeys(Keys key) {
        waitForIsElementPresent();
        browser.getDriver().findElement(locator).sendKeys(key);
    }


    public void waitForIsElementPresent() {

        isPresent(Integer.valueOf(browser.getTimeoutForCondition()));
        if (!element.isDisplayed()) {
            performTroubleShooting();
        }
        Assert.assertTrue(element.isDisplayed());
    }

    private void performTroubleShooting(){
        int length = decrementLocator(locator).toString().length();
        try {

            for (int i = 0; i < length; i++) {
                decrementLocator(locator);
                Boolean result = isPresent(TIMEOUT_WAIT_0);
                if (result) {
                    break;
                }
            }
        } catch (Exception e) {

        }
    }


    private By decrementLocator(By locator){
        for (Field field : locator.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                String strLocator = (String)field.get(locator);
                field.set(locator,strLocator.substring(0, strLocator.length()-1));
            } catch (IllegalArgumentException e) {

            } catch (IllegalAccessException e) {

            }
        }
        return locator;
    }


    public void moveToElement(){
        waitForIsElementPresent();
        Actions action = new Actions( browser.getDriver());
        action.moveToElement(element).build().perform();

    }

    public void click() {
        waitForIsElementPresent();
        Actions action = new Actions( browser.getDriver());
        action.moveToElement(element);
        if (browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor)browser.getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
        }
        element.click();
    };

    public void selectByValue(String value){
        waitForIsElementPresent();
        select = new Select(element);
        select.selectByValue(value);
    }

    public void selectByText(String text){
        waitForIsElementPresent();
        select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByIndex(int index){
        waitForIsElementPresent();
        select = new Select(element);
        select.selectByIndex(index);
    }


    public String getText() {
        waitForIsElementPresent();
        return element.getText();
    }



    protected String id;

    public boolean isPresent() {

        return isPresent(TIMEOUT_WAIT_0);
    }

    public boolean isPresent(int timeout) {

        WebDriverWait wait = new WebDriverWait(Browser.getInstance().getDriver(), timeout);
        browser.getDriver().manage().timeouts().implicitlyWait(TIMEOUT_WAIT_0, TimeUnit.SECONDS);
        try {
            wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
                public Boolean apply(final WebDriver driver) {
                    try {
                        List<WebElement> list = driver.findElements(locator);
                        for (WebElement el : list) {
                            if (el instanceof WebElement && el.isDisplayed()) {
                                element = (WebElement) el;
                                return element.isDisplayed();
                            }
                        }
                        element = (WebElement) driver.findElement(locator);
                    } catch (Exception e) {
                        return false;
                    }
                    return element.isDisplayed();
                }
            });
        } catch (Exception e) {
            return false;
        }
        try {
            browser.getDriver().manage().timeouts().implicitlyWait(Integer.valueOf(browser.getTimeoutForCondition()), TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (Exception e) {
        }
        return false;
    }

}
