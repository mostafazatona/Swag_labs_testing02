package page.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Products;
import pages.login;

import java.time.Duration;

public class Burger_menu_TC extends Base_test {
    login login;
    Products products; // كائن واحد من الكلاس Products

    @Test
    public void Burger_menu() {
        // تهيئة الكائنات
        login = new login(base_driver);
        products = new Products(base_driver);

        // تسجيل الدخول
        login.setusername("standard_user");
        login.setpassword("secret_sauce");
        login.clickonlogin();

        // النقر على اسم المنتج
        products.clickSauceLabsBikeLightName();

        // فتح القائمة الجانبية
        products.clickBurgerMenu();

        // النقر على "All Items"
        products.clickAllItems();

        // فتح القائمة الجانبية مرة أخرى
        products.clickBurgerMenu();

        // النقر على "About" والتحقق من الرابط
        products.clickAbout();
        String currentUrl = base_driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://saucelabs.com/");

        // العودة إلى الصفحة السابقة
        base_driver.navigate().back();

        // فتح القائمة الجانبية والنقر على "Logout"
        products.clickBurgerMenu();

        // استخدام WebDriverWait للتأكد من أن زر Logout قابل للتفاعل
        WebDriverWait wait = new WebDriverWait(base_driver, Duration.ofSeconds(10));
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        logoutButton.click();
    }
}