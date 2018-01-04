package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import org.testng.annotations.Parameters;
import yvr.forms.YvrDepartingFlights;
import yvr.forms.YvrMenuNavigation;

public class YvrDepartingFlightsSearch extends BaseTest {
    private String flightsNumber;
    @Parameters({"Flight"})
    public YvrDepartingFlightsSearch(String flightsNumber) {
        this.flightsNumber = flightsNumber;
    }

    public void runTest () throws InterruptedException {
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.goDepartingFlights();
        YvrDepartingFlights ydf = new YvrDepartingFlights();
        ydf.assertPageName();
        ydf.inputSearchTbx(flightsNumber);
        ydf.buttonSearchClick();
        ydf.assertWarningMessage();
    }
}
