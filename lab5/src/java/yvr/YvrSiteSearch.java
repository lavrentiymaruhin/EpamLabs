package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import org.testng.annotations.Parameters;
import yvr.forms.YvrMenuNavigation;
import yvr.forms.YvrSearchSite;

public class YvrSiteSearch extends BaseTest {

    private String searchText;

    @Parameters({"SearchSiteWord"})
    public YvrSiteSearch(String airport) {
        this.searchText = searchText;
    }

    public void runTest () {
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.goSearch(searchText);
        YvrSearchSite yss = new YvrSearchSite();
        yss.assertSearchResult(searchText);
    }
}
