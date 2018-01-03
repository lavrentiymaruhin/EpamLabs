package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import yvr.forms.YvrMenuNavigation;
import yvr.forms.YvrSearchSite;

public class YvrSiteSearch extends BaseTest {
    public void runTest () {
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.goSearch("Business");
        YvrSearchSite yss = new YvrSearchSite();
    }
}
