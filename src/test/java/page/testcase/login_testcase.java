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

public class login_testcase extends Base_test {
    login LP;

    // DataProvider لقراءة بيانات تسجيل الدخول من ملف Excel
    @DataProvider(name = "loginData")
    public Object[][] getData(Method method) {
        String excelPath = "C:\\Users\\TATA\\Desktop\\users.xlsx"; // مسار ملف Excel
        ExcelUtils excel = new ExcelUtils(excelPath, "Sheet1");

        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();

        Object data[][] = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) { // تخطي الصف الأول (العناوين)
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = excel.getCellData(i, j);
            }
        }
        return data;
    }

    // حالة الاختبار باستخدام البيانات من DataProvider
    @Test(dataProvider = "loginData")
    public void test_login_with_all_users(String username, String password) {
        LP = new login(base_driver);

        // التوجه إلى صفحة تسجيل الدخول
        base_driver.get("https://www.saucedemo.com/");

        // تسجيل الدخول باستخدام البيانات المقدمة
        LP.setusername(username);
        LP.setpassword(password);
        LP.clickonlogin();

        // التحقق من نتيجة تسجيل الدخول بناءً على اسم المستخدم
        if (username.equals("locked_out_user")) {
            // التحقق من رسالة الخطأ الخاصة بالمستخدم المحظور
            WebDriverWait wait = new WebDriverWait(base_driver, Duration.ofSeconds(10));
            By errorMessage = By.xpath("//h3[@data-test='error']");
            String actualErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
            Assert.assertEquals(actualErrorMessage, "Epic sadface: Sorry, this user has been locked out.");
        } else {
            // التحقق من نجاح تسجيل الدخول
            WebDriverWait wait = new WebDriverWait(base_driver, Duration.ofSeconds(10));
            By inventoryContainer = By.id("inventory_container"); // العنصر الذي يشير إلى صفحة المنتجات
            boolean isLoginSuccessful = wait.until(ExpectedConditions.presenceOfElementLocated(inventoryContainer)).isDisplayed();

            Assert.assertTrue(isLoginSuccessful, "تسجيل الدخول غير ناجح للمستخدم: " + username);
        }
    }
}
/*package page.testcase;

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
        Thread.sleep(5000); // 20000 ميلي ثانية = 20 ثانية

    }
}*/