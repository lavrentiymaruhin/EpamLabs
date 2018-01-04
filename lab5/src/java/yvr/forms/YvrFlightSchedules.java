package yvr.forms;

import framework.BaseForm;
import framework.Browser;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class YvrFlightSchedules extends BaseForm {
    private static String formlocator="//body";
    private TextBox airportTbx = new TextBox(By.id("flight-finded-destination-autocomplete-input"));
    private Button airportSearchBtn = new Button(By.id("search-button"));
    private Label warningTextIdr = new Label(By.xpath("//span[.='Please choose a destination']"));

    public void sendAirport(String text){
        airportTbx.click();
        airportTbx.type(text);
    }

    public void clickSearchAirport(){
        airportSearchBtn.click();
    }

    public void goSearchFlights(String text){
        sendAirport(text);
        clickSearchAirport();
    }

    public void assertWarningMessage(){
        assert(warningTextIdr.isPresent());
    }

    public YvrFlightSchedules() {
        super(By.xpath(formlocator), "home");
    }
}
