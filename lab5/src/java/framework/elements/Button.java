package framework.elements;

import org.openqa.selenium.By;

public class Button extends BaseElement {
    public Button(final By locator, final String name) {
        super(locator, name);
    }

    public Button(String string, String name) {
        super(string, name);
    }


    protected String getElementType() {
        return "Button";
    }

    public boolean isEnabled(){
        return this.getElement().isEnabled();
    }





    public Button(By locator) {
        super(locator);
    }
}
