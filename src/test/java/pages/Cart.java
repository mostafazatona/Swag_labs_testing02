package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
    WebDriver driver;

    public Cart(WebDriver driver) {
        this.driver = driver;
    }
    By checkout_button = By.id("checkout");
    By Continue_Shopping_button = By.id("continue-shopping");

    public void Clicking_checkout_button() {
        driver.findElement(checkout_button).click();

    }
    public void Continue_Shopping_button () {
        driver.findElement(Continue_Shopping_button  ).click();

    }
}
