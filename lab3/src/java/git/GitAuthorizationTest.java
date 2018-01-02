package git;


import framework.ApplicationPropertis;
import framework.BrowserSingleton;
import git.forms.GitAuthorizedPage;
import git.forms.GitHomePage;
import git.forms.GitLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GitAuthorizationTest  {
    public static WebDriver driver;
    public GitHomePage gitHomePage;
    public GitLoginPage gitLoginPage;
    public GitAuthorizedPage gitAuthorizedPage;

    @BeforeClass
    public void setup(){
        driver =  BrowserSingleton.getInstance();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }

    @Parameters({"login","password"})
    @Test
    public void checkAuthorization(String login, String password) throws InterruptedException {
        driver.navigate().to(ApplicationPropertis.getTestProperty("url"));
        gitHomePage = new GitHomePage();
        gitHomePage.pressSignIn();
        gitLoginPage = new GitLoginPage();
        gitLoginPage.loginSite(login,password);
        gitAuthorizedPage = new GitAuthorizedPage();
        Assert.assertTrue(gitAuthorizedPage.isAuthorized());
    }


    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
