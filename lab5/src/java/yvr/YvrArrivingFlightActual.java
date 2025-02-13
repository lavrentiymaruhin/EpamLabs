package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import yvr.forms.YvrArrivingFlight;
import yvr.forms.YvrMenuNavigation;

public class YvrArrivingFlightActual extends BaseTest {
    public void runTest () throws InterruptedException {
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.goArrivingFlights();
        browser.waitForPageToLoad();
        YvrArrivingFlight yaf = new YvrArrivingFlight();
        yaf.assertPageName();
    }
}
