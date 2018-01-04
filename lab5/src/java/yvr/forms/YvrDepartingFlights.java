package yvr.forms;

import framework.BaseForm;
import framework.elements.Label;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class YvrDepartingFlights extends BaseForm {
    private static String formlocator="//body";

    private Label pageName = new Label(By.xpath("//h1[.='Departing Flights']"),"pageName");
    private TextBox searchTbx = new TextBox(By.id("yvr-flights-search"));
    private TextBox searchBtn = new TextBox(By.xpath("//button[.='Search']"));
    private Label warningIdr = new Label(By.xpath("//div[.='No matching flights. Try another search.']"));

    public void inputSearchTbx(String text){
        searchTbx.click();
        searchTbx.type(text);
    }

    public void buttonSearchClick(){
        searchBtn.click();
    }

    public void assertPageName(){
        assert(pageName.isPresent());
    }

    public void assertWarningMessage(){
        assert(warningIdr.isPresent());
    }

    public YvrDepartingFlights() {
        super(By.xpath(formlocator), "home");
    }
}
