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

        // تسجيل الدخول
        testlogin.setusername("standard_user");
        testlogin.setpassword("secret_sauce");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        testlogin.clickonlogin();

        // إضافة المنتج إلى العربة (من صفحة المنتجات)
        test_product1.clickSauceLabsBackpackAddToCart();
        System.out.println("تمت إضافة المنتج إلى العربة.");

        // الانتقال إلى العربة
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
        cartLink.click();

        // التحقق من اسم المنتج في العربة
        WebElement cartItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_item_name']")));
        String cartItemNameText = cartItemName.getText();
        System.out.println("اسم المنتج في العربة: " + cartItemNameText);

        Assert.assertEquals(cartItemNameText, "Sauce Labs Backpack", "اسم المنتج في العربة غير صحيح!");

        // العودة إلى صفحة المنتجات وإزالة المنتج
        base_driver.navigate().back();
        test_product1.clickSauceLabsBackpackRemove();
        System.out.println("تمت إزالة المنتج من الصفحة الرئيسية.");

        // التحقق من أن العربة فارغة
        cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
        cartLink.click();

        List<WebElement> cartItems = base_driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        if (cartItems.isEmpty()) {
            System.out.println("العربة فارغة: لا يوجد أي منتجات.");
            Assert.assertTrue(true, "العربة فارغة بنجاح.");
        } else {
            Assert.fail("العربة ليست فارغة! المنتجات الموجودة: " + cartItems.size());
        }

        // إعادة إضافة المنتج إلى العربة
        base_driver.navigate().back(); // العودة إلى صفحة المنتجات
        test_product1.clickSauceLabsBackpackAddToCart();
        System.out.println("تمت إعادة إضافة المنتج إلى العربة.");

        // الانتقال إلى العربة مرة أخرى
        cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
        cartLink.click();

        // إزالة المنتج من صفحة العربة
        WebElement removeButtonInCart = wait.until(ExpectedConditions.elementToBeClickable(By.id("remove-sauce-labs-backpack")));
        removeButtonInCart.click();
        System.out.println("تمت إزالة المنتج من صفحة العربة.");

        // التحقق من أن العربة فارغة مرة أخرى
        cartItems = base_driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        if (cartItems.isEmpty()) {
            System.out.println("العربة فارغة: لا يوجد أي منتجات.");
            Assert.assertTrue(true, "العربة فارغة بنجاح.");
        } else {
            Assert.fail("العربة ليست فارغة! المنتجات الموجودة: " + cartItems.size());
        }
    }
}