package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import org.testng.annotations.Parameters;
import yvr.forms.YvrMenuNavigation;
import yvr.forms.YvrShopDineServices;

public class YvrHotelsSearch extends BaseTest {
    private String selectItem;

    @Parameters({"SelectCategoryHotels"})
    public YvrHotelsSearch(String selectItem) {
        this.selectItem = selectItem;
    }

    public void runTest (){
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.buttonShopDineServicesFlightsClick();
        YvrShopDineServices ysds = new YvrShopDineServices();
        ysds.buttonServicesClick();
        ysds.selectItemText(selectItem);
        ysds.buttonSearchClick();
        ysds.assertHotelSearch(selectItem);
    }
}
