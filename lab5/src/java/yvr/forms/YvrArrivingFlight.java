package yvr.forms;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.testng.Assert;

public class YvrArrivingFlight extends BaseForm {
    private static String formlocator="//body";

    private Label pageName = new Label(By.xpath("//h1[.='Arriving Flights']"),"pageName");
    private TextBox searchTbx = new TextBox(By.id("yvr-flights-search"));
    private TextBox searchBtn = new TextBox(By.xpath("//button[.='Search']"));
    private Label searchIdr = new Label(By.xpath("//td[@class='yvr-table__cell yvr-table__cell--fade-out yvr-table__cell--nowrap notranslate']"));
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

    public void assertSearch(String text){
        if(searchIdr.getText().equals(text)){
            assert(true);
        }else{
            assert(false);
        }
    }

    public YvrArrivingFlight() {
        super(By.xpath(formlocator), "home");
    }
}
