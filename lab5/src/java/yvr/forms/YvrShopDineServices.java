package yvr.forms;

import framework.BaseForm;
import framework.Browser;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.Select;
import framework.elements.TextBox;
import org.openqa.selenium.By;


public class YvrShopDineServices extends BaseForm {
    private static String formlocator="//body";
    private Button shopBtn = new Button(By.xpath("//button[@data-target='shop']"));
    private Button servicesBtn = new Button(By.xpath("//button[@data-target='services']"));
    private Button terminalCanadaBtn = new Button(By.xpath("//label[@for='terminal-toggle-domestic']"));
    private Button securityBeforeBtn = new Button(By.xpath("//label[@for='security-toggle-shop']"));
    private Button securityAfterBtn = new Button(By.xpath("//label[@for='security-toggle-services']"));
    private Select selectCategory = new Select(By.xpath("//select[@class='yvr-form__select']"));
    private Label openNowBtn = new Label(By.xpath("label[@for='yvr-form-opennow']"));
    private Button searchBtn = new Button(By.xpath("//button[.='Filter']"));
    private TextBox searchTbx = new TextBox(By.xpath("//input[@id='yvr-facility-list-search']"));


    public void buttonShopClick(){
        shopBtn.click();
    }

    public void buttonServicesClick(){
        servicesBtn.click();
    }

    public void buttonTerminalCanadaClick(){
        terminalCanadaBtn.click();
    }

    public void buttonSecurityBeforeClick(){
        securityBeforeBtn.click();
    }

    public void buttonSecurityAfterClick(){
        securityAfterBtn.click();
    }

    public void selectItemText(String text){
        selectCategory.selectByText(text);
    }

    public void buttonOpenNowClick(){
        openNowBtn.click();
    }

    public void buttonSearchClick(){
        searchBtn.click();
    }

    public void inputSearch(String text){

        searchTbx.click();
        searchTbx.type(text);
    }


    public YvrShopDineServices() {
        super(By.xpath(formlocator), "home");
    }
}
