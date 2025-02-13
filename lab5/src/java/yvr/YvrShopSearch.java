package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import org.testng.annotations.Parameters;
import yvr.forms.YvrArrivingFlight;
import yvr.forms.YvrMenuNavigation;
import yvr.forms.YvrShopDineServices;

public class YvrShopSearch extends BaseTest {

    private String searchText;

    @Parameters({"SearchShopName"})
    public YvrShopSearch(String searchText) {
        this.searchText = searchText;
    }

    public void runTest (){
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.buttonShopDineServicesFlightsClick();
        browser.waitForPageToLoad();
        YvrShopDineServices ysds = new YvrShopDineServices();
        ysds.buttonShopClick();
        ysds.buttonTerminalCanadaClick();
        ysds.inputSearch(searchText);
        ysds.buttonSecurityBeforeClick();
        ysds.buttonSearchClick();
        ysds.assertShopSearch(searchText);
    }
}
