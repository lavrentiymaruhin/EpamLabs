package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import org.testng.annotations.Parameters;
import yvr.forms.YvrArrivingFlight;
import yvr.forms.YvrMenuNavigation;

public class YvrArrivingFlightSearch extends BaseTest {
    private String city;
    @Parameters("City")
    public YvrArrivingFlightSearch(String city) {
        this.city = city;
    }

    public void runTest () {
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.goArrivingFlights();
        browser.waitForPageToLoad();
        YvrArrivingFlight yaf = new YvrArrivingFlight();
        yaf.assertPageName();
        yaf.inputSearchTbx(city);
        yaf.buttonSearchClick();
        yaf.assertSearch(city);

    }
}
