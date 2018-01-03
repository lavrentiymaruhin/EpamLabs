package yvr;

import framework.ApplicationPropertis;
import framework.BaseTest;
import yvr.forms.YvrFlightSchedules;
import yvr.forms.YvrMenuNavigation;

public class YvrFlightSchedulesSearch extends BaseTest {
    public void runTest () throws InterruptedException {
        browser.navigate(ApplicationPropertis.getTestProperty("url"));
        YvrMenuNavigation ymn = new YvrMenuNavigation();
        ymn.goFlightSchedules();
        YvrFlightSchedules yfs = new YvrFlightSchedules();
        
    }
}
