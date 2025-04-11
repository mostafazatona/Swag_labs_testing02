package page.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class TC_StoE extends Base_test {
    private information checkoutInfo;
    private Checkout_Complete checkoutComplete;
    private Overview overview;
    private Cart cart;
    private login loginPage;
    private Products_details productDetails; // كائن من Products_details
    private Products products;

    @Test
    public void check_out_info() {
        // تهيئة الكائنات
        checkoutComplete = new Checkout_Complete(base_driver);
        overview = new Overview(base_driver);
        checkoutInfo = new information(base_driver);
        loginPage = new login(base_driver);
        cart = new Cart(base_driver);
        productDetails = new Products_details(base_driver); // تهيئة الكائن
        products = new Products(base_driver);

        // تعريف WebDriverWait للخطوات الحرجة
        Wait<WebDriver> wait = new WebDriverWait(base_driver, Duration.ofSeconds(20));

        // تسجيل الدخول
        loginPage.setusername("standard_user");
        loginPage.setpassword("secret_sauce");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        loginPage.clickonlogin();

        // Sauce Labs Backpack
        products.clickSauceLabsBackpackName();
        productDetails.clickAddToCart(); // استدعاء عبر الكائن
        productDetails.clickBackToProducts(); // استدعاء عبر الكائن

        // Sauce Labs Bike Light
        products.clickSauceLabsBikeLightName();
        productDetails.clickAddToCart();
        productDetails.clickBackToProducts();

        // Sauce Labs Bolt T-Shirt
        products.clickSauceLabsBoltTshirtName();
        productDetails.clickAddToCart();
        productDetails.clickBackToProducts();

        // Sauce Labs Fleece Jacket
        products.clickSauceLabsFleeceJacketName();
        productDetails.clickAddToCart();
        productDetails.clickBackToProducts();

        // Sauce Labs Onesie
        products.clickSauceLabsOnesieName();
        productDetails.clickAddToCart();
        productDetails.clickBackToProducts();

        // Test.allTheThings() T-Shirt
        products.clickTestAllTheThingsTshirtName();
        productDetails.clickAddToCart();
        productDetails.clickBackToProducts();

        // الانتقال إلى السلة
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
        cartLink.click();
        cart.Clicking_checkout_button();

        // إدخال بيانات الشحن
        checkoutInfo.setfirst_name("salma");
        checkoutInfo.setlast_name("abdelatty");
        checkoutInfo.setpostal_code("12653");

        // النقر على زر Continue
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
        checkoutInfo.continue_click();

        // النقر على زر Finish
        overview.Clicking_finish_button();


        // التحقق النهائي من اكتمال الشراء
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-complete.html"));
        String curl = base_driver.getCurrentUrl();
        Assert.assertEquals(curl, "https://www.saucedemo.com/checkout-complete.html", "لم يتم إكمال الشراء بنجاح!");
    }
}