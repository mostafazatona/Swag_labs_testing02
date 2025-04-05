package page.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Products;
import pages.login;

public class Burger_menu_TC extends Base_test {
    login login;
    Products about;
    Products burger_menu;

    @Test
    public void Burger_menu() {
        login = new login(base_driver);
        about = new Products(base_driver);
        burger_menu = new Products(base_driver);

        login.setusername("standard_user");
        login.setpassword("secret_sauce");
        login.clickonlogin();

        burger_menu.clickBurgerMenu();


        // تعديل لاستخدام الطريقة الجديدة
        about.clickAbout(); // موجودة بالفعل في الكود الأصلي
        String curl = base_driver.getCurrentUrl();
        Assert.assertEquals(curl, "https://saucelabs.com/");
    }
}