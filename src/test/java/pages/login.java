package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login {
    /* Variables */
    WebDriver driver;

    public login(WebDriver driver) {
        this.driver = driver;
    }

    /* Locators */
    By username = By.id("user-name");
    By passwordfield = By.id("password");
    By log_bty = By.id("login-button");

    /* Actions */
    public void setusername(String user_name) {
        // استخدام WebDriverWait للتأكد من وجود العنصر قبل التفاعل معه
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(username)).sendKeys(user_name);
    }

    public void setpassword(String password) {
        // استخدام WebDriverWait للتأكد من وجود العنصر قبل التفاعل معه
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordfield)).sendKeys(password);
    }

    public void clickonlogin() {
        // استخدام WebDriverWait للتأكد من وجود العنصر قبل التفاعل معه
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(log_bty)).click();
    }
}