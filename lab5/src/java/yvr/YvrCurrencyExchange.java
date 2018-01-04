package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import org.testng.annotations.Parameters;
import yvr.forms.YvrMenuNavigation;
import yvr.forms.YvrShopDineServices;

public class YvrCurrencyExchange extends BaseTest {
    private String bank;
    @Parameters({"SelectCategoryBank"})
    public YvrCurrencyExchange(String bank) {
        this.bank = bank;
    }

    public void runTest () {
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.buttonShopDineServicesFlightsClick();
        browser.waitForPageToLoad();
        YvrShopDineServices ysds = new YvrShopDineServices();
        ysds.buttonServicesClick();
        ysds.selectItemText(bank);
        ysds.buttonOpenNowClick();
        ysds.buttonSecurityAfterClick();
        ysds.buttonSearchClick();
        ysds.assertCurrencySearch(bank);
    }
}
