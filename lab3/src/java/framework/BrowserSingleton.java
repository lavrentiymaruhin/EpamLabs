package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BrowserSingleton{

        private static volatile WebDriver instance;

        public static WebDriver getInstance() {
            WebDriver localInstance = instance;
            if (localInstance == null) {
                synchronized (BrowserSingleton.class) {
                    localInstance = instance;
                    if (localInstance == null) {
                        switch (ApplicationPropertis.getTestProperty("browser")){
                            case "chrome":
                                if(System.getProperty("os.name" ).equals("Linux")){
                                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ApplicationPropertis.getTestProperty("driverFolder")+"chromedriver");
                                }
                                else{
                                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ApplicationPropertis.getTestProperty("driverFolder")+"chromedriver.exe");
                                }
                                instance = localInstance = new ChromeDriver();
                                break;
                            case "firefox":
                                if(System.getProperty("os.name" ).equals("Linux")){
                                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ApplicationPropertis.getTestProperty("driverFolder")+"geckodriver");
                                }
                                else{
                                    System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ ApplicationPropertis.getTestProperty("driverFolder")+"geckodriver.exe");
                                }
                                instance = localInstance = new FirefoxDriver();
                                break;
                        }

                    }
                }
            }
            return localInstance;
        }

}
