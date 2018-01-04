package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import yvr.forms.YvrArrivingFlight;
import yvr.forms.YvrMenuNavigation;

public class YvrArrivingFlightSearch extends BaseTest {
    public void runTest () throws InterruptedException {
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.goArrivingFlights();
        YvrArrivingFlight yaf = new YvrArrivingFlight();
        yaf.assertPageName();
        yaf.inputSearchTbx("Los Angeles");
        yaf.buttonSearchClick();
Thread.sleep(5000);
    }
}
