package com.sample.test.demo.pageObjects;

import com.sample.test.demo.abstracts.BasePage;
import com.sample.test.demo.webdriver.PizzaWebDriver;
import org.openqa.selenium.By;

public class ModalDialog extends BasePage {
    private By closeButton = By.xpath("//button[@title='Close']");
    private By textArea = By.xpath("//div[@id='dialog']/p");
    private By dialog = By.id("dialog");

    public ModalDialog(PizzaWebDriver webDriver) {
        super(webDriver);
    }

    public void Close(){
        driver.Click(closeButton);
    }

    public String GetText(){
        return driver.GetText(textArea);
    }

    public Boolean isDisplayed(){
        try {
            driver.WaitForDisplayed(dialog);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
