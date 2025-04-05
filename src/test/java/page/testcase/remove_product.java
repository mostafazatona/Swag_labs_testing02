package page.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Cart;
import pages.Products;
import pages.login;

import java.time.Duration;
import java.util.List;

public class remove_product extends Base_test {
    login testlogin;
    Products test_product1;
    Cart cart;

    @Test
    public void remove_product() {
        testlogin = new login(base_driver);
        Wait<WebDriver> wait = new WebDriverWait(base_driver, Duration.ofSeconds(5));
        test_product1 = new Products(base_driver);
        cart = new Cart(base_driver);

        testlogin.setusername("standard_user");
        testlogin.setpassword("secret_sauce");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        testlogin.clickonlogin();

        test_product1.clickSauceLabsBackpackAddToCart(); // تعديل لاستخدام الطريقة الجديدة
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
        cartLink.click();

        WebElement cartItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_item_name']")));
        String cartItemNameText = cartItemName.getText();
        System.out.println("اسم المنتج في العربة: " + cartItemNameText);

        Assert.assertEquals(cartItemNameText, "Sauce Labs Backpack", "اسم المنتج في العربة غير صحيح!");

        base_driver.navigate().back();
        test_product1.clickSauceLabsBackpackRemove(); // تعديل لاستخدام الطريقة الجديدة
        System.out.println("تمت إزالة المنتج من الصفحة الرئيسية.");

        cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
        cartLink.click();

        List<WebElement> cartItems = base_driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        if (cartItems.isEmpty()) {
            System.out.println("العربة فارغة: لا يوجد أي منتجات.");
            Assert.assertTrue(true, "العربة فارغة بنجاح.");
        } else {
            Assert.fail("العربة ليست فارغة! المنتجات الموجودة: " + cartItems.size());
        }
    }
}