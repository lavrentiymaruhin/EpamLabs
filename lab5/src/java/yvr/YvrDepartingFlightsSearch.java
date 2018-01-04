package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import yvr.forms.YvrDepartingFlights;
import yvr.forms.YvrMenuNavigation;

public class YvrDepartingFlightsSearch extends BaseTest {
    public void runTest () throws InterruptedException {
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.goDepartingFlights();
        YvrDepartingFlights ydf = new YvrDepartingFlights();
        ydf.assertPageName();
        ydf.inputSearchTbx("DL4685");
        ydf.buttonSearchClick();
        ydf.assertWarningMessage();
    }
}
