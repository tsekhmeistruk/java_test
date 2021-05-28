package com.sample.test.demo.webdriver;

import com.sample.test.demo.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PizzaWebDriver {
    private final Configuration config;
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public PizzaWebDriver(WebDriver driver){
        config = new Configuration();
        webDriver = driver;
        wait = new WebDriverWait(webDriver, config.getTimeout());
    }

    public void Click(By by){
        WebElement element = WaitForDisplayed((by));
        element.click();
    }

    public WebElement WaitForDisplayed(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void SelectDropdown(By by, String option){
        WebElement element = WaitForDisplayed((by));
        Select dropdown = new Select(element);
        dropdown.selectByValue(option);
    }

    public String GetText(By by){
        WebElement element = WaitForDisplayed((by));
        return element.getText();
    }

    public void TypeText(By by, String text){
        WebElement element = WaitForDisplayed(by);
        element.sendKeys(text);
    }
}
