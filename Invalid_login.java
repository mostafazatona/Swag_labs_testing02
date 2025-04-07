package page.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.login;

import java.time.Duration;

public class Invalid_login extends Base_test {

    login LP;

    @Test
    public void test_Invalid_login_with_standard() throws InterruptedException {
        LP = new login(base_driver); // تأكد من أنك تنشئ الكائن من صفحة تسجيل الدخول
        LP.setinvalidusername("standard_user1");
        LP.setpassword("secret_sauce1");
        LP.clickonlogin();

        // انتظار ظهور رسالة الخطأ لمدة 10 ثوانٍ
        WebDriverWait wait = new WebDriverWait(base_driver, Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[data-test='error']")));

        // التأكد من أن رسالة الخطأ تظهر كما هو متوقع
        String actualErrorMessage = errorMessageElement.getText(); // أو LP.getErrorMessage() إذا كنت جاعلها ضمن صفحة login

        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        System.out.println("Error Message: " + errorMessageElement.getText());
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "رسالة الخطأ لا تطابق المتوقعة!");
    }
}





