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

    private static final String CANADA_NAME = "Domestic Terminal";
    private static final String AFTER_NAME = "After security";
    private static final String BEFORE_NAME = "Before security";

    private Label openNowIdr = new Label(By.xpath("//strong[.='Open now']"),"ChangeLanguageBtn");
    private Label categoryIdr = new Label(By.xpath("//div[@class='yvr-facility-list__subcategory yvr-facility-list__subcategory--LOC_PERSONAL_SERVICES']"));
    private Label nameSearchIdr = new Label(By.xpath("//a[@class='yvr-facility-list__name']"));
    private Label locationSearchIdr = new Label(By.xpath("//div[@class='yvr-facility-list__location']"));
    private Label openNowBtn = new Label(By.xpath("//label[@for='yvr-form-opennow']"));
    private Button shopBtn = new Button(By.xpath("//button[@data-target='shop']"));
    private Button servicesBtn = new Button(By.xpath("//button[@data-target='services']"));
    private Button terminalCanadaBtn = new Button(By.xpath("//label[@for='terminal-toggle-domestic']"));
    private Button securityBeforeBtn = new Button(By.xpath("//label[@for='security-toggle-shop']"));
    private Button securityAfterBtn = new Button(By.xpath("//label[@for='security-toggle-services']"));
    private Button searchBtn = new Button(By.xpath("//button[.='Filter']"));
    private TextBox searchTbx = new TextBox(By.xpath("//input[@id='yvr-facility-list-search']"));
    private Select selectCategory = new Select(By.xpath("//select[@class='yvr-form__select']"));

    public YvrShopDineServices() {
        super(By.xpath(formlocator), "home");
    }

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

    public void assertShopSearch(String text){
        boolean search = nameSearchIdr.getText().toLowerCase().contains(text.toLowerCase());
        boolean canada = locationSearchIdr.getText().contains(CANADA_NAME);
        boolean before = locationSearchIdr.getText().contains(BEFORE_NAME);
       if(search&&canada&&before){
           assert(true);
       }else{
           assert(false);
       }

    }

    public void assertHotelSearch(String text){
        if(categoryIdr.getText().equals(text)){
            assert(true);
        }else {
            assert(false);
        }
    }

    public void assertCurrencySearch(String text){
       assert(openNowIdr.isPresent());
       boolean after = locationSearchIdr.getText().contains(AFTER_NAME);
       if(categoryIdr.getText().equals(text)&&after){
           assert(true);
       }else {
           assert(false);
       }
    }


    public void inputSearch(String text){
        searchTbx.click();
        searchTbx.type(text);
    }

}
