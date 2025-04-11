package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Products_details {
    WebDriver driver;

    public Products_details(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By backToProductsButton = By.id("back-to-products");
    By addToCartButton = By.id("add-to-cart");
    By removeButton = By.id("remove");

    // Actions
    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public String clickRemoveProduct() {
        driver.findElement(removeButton).click();
        return null;
    }

    public void clickBackToProducts() {
        driver.findElement(backToProductsButton).click();
    }

    /* By burgerMenu = By.id("react-burger-menu-btn");
    By allItems = By.id("inventory_sidebar_link");
    By aboutLink = By.id("about_sidebar_link");
    By logoutButton = By.id("logout_sidebar_link");
    By resetAppState = By.id("reset_sidebar_link");
    By cartIcon = By.className("shopping_cart_link");

    public void clickAbout() {
        driver.findElement(aboutLink).click();
    }

    public void clickAllItems(By allItemsLocator) {
        driver.findElement(allItems).click();
    }

    public void clickBurgerMenu() {
        driver.findElement(burgerMenu).click();
    }

    public void clickCartIcon(By cartLocator) {
        driver.findElement(cartIcon).click();
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }

    public void clickResetAppState(By resetLocator) {
        driver.findElement(resetAppState).click();
    }
    */
}

    /* By burgerMenu = By.id("react-burger-menu-btn");          // كان burger_menu
    By allItems = By.id("inventory_sidebar_link");           // كان All_items
    By aboutLink = By.id("about_sidebar_link");              // كان About
    By logoutButton = By.id("logout_sidebar_link");          // كان logout
    By resetAppState = By.id("reset_sidebar_link");          // كان Reset_App_State
    By cartIcon = By.className("shopping_cart_link");        // كان chart_icon

    public void clickAbout() {                               // كان Clicking_About
        driver.findElement(aboutLink).click();
    }

    public void clickAllItems(By allItemsLocator) {          // كان Clicking_All_items مع تعديل الاسم
        driver.findElement(allItems).click();
    }

    public void clickBurgerMenu() {                          // كان Clicking_burger_menu
        driver.findElement(burgerMenu).click();
    }

    public void clickCartIcon(By cartLocator) {              // كان Clicking_chart_icon مع تعديل الاسم
        driver.findElement(cartIcon).click();
    }

    public void clickLogout() {                              // كان Clicking_logout_button
        driver.findElement(logoutButton).click();
    }

    public void clickResetAppState(By resetLocator) {        // كان Clicking_Reset_App_State مع تعديل الاسم
        driver.findElement(resetAppState).click();
    }
    */

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