package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductTest extends BaseTest {

    @Test
    public void checkCorrectLoginPassword() {
        SoftAssert softAssert = new SoftAssert();

        //открываем страницу авторизации и вводим логин и пароль
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productPage.click();
        softAssert.assertEquals(productPage.getRemove(),"Remove","Add to cart");

        //открываем корзину с добавленным товаром
        cartPage.open();
        softAssert.assertEquals(cartPage.getTitle(),"Your Cart","Products");
        softAssert.assertEquals(cartPage.getShoppingCartBadge(),"1","");
        softAssert.assertEquals(cartPage.getInventoryItemName(),"Sauce Labs Backpack","");
        softAssert.assertAll();
    }
}