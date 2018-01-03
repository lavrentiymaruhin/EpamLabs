package yvr.forms;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class YvrArrivingFlight extends BaseForm {
    private static String formlocator="//body";

    private Label pageName = new Label(By.xpath("//h1[.='Arriving Flights']"),"pageName");

    public void assertPageName(){
        assert(pageName.isPresent());
    }

    public YvrArrivingFlight() {
        super(By.xpath(formlocator), "home");
    }
}
