package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import yvr.forms.YvrFlightSchedules;
import yvr.forms.YvrMenuNavigation;

public class YvrFlightSchedulesSearch extends BaseTest {
    public void runTest () throws InterruptedException {
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.goFlightSchedules();
        Browser.getInstance().switchToFrame(By.id("ifrViewport"));
        YvrFlightSchedules yfs = new YvrFlightSchedules();
        yfs.goSearchFlights("sAS");
        yfs.assertWarningMessage();
    }
}
