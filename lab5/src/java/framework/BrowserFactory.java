package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import javax.naming.NamingException;


public abstract class BrowserFactory {

    public static WebDriver setUp(final Browsers type) {

        WebDriver driver = null;

        switch (type) {
            case CHROME:
                if(System.getProperty("os.name" ).equals("Linux")){
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ApplicationPropertis.getTestProperty("driverFolder")+"chromedriver");
                }
                else{
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ApplicationPropertis.getTestProperty("driverFolder")+"chromedriver.exe");
                }
                driver = new ChromeDriver();
                break;

            case FIREFOX:
                if(System.getProperty("os.name" ).equals("Linux")){
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ApplicationPropertis.getTestProperty("driverFolder")+"geckodriver");
                }
                else{
                    System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ ApplicationPropertis.getTestProperty("driverFolder")+"geckodriver.exe");
                }
                driver = new FirefoxDriver();
                break;

            default:
                break;
        }
        return driver;
    }

    public static WebDriver setUp(final String type) throws NamingException {
        for (Browsers t : Browsers.values()) {
            if (t.toString().equalsIgnoreCase(type)) {
                return setUp(t);
            }
        }
        return null;
    }
}
