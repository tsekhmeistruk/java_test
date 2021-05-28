package com.sample.test.demo.abstracts;

import com.sample.test.demo.webdriver.PizzaWebDriver;

public abstract class BasePage {
    protected PizzaWebDriver driver;

    public BasePage(PizzaWebDriver webDriver){
        driver = webDriver;
    }
}
