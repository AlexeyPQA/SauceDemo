package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    By shoppingCart = By.cssSelector("[data-test=shopping-cart-link]");
    By title = By.cssSelector("[data-test=title]");
    By shoppingCartBadge = By.cssSelector("[data-test=shopping-cart-badge]");
    By inventoryItemName = By.cssSelector("[data-test=inventory-item-name]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.findElement(shoppingCart).click();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public String getShoppingCartBadge() {
        return driver.findElement(shoppingCartBadge).getText();
    }

    public String getInventoryItemName() {
        return driver.findElement(inventoryItemName).getText();
    }
}