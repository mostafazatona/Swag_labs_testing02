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
import java.util.List;

public class FilterTest extends Base_test {
    login loginPage;
    Products products;

    @Test
    public void testFilters() throws InterruptedException {
        // تهيئة الكائنات
        loginPage = new login(base_driver);
        products = new Products(base_driver);

        // تسجيل الدخول
        loginPage.setusername("standard_user");
        loginPage.setpassword("secret_sauce");
        loginPage.clickonlogin();

        // الانتظار حتى يتم تحميل الصفحة
        WebDriverWait wait = new WebDriverWait(base_driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product_sort_container")));
        System.out.println("تم تحميل صفحة المنتجات بنجاح!");

        // التحقق من فلتر "A to Z"
        products.applyFilterAtoZ();
        Thread.sleep(5000); // انتظار 5 ثوانٍ
        List<String> productNamesAZ = products.getAllProductNames();
        Assert.assertTrue(isSortedAlphabetically(productNamesAZ), "المنتجات غير مرتبة من A إلى Z!");
        System.out.println("تم التحقق من فلتر 'A to Z' بنجاح!");

        // التحقق من فلتر "Z to A"
        products.applyFilterZtoA();
        Thread.sleep(5000); // انتظار 5 ثوانٍ
        List<String> productNamesZA = products.getAllProductNames();
        Assert.assertTrue(isSortedAlphabeticallyDesc(productNamesZA), "المنتجات غير مرتبة من Z إلى A!");
        System.out.println("تم التحقق من فلتر 'Z to A' بنجاح!");

        // التحقق من فلتر "Low to High"
        products.applyFilterLowToHigh();
        Thread.sleep(5000); // انتظار 5 ثوانٍ
        List<Double> productPricesLH = products.getAllProductPrices();
        Assert.assertTrue(isSortedNumerically(productPricesLH), "المنتجات غير مرتبة من الأقل إلى الأعلى!");
        System.out.println("تم التحقق من فلتر 'Low to High' بنجاح!");

        // التحقق من فلتر "High to Low"
        products.applyFilterHighToLow();
        Thread.sleep(5000); // انتظار 5 ثوانٍ
        List<Double> productPricesHL = products.getAllProductPrices();
        Assert.assertTrue(isSortedNumericallyDesc(productPricesHL), "المنتجات غير مرتبة من الأعلى إلى الأقل!");
        System.out.println("تم التحقق من فلتر 'High to Low' بنجاح!");
    }

    // التحقق من الترتيب الأبجدي (تصاعدي)
    private boolean isSortedAlphabetically(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    // التحقق من الترتيب الأبجدي (تنازلي)
    private boolean isSortedAlphabeticallyDesc(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    // التحقق من الترتيب العددي (تصاعدي)
    private boolean isSortedNumerically(List<Double> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // التحقق من الترتيب العددي (تنازلي)
    private boolean isSortedNumericallyDesc(List<Double> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}