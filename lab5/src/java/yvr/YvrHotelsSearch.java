package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import yvr.forms.YvrMenuNavigation;
import yvr.forms.YvrShopDineServices;

public class YvrHotelsSearch extends BaseTest {
    public void runTest () throws InterruptedException {
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.buttonShopDineServicesFlightsClick();
        YvrShopDineServices ysds = new YvrShopDineServices();
        ysds.buttonServicesClick();
        ysds.selectItemText("Hotels & Conference Facilities");
        ysds.buttonSearchClick();
        Thread.sleep(5000);
    }
}
