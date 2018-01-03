package yvr.forms;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class YvrMenuNavigation extends BaseForm {
    private static String formlocator="//body";

    private TextBox searchTextBox = new TextBox(By.id("yvr-search"),"searchTxt");
    private Button searchButton = new Button(By.xpath("//button[text()='Search']"),"searchBtn");
    private Button flightsBtn = new Button(By.xpath("//a[@href='/en/passengers/flights']"));
    private Button arrivingFlightsBtn = new Button(By.xpath("//a[@href='/en/passengers/flights/arriving-flights']"));
    private Button departingFlightsBtn = new Button(By.xpath("//a[@href='/en/passengers/flights/departing-flights']"));
    public YvrMenuNavigation() {
        super(By.xpath(formlocator), "home");
    }

    public void inputSearch(String text) {
        searchTextBox.click();
        searchTextBox.type(text);
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

    public void buttonSearchClick() {
        searchButton.click();
    }

    public void goSearch(String text){
        inputSearch(text);
        buttonSearchClick();

    }

    public void goArrivingFlights(){
        moveToFlights();
        buttonArrivingFlightsClick();
    }

    public void goDepartingFlights(){
        moveToFlights();
        buttonDepartingFlightsClick();
    }
}
