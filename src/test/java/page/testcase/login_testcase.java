package page.testcase;

import Utalities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.login;

import java.lang.reflect.Method;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class login_testcase extends Base_test {
    login LP;

    @Test
    public void test_login_with_standard() throws InterruptedException {
        LP = new login(base_driver);

        // تسجيل الدخول باستخدام بيانات المستخدم
        LP.setusername("standard_user");
        LP.setpassword("secret_sauce");
        LP.clickonlogin();

        // انتظار لمدة 20 ثانية بعد انتهاء حالة الاختبار
        Thread.sleep(10000); // 20000 ميلي ثانية = 20 ثانية

    }
}