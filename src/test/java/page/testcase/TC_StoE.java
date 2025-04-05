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
    information test_ch_out;
    Checkout_Complete checkoutComplete;
    Overview finish;
    Cart cart;
    Cart chart_icon;
    login testlogin;
    Products_details SLB_details;
    Products sauceLabsBackpackName;
    Products sauceLabsBikeLightName;
    Products sauceLabsBoltTshirtName;
    Products sauceLabsFleeceJacketName;
    Products sauceLabsOnesieName;
    Products testAllTheThingsTshirtName;

    @Test
    public void check_out_info() {
        // تهيئة الكائنات
        checkoutComplete = new Checkout_Complete(base_driver);
        finish = new Overview(base_driver);
        test_ch_out = new information(base_driver);
        testlogin = new login(base_driver);
        cart = new Cart(base_driver);
        chart_icon = new Cart(base_driver);
        SLB_details = new Products_details(base_driver);
        sauceLabsBackpackName = new Products(base_driver);
        sauceLabsBikeLightName = new Products(base_driver);
        sauceLabsBoltTshirtName = new Products(base_driver);
        sauceLabsFleeceJacketName = new Products(base_driver);
        sauceLabsOnesieName = new Products(base_driver);
        testAllTheThingsTshirtName = new Products(base_driver);

        // تعريف WebDriverWait للخطوات الحرجة
        Wait<WebDriver> wait = new WebDriverWait(base_driver, Duration.ofSeconds(20));

        // تسجيل الدخول
        testlogin.setusername("standard_user");
        testlogin.setpassword("secret_sauce");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        testlogin.clickonlogin();

        // Sauce Labs Backpack
        sauceLabsBackpackName.clickSauceLabsBackpackName(); // النقر على الاسم للانتقال إلى التفاصيل
        SLB_details.Click_add_prouduct(); // النقر على زر Add to Cart في صفحة التفاصيل
        SLB_details.Clicking_SLB_details(); // العودة إلى صفحة المنتجات

        // Sauce Labs Bike Light
        sauceLabsBikeLightName.clickSauceLabsBikeLightName();
        SLB_details.Click_add_prouduct();
        SLB_details.Clicking_SLB_details();

        // Sauce Labs Bolt T-Shirt
        sauceLabsBoltTshirtName.clickSauceLabsBoltTshirtName();
        SLB_details.Click_add_prouduct();
        SLB_details.Clicking_SLB_details();

        // Sauce Labs Fleece Jacket
        sauceLabsFleeceJacketName.clickSauceLabsFleeceJacketName();
        SLB_details.Click_add_prouduct();
        SLB_details.Clicking_SLB_details();

        // Sauce Labs Onesie
        sauceLabsOnesieName.clickSauceLabsOnesieName();
        SLB_details.Click_add_prouduct();
        SLB_details.Clicking_SLB_details();

        // Test.allTheThings() T-Shirt
        testAllTheThingsTshirtName.clickTestAllTheThingsTshirtName();
        SLB_details.Click_add_prouduct();
        SLB_details.Clicking_SLB_details();

        // الانتقال إلى السلة
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
        cartLink.click();
        chart_icon.Clicking_checkout_button();

        // إدخال بيانات الشحن
        test_ch_out.setfirst_name("salma");
        test_ch_out.setlast_name("abdelatty");
        test_ch_out.setpostal_code("12653");

        // النقر على زر Continue
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
        test_ch_out.continue_click();

        // النقر على زر Finish
        finish.Clicking_finish_button();

        // التحقق النهائي من اكتمال الشراء
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-complete.html"));
        String curl = base_driver.getCurrentUrl();
        Assert.assertEquals(curl, "https://www.saucedemo.com/checkout-complete.html", "لم يتم إكمال الشراء بنجاح!");
    }
}