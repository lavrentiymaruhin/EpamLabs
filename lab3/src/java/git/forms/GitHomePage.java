package git.forms;


import framework.ApplicationPropertis;
import framework.BrowserSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GitHomePage {

    public WebDriver driver = BrowserSingleton.getInstance();
    By signInButtonLocator = By.xpath("//a[text()='Sign in']");


    public void pressSignIn() {

        WebElement explicitWait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(signInButtonLocator));

        explicitWait.click();
    }


}