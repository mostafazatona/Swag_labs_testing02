package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Products_details {
    WebDriver driver;

    public Products_details(WebDriver driver) {
        this.driver = driver;
    }

    By SLB_details = By.id("back-to-products");
    By Addtocart_SLB = By.id("add-to-cart");
    By removeproduct = By.id("remove");

    public void Click_add_prouduct() {
        driver.findElement(Addtocart_SLB).click();
    }

    public String Clicking_remove_product() {
        driver.findElement(removeproduct).click();
        return null;
    }

    public void Clicking_SLB_details() {
        driver.findElement(SLB_details).click(); // تعديل للنقر على زر الرجوع
    }
}
/* By burger_menu = By.id("react-burger-menu-btn");
    By All_items =By.id("inventory_sidebar_link");
    By About = By.id("about_sidebar_link");
    By logout =By.id("logout_sidebar_link");
    By Reset_App_State =By.id("reset_sidebar_link");
    By chart_icon = By.className("shopping_cart_link");

     public void Clicking_About () {
        driver.findElement(About).click();

    }
    public void Clicking_All_items (By all_items) {
        driver.findElement(All_items).click();

    }
    public void Clicking_burger_menu () {
        driver.findElement(burger_menu).click();

    }
    public void Clicking_chart_icon  (By chart) {
        driver.findElement(chart_icon).click();

    }

    public void Clicking_logout_button () {
        driver.findElement(logout).click();

    }
    public void Clicking_Reset_App_State (By Reset) {
        driver.findElement(Reset_App_State).click();

    }


    */