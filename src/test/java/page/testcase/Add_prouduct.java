package page.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.Cart;
import pages.Products;
import pages.login;

import java.time.Duration;

public class Add_prouduct extends Base_test {
    login testlogin;
    Products SL_Bp_Name; // يمثل Sauce Labs Backpack
    Cart cart;

    @Test
    public void addProuduct() {
        testlogin = new login(base_driver);
        Wait<WebDriver> wait = new WebDriverWait(base_driver, Duration.ofSeconds(5));
        SL_Bp_Name = new Products(base_driver);
        cart = new Cart(base_driver);

        testlogin.setusername("standard_user");
        testlogin.setpassword("secret_sauce");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        testlogin.clickonlogin();

        SL_Bp_Name.clickSauceLabsBackpackAddToCart(); // تعديل لاستخدام الطريقة الجديدة

        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
        cartLink.click();

        WebElement cartItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_item_name']")));
        String cartItemNameText = cartItemName.getText();
        System.out.println("اسم المنتج في العربة: " + cartItemNameText);

        Assert.assertEquals(cartItemNameText, "Sauce Labs Backpack", "المنتج المضاف إلى السلة غير متطابق مع المتوقع");
    }


}