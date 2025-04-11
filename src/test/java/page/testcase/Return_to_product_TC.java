package page.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Cart;
import pages.information;
import pages.login;
import pages.Overview;
import pages.Products;
import pages.Checkout_Complete;

import java.time.Duration; // إضافة هذه المكتبة

public class Return_to_product_TC extends Base_test {
    information test_ch_out;
    Cart cart;
    login testlogin;
    Overview testoverview;
    Products products;
    Checkout_Complete test_Return_to_product;

    @Test
    public void Return_to_product_TC() {
        // تعريف WebDriverWait باستخدام Duration
        WebDriverWait wait = new WebDriverWait(base_driver, Duration.ofSeconds(60));

        test_ch_out = new information(base_driver);
        testlogin = new login(base_driver);
        cart = new Cart(base_driver);
        products = new Products(base_driver);
        test_Return_to_product = new Checkout_Complete(base_driver);
        testoverview  =new Overview(base_driver);
        // تسجيل الدخول
        testlogin.setusername("standard_user");
        testlogin.setpassword("secret_sauce");

        // انتظار زر الـ login ليكون قابلاً للنقر ثم النقر عليه
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        loginButton.click();

        // إضافة العناصر للسلة مع انتظار ظهور الأزرار
        WebElement addBackpack = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
        addBackpack.click();

        WebElement addTshirt = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-bolt-t-shirt")));
        addTshirt.click();

        // الانتقال للسلة مع انتظار زر السلة
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
        cartLink.click();

        // النقر على زر checkout مع انتظار
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
        checkoutButton.click();

        // إدخال بيانات المعلومات
        test_ch_out.setfirst_name("salma");
        test_ch_out.setlast_name("abdelatty");
        test_ch_out.setpostal_code("12653");

        // انتظار زر continue ثم النقر عليه
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
        continueButton.click();

        WebElement finish_button = wait.until(ExpectedConditions.elementToBeClickable(By.id("finish")));
       finish_button.click();

        // النقر على زر Back Home بعد إكمال الشراء
        WebElement backHomeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("back-to-products")));
        backHomeButton.click();


        // التحقق من العودة إلى صفحة المنتجات
        WebElement productPageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        Assert.assertEquals(productPageHeader.getText(), "Products", "لم يتم العودة إلى صفحة المنتجات بنجاح!");
    }
}