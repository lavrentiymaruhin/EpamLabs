package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import yvr.forms.YvrMenuNavigation;
import yvr.forms.YvrShopDineServices;

public class YvrCurrencyExchange extends BaseTest {
    public void runTest () {
        browser.navigate("http://www.yvr.ca/en/passengers");browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.buttonShopDineServicesFlightsClick();
        YvrShopDineServices ysds = new YvrShopDineServices();

    }
}
