package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class information {

        WebDriver driver;

        public information(WebDriver driver) {
            this.driver = driver;
        }

        By first_namefiled = By.id("first-name");
        By last_namefild = By.id("last-name");
        By postal_codedfild = By.id("postal-code");
        By continue2 = By.id("continue");
        By cansel_button= By.id("cancel");

        public void setfirst_name(String first_name) {
            driver.findElement(first_namefiled).sendKeys(first_name);

        }
    public void setlast_name(String last_name) {
        driver.findElement(last_namefild).sendKeys(last_name);

    }public void setpostal_code(String postal_code) {
        driver.findElement(postal_codedfild).sendKeys(postal_code);

    }


        public void continue_click() {
            driver.findElement(continue2).click();
        }
            public void cancel_click() {
                driver.findElement(cansel_button).click();


        }
    }
