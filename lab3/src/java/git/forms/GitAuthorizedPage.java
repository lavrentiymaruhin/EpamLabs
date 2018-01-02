package git.forms;

import framework.BrowserSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class GitAuthorizedPage {
    public WebDriver driver = BrowserSingleton.getInstance();

   public boolean isAuthorized(){
       boolean present;
       try {
           driver.findElement(By.id("user-links"));
           present = true;
       } catch (NoSuchElementException e) {
           present = false;
       }

       return present;
   }
}
