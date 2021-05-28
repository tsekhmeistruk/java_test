package com.sample.test.demo.tests;

import com.sample.test.demo.abstracts.TestBase;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.pageObjects.ModalDialog;
import com.sample.test.demo.pageObjects.PizzaOrderFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SiteTests extends TestBase {

    @Test
    public void happyPath(){
        PizzaOrderFormPage pizzaOrderFormPage = getPizzaOrderFormPage();
        ModalDialog modalDialog = getModalDialog();
        PizzaTypes pizza = PizzaTypes.LARE_NOTOPPINGS;
        double pizzaQuantity = 1;
        pizzaOrderFormPage.SelectPizza(pizza)
                          .TypeQuantity(String.valueOf(pizzaQuantity))
                          .TypeEmail("myemail@mail.com")
                          .TypePhone("555-55-55")
                          .SelectCardPayment()
                          .ClickPlaceOrder();
        Assert.assertTrue(modalDialog.isDisplayed());
        String actualTextMessage = modalDialog.GetText();
        double expectedCost = pizza.getCost() * pizzaQuantity;
        Assert.assertTrue(actualTextMessage.contains(String.valueOf(expectedCost)));
    }

    private PizzaOrderFormPage getPizzaOrderFormPage(){
        return new PizzaOrderFormPage(webDriver);
    }

    private ModalDialog getModalDialog(){
        return new ModalDialog(webDriver);
    }
}
