package yvr.forms;

import framework.BaseForm;
import framework.elements.Label;
import org.openqa.selenium.By;

public class YvrDepartingFlights extends BaseForm {
    private static String formlocator="//body";

    private Label pageName = new Label(By.xpath("//h1[.='Departing Flights']"),"pageName");

    public void assertPageName(){
        assert(pageName.isPresent());
    }

    public YvrDepartingFlights() {
        super(By.xpath(formlocator), "home");
    }
}
