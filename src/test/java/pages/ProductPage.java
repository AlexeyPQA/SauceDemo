package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

    By title = By.cssSelector("[data-test=title]");
    By AddToCart = By.cssSelector("[data-test=add-to-cart-sauce-labs-backpack]");
    By remove = By.cssSelector("[data-test=remove-sauce-labs-backpack]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void click() {
        driver.findElement(AddToCart).click();
    }

    public String getRemove() {
        return driver.findElement(remove).getText();
    }
}