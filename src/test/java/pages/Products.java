package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Products {

    WebDriver driver;

    // Locators

    By Product_Sort = By.className("product_sort_container");
    By chart_icon = By.className("shopping_cart_link");
    By burger_menu = By.id("react-burger-menu-btn");
    By All_items = By.id("inventory_sidebar_link");
    By About = By.id("about_sidebar_link");
    By logout = By.id("logout_sidebar_link");
    By Reset_App_State = By.id("reset_sidebar_link");
    By Cross_button = By.id("react-burger-cross-btn");

    // Filter Options
    By filter_a_z = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]");
    By filter_z_a = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]");
    By filter_low_high = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]");
    By filter_high_low = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]");

    // First Product
    By SL_Bp_Name = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    By SL_Bp_Image = By.xpath("//*[@id=\"item_4_img_link\"]/img");
    By SL_Bp_Addtocartbutton = By.id("add-to-cart-sauce-labs-backpack");
    By SL_Bp_removeproduct1 = By.id("remove-sauce-labs-backpack");
    By Price1 = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    // Second Product
    By SL_Bl_Name = By.xpath("//*[@id=\"item_0_title_link\"]/div");
    By SL_Bl_Image = By.xpath("//*[@id=\"item_0_img_link\"]/img");
    By SL_BL_Addtocartbutton2 = By.id("add-to-cart-sauce-labs-bike-light");
    By SL_Bp_removeproduct2 = By.id("remove-sauce-labs-bike-light");

    // Third Product
    By SL_BT_Name = By.xpath("//*[@id=\"item_1_title_link\"]/div");
    By SL_BT_Image = By.xpath("//*[@id=\"item_1_img_link\"]/img");
    By SL_BT_Addtocartbutton3 = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By SL_Bp_removeproduct3 = By.id("remove-sauce-labs-bolt-t-shirt");

    // Fourth Product
    By SL_FJ_Name = By.xpath("//*[@id=\"item_5_title_link\"]/div");
    By SL_FJ_Image = By.xpath("//*[@id=\"item_5_img_link\"]/img");
    By SL_FJ_Addtocartbutton4 = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By SL_Bp_removeproduct4 = By.id("remove-sauce-labs-fleece-jacket");

    // Fifth Product
    By SL_Onesie_Name = By.xpath("//*[@id=\"item_2_title_link\"]/div");
    By SL_Onesie_Image = By.xpath("//*[@id=\"item_2_img_link\"]/img");
    By SL_Onesie_Addtocartbutton5 = By.id("add-to-cart-sauce-labs-onesie");
    By SL_Bp_removeproduct5 = By.id("remove-sauce-labs-onesie");

    // Sixth Product
    By Test_allTheThings_Name = By.xpath("//*[@id=\"item_3_title_link\"]/div");
    By Test_allTheThings_Image = By.xpath("//*[@id=\"item_3_img_link\"]/img");
    By Test_allTheThings_Addtocartbutton6 = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    By SL_Bp_removeproduct6 = By.id("remove-test.allthethings()-t-shirt-(red)");

    // Footer Items
    By Linkedin_icon = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a");
    By Facbook_icon = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a");
    By X_icon = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a");

    // Constructor
    public Products(WebDriver driver) {
        this.driver = driver;
    }
    public String getProductPrice() {
        WebElement priceElement = driver.findElement(Price1);
        return priceElement.getText().trim();
    }

    // Generic Actions
    public void clickElement(By element) {
        driver.findElement(element).click();
    }



    public void removeProduct(By element) {
        driver.findElement(element).click();
    }

    // Specific Actions


    public void clickAbout() {
        clickElement(About);
    }

    public void clickAllItems() {
        clickElement(All_items);
    }

    public void clickChartIcon() {
        clickElement(chart_icon);
    }

    public void clickResetAppState() {
        clickElement(Reset_App_State);
    }

    public void applyFilterAtoZ() {
        clickElement(filter_a_z);
    }

    public void applyFilterZtoA() {
        clickElement(filter_z_a);
    }

    public void applyFilterLowToHigh() {
        clickElement(filter_low_high);
    }

    public void applyFilterHighToLow() {
        clickElement(filter_high_low);
    }

    public void clickLinkedinIcon() {
        clickElement(Linkedin_icon);
    }

    public void clickFacebookIcon() {
        clickElement(Facbook_icon);
    }

    public void clickXIcon() {
        clickElement(X_icon);
    }

    // Sauce Labs Backpack Methods
    public void clickSauceLabsBackpackName() {
        clickElement(SL_Bp_Name);
    }

    public void clickSauceLabsBackpackImage() {
        clickElement(SL_Bp_Image);
    }

    public void clickSauceLabsBackpackAddToCart() {
        clickElement(SL_Bp_Addtocartbutton);
    }

    public void clickSauceLabsBackpackRemove() {
        clickElement(SL_Bp_removeproduct1);
    }

    // Sauce Labs Bike Light Methods
    public void clickSauceLabsBikeLightName() {
        clickElement(SL_Bl_Name);
    }

    public void clickSauceLabsBikeLightImage() {
        clickElement(SL_Bl_Image);
    }

    public void clickSauceLabsBikeLightAddToCart() {
        clickElement(SL_BL_Addtocartbutton2);
    }

    public void clickSauceLabsBikeLightRemove() {
        clickElement(SL_Bp_removeproduct2);
    }

    // Sauce Labs Bolt T-Shirt Methods
    public void clickSauceLabsBoltTshirtName() {
        clickElement(SL_BT_Name);
    }

    public void clickSauceLabsBoltTshirtImage() {
        clickElement(SL_BT_Image);
    }

    public void clickSauceLabsBoltTshirtAddToCart() {
        clickElement(SL_BT_Addtocartbutton3);
    }

    public void clickSauceLabsBoltTshirtRemove() {
        clickElement(SL_Bp_removeproduct3);
    }

    // Sauce Labs Fleece Jacket Methods
    public void clickSauceLabsFleeceJacketName() {
        clickElement(SL_FJ_Name);
    }

    public void clickSauceLabsFleeceJacketImage() {
        clickElement(SL_FJ_Image);
    }

    public void clickSauceLabsFleeceJacketAddToCart() {
        clickElement(SL_FJ_Addtocartbutton4);
    }

    public void clickSauceLabsFleeceJacketRemove() {
        clickElement(SL_Bp_removeproduct4);
    }

    // Sauce Labs Onesie Methods
    public void clickSauceLabsOnesieName() {
        clickElement(SL_Onesie_Name);
    }

    public void clickSauceLabsOnesieImage() {
        clickElement(SL_Onesie_Image);
    }

    public void clickSauceLabsOnesieAddToCart() {
        clickElement(SL_Onesie_Addtocartbutton5);
    }

    public void clickSauceLabsOnesieRemove() {
        clickElement(SL_Bp_removeproduct5);
    }

    // Test.allTheThings() T-Shirt Methods
    public void clickTestAllTheThingsTshirtName() {
        clickElement(Test_allTheThings_Name);
    }

    public void clickTestAllTheThingsTshirtImage() {
        clickElement(Test_allTheThings_Image);
    }

    public void clickTestAllTheThingsTshirtAddToCart() {
        clickElement(Test_allTheThings_Addtocartbutton6);
    }

    public void clickTestAllTheThingsTshirtRemove() {
        clickElement(SL_Bp_removeproduct6);
    }

    // Existing Methods (تم تعديل بعض الأسماء للتوافق)
    public void clickBurgerMenu() {
        clickElement(By.id("react-burger-menu-btn"));
    }

    public void clickLogoutButton() {
        clickElement(By.id("logout_sidebar_link"));
    }
}