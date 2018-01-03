package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class TextBox extends BaseElement  {

    public TextBox(final By locator, final String name) {
        super(locator, name);
    }

    public TextBox(final String string, final String name) {
        super(string, name);
    }

    protected String getElementType() {
        return "TextBox";
    }

    public TextBox(final By locator) {
        super(locator);
    }

    public void type(final String value) {
        waitForIsElementPresent();
        if (browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor)browser.getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
        }
        element.sendKeys(value);
    }


    public void setText(final String value) {
        waitForIsElementPresent();
        element.clear();
        type(value);
    }

    public String getValue() {
        waitForIsElementPresent();
        return element.getAttribute("value");
    }

}
