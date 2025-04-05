package page.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.Products;
import pages.login;

import java.time.Duration;

public class log_out_TC extends Base_test {
    login LP;
    Products logout;
    Products burger_menu;

    @Test
    public void testlog_out() throws InterruptedException {
        LP = new login(base_driver);
        logout = new Products(base_driver);
        burger_menu = new Products(base_driver);

        LP.setusername("standard_user");
        LP.setpassword("secret_sauce");
        LP.clickonlogin();

        Wait<WebDriver> wait = new WebDriverWait(base_driver, Duration.ofSeconds(10));

        burger_menu.clickBurgerMenu(); // تعديل لاستخدام الطريقة الجديدة
        Thread.sleep(20000);
        logout.clickLogoutButton(); // تعديل لاستخدام الطريقة الجديدة
    }
}