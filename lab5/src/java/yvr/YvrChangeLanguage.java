package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import yvr.forms.YvrMenuNavigation;

public class YvrChangeLanguage extends BaseTest {
    public void runTest () throws InterruptedException {
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.changeLanguage();
        ymn.assertChangeLanguage();
    }
}
