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

public class E_pricecart_TC extends Base_test {
    login testlogin;
    Products SL_Bp_Name; // يمثل Sauce Labs Backpack
    Cart cart;

    @Test
    public void E_price_TC() {
        testlogin = new login(base_driver);
        Wait<WebDriver> wait = new WebDriverWait(base_driver, Duration.ofSeconds(5));
        SL_Bp_Name = new Products(base_driver);
        cart = new Cart(base_driver);

        // تسجيل الدخول
        testlogin.setusername("standard_user");
        testlogin.setpassword("secret_sauce");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        testlogin.clickonlogin();

        // الحصول على سعر المنتج من صفحة المنتج
        String productPriceOnPage = SL_Bp_Name.getProductPrice();
        System.out.println("سعر المنتج على صفحة المنتج: " + productPriceOnPage);

        // إضافة المنتج إلى العربة
        SL_Bp_Name.clickSauceLabsBackpackAddToCart();

        // الانتقال إلى عربة التسوق
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
        cartLink.click();

        // الحصول على السعر من عربة التسوق باستخدام xpath المقدم
        WebElement cartItemPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
        ));
        String cartItemPriceText = cartItemPriceElement.getText().trim();
        System.out.println("سعر المنتج في عربة التسوق: " + cartItemPriceText);

        // التحقق من أن السعر في عربة التسوق يطابق السعر الأصلي
        Assert.assertEquals(cartItemPriceText, productPriceOnPage, "السعر في عربة التسوق غير متطابق مع السعر الأصلي");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cart.Continue_Shopping_button();
    }
}