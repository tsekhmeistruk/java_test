package com.sample.test.demo.pageObjects;

import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.webdriver.PizzaWebDriver;
import com.sample.test.demo.abstracts.BasePage;
import org.openqa.selenium.By;

public class PizzaOrderFormPage extends BasePage {

    private By pizza1Select = By.id("pizza1Pizza");
    private By pizza1Toppings1Select = By.xpath("//div[@id='pizza1']//select[@class='toppings1']");
    private By pizza1Toppings2Select = By.xpath("//div[@id='pizza1']//select[@class='toppings2']");
    private By pizza1QuantityInput = By.id("pizza1Qty");
    private By pizza1CostLabel = By.id("pizza1Cost");
    private By cardPaymentRadioButton = By.id("ccpayment");
    private By cashPaymentRadioButton = By.id("cashpayment");
    private By emailInput = By.id("email");
    private By nameInput = By.id("name");
    private By phoneInput = By.id("phone");
    private By placeOrderButton = By.id("placeOrder");
    private By resetButton = By.id("reset");

    public PizzaOrderFormPage(PizzaWebDriver webDriver) {
        super(webDriver);
    }

    public PizzaOrderFormPage SelectPizza(PizzaTypes pizzaType){
        driver.SelectDropdown(pizza1Select, pizzaType.getDisplayName());
        return this;
    }

    public PizzaOrderFormPage SelectToppings1(PizzaToppings toppings1){
        driver.SelectDropdown(pizza1Toppings1Select, toppings1.getDisplayName());
        return this;
    }

    public PizzaOrderFormPage SelectToppings2(PizzaToppings toppings2){
        driver.SelectDropdown(pizza1Toppings2Select, toppings2.getDisplayName());
        return this;
    }

    public PizzaOrderFormPage TypeQuantity(String quantity){
        driver.TypeText(pizza1QuantityInput, quantity);
        return this;
    }

    public String GetCost(){
        return driver.GetText(pizza1CostLabel);
    }

    public PizzaOrderFormPage TypeName(String name){
        driver.TypeText(nameInput, name);
        return this;
    }

    public PizzaOrderFormPage TypeEmail(String email){
        driver.TypeText(emailInput, email);
        return this;
    }

    public PizzaOrderFormPage TypePhone(String phone){
        driver.TypeText(phoneInput, phone);
        return this;
    }

    public PizzaOrderFormPage SelectCashPayment(){
        driver.Click(cashPaymentRadioButton);
        return this;
    }

    public PizzaOrderFormPage SelectCardPayment(){
        driver.Click(cardPaymentRadioButton);
        return this;
    }

    public ModalDialog ClickPlaceOrder(){
        driver.Click(placeOrderButton);
        return new ModalDialog(driver);
    }

    public PizzaOrderFormPage ClickReset(){
        driver.Click(resetButton);
        return this;
    }
}
