package yvr.forms;

import framework.BaseForm;
import framework.elements.Label;
import org.openqa.selenium.By;

public class YvrSearchSite extends BaseForm {
    private static String formlocator="//body";

    private Label searchResultIdr = new Label(By.xpath("//span[@class='highlight']"),"SearchResultIdr");

    public void assertSearchResult(String text){

        if(searchResultIdr.getText().equals(text)){
            assert(true);
        }else{
            assert(false);
        }
    }

    public YvrSearchSite() {
        super(By.xpath(formlocator), "home");
    }
}
