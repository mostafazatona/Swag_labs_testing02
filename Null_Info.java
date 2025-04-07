package page.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class Null_Info extends Base_test {

    login loginPage;
    Products productsPage;
    Cart cartPage;
    information infoPage;

    @Test
    public void test_Null_Info_with_standard() {
        // تسجيل الدخول
        loginPage = new login(base_driver);
        loginPage.setusername("standard_user");
        loginPage.setpassword("secret_sauce");
        loginPage.clickonlogin();

        // صفحة المنتجات
        productsPage = new Products(base_driver);
        productsPage.Clicking_SL_Bp_Addtocartbutton1out();
        productsPage.Clicking_SL_BL_Addtocartbutton2out();
        productsPage.Clicking_chart_icon();

        // صفحة السلة
        cartPage = new Cart(base_driver);
        cartPage.Clicking_checkout_button();

        // صفحة المعلومات
        infoPage = new information(base_driver);

        // Test 1: First Name فارغ
        infoPage.setfirst_name("");
        infoPage.setlast_name("Zidan");
        infoPage.setpostal_code("GIZA123");
        infoPage.clickoncontinue_button();

        WebElement errorMsg1 = base_driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3"));
        String actualErrorText1 = errorMsg1.getText();
        System.out.println("Error Message 1: " + actualErrorText1);
        Assert.assertTrue(actualErrorText1.contains("Error: First Name is required"));

        // Test 2: Last Name فارغ
        base_driver.navigate().refresh();
        infoPage.setfirst_name("Salma");
        infoPage.setlast_name("");
        infoPage.setpostal_code("GIZA123");
        infoPage.clickoncontinue_button();

        WebElement errorMsg2 = base_driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3"));
        String actualErrorText2 = errorMsg2.getText();
        System.out.println("Error Message 2: " + actualErrorText2);
        Assert.assertTrue(actualErrorText2.contains("Error: Last Name is required"));

        // Test 3: Postal Code فارغ
        base_driver.navigate().refresh();
        infoPage.setfirst_name("Salma");
        infoPage.setlast_name("Zidan");
        infoPage.setpostal_code("");
        infoPage.clickoncontinue_button();

        WebElement errorMsg3 = base_driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3"));
        String actualErrorText3 = errorMsg3.getText();
        System.out.println("Error Message 3: " + actualErrorText3);
        Assert.assertTrue(actualErrorText3.contains("Error: Postal Code is required"));
    }
}
