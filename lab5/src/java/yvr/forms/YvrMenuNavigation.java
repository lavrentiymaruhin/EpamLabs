package yvr.forms;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class YvrMenuNavigation extends BaseForm {
    private static String formlocator="//body";

    private TextBox searchTbx = new TextBox(By.id("yvr-search"),"searchTbx");
    private Button searchBtn = new Button(By.xpath("//button[text()='Search']"),"searchBtn");
    private Button flightsBtn = new Button(By.xpath("//a[@href='/en/passengers/flights']"));
    private Button shopBtn = new Button(By.xpath("//a[@href='/en/passengers/shop-dine-and-services']"));
    private Button arrivingFlightsBtn = new Button(By.xpath("//a[@href='/en/passengers/flights/arriving-flights']"));
    private Button flightSchedulesBtn = new Button(By.xpath("//a[@href='/en/passengers/flights/flight-schedules']"));
    private Button departingFlightsBtn = new Button(By.xpath("//a[@href='/en/passengers/flights/departing-flights']"));
    private Button changeLanguageBtn = new Button(By.xpath("//a[.='Français']"),"ChangeLanguageBtn");
    private Label changeLanguageIdr = new Label(By.xpath("//button[.='Arrivées']"),"ChangeLanguageIdr");

    public YvrMenuNavigation() {
        super(By.xpath(formlocator), "home");
    }

    public void inputSearch(String text) {
        searchTbx.click();
        searchTbx.type(text);
    }

    public void buttonFlightSchedulesClick(){
        flightSchedulesBtn.click();
    }

    public void moveToFlights(){
        flightsBtn.moveToElement();
    }

    public void buttonArrivingFlightsClick(){
        arrivingFlightsBtn.click();
    }

    public void buttonDepartingFlightsClick(){
        departingFlightsBtn.click();
    }

    public void buttonShopDineServicesFlightsClick(){
        shopBtn.click();
    }

    public void buttonSearchClick() {
        searchBtn.click();
    }

    public void changeLanguage(){
        changeLanguageBtn.click();
    }

    public void goSearch(String text){
        inputSearch(text);
        buttonSearchClick();

    }

    public void goArrivingFlights(){
        moveToFlights();
        buttonArrivingFlightsClick();
    }

    public void goFlightSchedules(){
        moveToFlights();
        buttonFlightSchedulesClick();
    }

    public void goDepartingFlights(){
        moveToFlights();
        buttonDepartingFlightsClick();
    }

    public void assertChangeLanguage(){
        assert(changeLanguageIdr.isPresent());
    }


}
