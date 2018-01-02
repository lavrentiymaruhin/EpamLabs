package git.forms;

import framework.ApplicationPropertis;
import framework.BrowserSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GitLoginPage {

    public WebDriver driver = BrowserSingleton.getInstance();
    By usernameLocator = By.id("login_field");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.xpath("//input[@value='Sign in']");

    public void loginSite(String login,String password){
        inputLogin(login);
        inputPassword(password);
        clickLoginButton();
    }
    public void inputLogin(String login) {

        WebElement explicitWait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(usernameLocator));

        explicitWait.sendKeys(login);
    }

    public void inputPassword(String password) {
        WebElement explicitWait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(passwordLocator));
        explicitWait.sendKeys(password);
    }

    public void clickLoginButton(){
        WebElement explicitWait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(loginButtonLocator));
        explicitWait.click();
    }
}
