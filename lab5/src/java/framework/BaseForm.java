package framework;

import framework.elements.Label;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Date;

public class BaseForm {


    protected By titleLocator;
    protected String title;
    protected String name;



    protected BaseForm(final By locator, final String formTitle) {
        init(locator, formTitle);
        assertIsOpen();
    }


    public BaseForm(final String formlocator, final String formTitle) {
        long before = new Date().getTime();
        title = formTitle;
        Label titlePicture = (Label) new Label(formlocator,title);
        try{
            Assert.assertTrue(titlePicture.isPresent());
            long openTime = new Date().getTime() - before;

        } catch (Throwable e) {
        }
    }


    private void init(final By locator, final String formTitle) {
        titleLocator = locator;
        title = formTitle;
        name =  this.title;
    }


    public void assertIsOpen() {
        long before = new Date().getTime();
        Label elem = new Label(titleLocator, title);
        try {
            elem.waitForIsElementPresent();
            long openTime = new Date().getTime() - before;

        } catch (Throwable e) {
        }
    }


}
