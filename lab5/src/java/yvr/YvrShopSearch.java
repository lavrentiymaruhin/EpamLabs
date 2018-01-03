package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import yvr.forms.YvrArrivingFlight;
import yvr.forms.YvrMenuNavigation;
import yvr.forms.YvrShopDineServices;

public class YvrShopSearch extends BaseTest {
    public void runTest () {
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.buttonShopDineServicesFlightsClick();
        YvrShopDineServices ysds = new YvrShopDineServices();
    }
}
