package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import yvr.forms.YvrDepartingFlights;
import yvr.forms.YvrMenuNavigation;

public class YvrDepartingFlightsActual extends BaseTest {
    public void runTest () {
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.goDepartingFlights();
        browser.waitForPageToLoad();
        YvrDepartingFlights ydf = new YvrDepartingFlights();
        ydf.assertPageName();
    }
}
