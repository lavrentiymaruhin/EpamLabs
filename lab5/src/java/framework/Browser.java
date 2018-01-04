package framework;

import com.google.common.base.Strings;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.NamingException;
import java.util.concurrent.TimeUnit;

public final class Browser {
    private static final long IMPLICITY_WAIT = 10;
    private static final String DEFAULT_CONDITION_TIMEOUT = "defaultConditionTimeout";
    private static final String DEFAULT_PAGE_LOAD_TIMEOUT = "defaultPageLoadTimeout";

    private static Browser instance;
    private static WebDriver driver;

    private static String timeoutForPageLoad;
    private static String timeoutForCondition;



    public static Browsers currentBrowser;

    public String getLocation() {
        return driver.getCurrentUrl();
    }

    public void click(final By selector) {
        new Label(selector).click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void navigate(final String url) {
        driver.navigate().to(url);
    }

    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(getTimeoutForPageLoad()));

        try {
            wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
                public Boolean apply(final WebDriver d) {
                    if (!(d instanceof JavascriptExecutor)) {
                        return true;
                    }
                    Object result = ((JavascriptExecutor) d)
                            .executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
                    if (result != null && result instanceof Boolean && (Boolean) result) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {

        }
    }

    public void switchToFrame(By frame){

        WebElement we = driver.findElement(frame);
        driver.switchTo().frame(we);
    }

    public void windowMaximise() {
        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
        }

    }

    public static Browser getInstance() {
        if (instance == null) {
            initProperties();
            try {
                driver = BrowserFactory.setUp(ApplicationPropertis.getTestProperty("browser"));
                driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
            } catch (NamingException e) {
                e.printStackTrace();
            }
            instance = new Browser();
        }
        return instance;
    }

    private static void initProperties() {

        timeoutForPageLoad = ApplicationPropertis.getTestProperty(DEFAULT_PAGE_LOAD_TIMEOUT);
        timeoutForCondition = ApplicationPropertis.getTestProperty(DEFAULT_CONDITION_TIMEOUT);
    }

    public String getTimeoutForPageLoad() {
        return timeoutForPageLoad;
    }

    public String getTimeoutForCondition() {
        return timeoutForCondition;
    }

    public void exit() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance = null;
        }
    }

    public boolean isBrowserAlive() {
        return instance != null;
    }
}

enum Browsers {

    FIREFOX("firefox"),

    CHROME("chrome");

    public String value;

    Browsers(final String values) {
        value = values;
    }

    public String toString() {
        return value;
    }
}