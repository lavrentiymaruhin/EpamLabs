package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import yvr.forms.YvrFlightSchedules;
import yvr.forms.YvrMenuNavigation;

public class YvrFlightSchedulesSearch extends BaseTest {
    private String airport;
    @Parameters({"Airport"})
    public YvrFlightSchedulesSearch(String airport) {
        this.airport = airport;
    }

    public void runTest () throws InterruptedException {
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.goFlightSchedules();
        Browser.getInstance().switchToFrame("ifrViewport");
        YvrFlightSchedules yfs = new YvrFlightSchedules();
        yfs.goSearchFlights(airport);
        yfs.assertWarningMessage();
    }
}
