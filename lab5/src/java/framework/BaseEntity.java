package framework;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.testng.AssertJUnit.assertTrue;

public abstract class BaseEntity {
    protected static Browser browser = Browser.getInstance();
    protected static int screenIndex = 0;
    protected ITestContext context;



    protected void fatal() {

        assertTrue(false);
    }

    public void doAssert(final Boolean isTrue, final String passMsg) {
        if (isTrue) {

        } else {
            fatal();
        }
    }

    public void assertEquals(final Object expected, final Object actual) {
        if (!expected.equals(actual)) {
            fatal();
        }
    }

    @BeforeClass
    public void before(ITestContext context) {
        this.context = context;
        browser = Browser.getInstance();
        browser.windowMaximise();
    }

    @AfterClass
    public void after() {

        if (browser.isBrowserAlive()) {
            browser.exit();
        }
    }

}
