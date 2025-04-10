package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Products {

    private WebDriver driver;

    // Locators
    private By Product_Sort = By.className("product_sort_container");
    private By chart_icon = By.className("shopping_cart_link");
    private By burger_menu = By.id("react-burger-menu-btn");
    private By All_items = By.id("inventory_sidebar_link");
    private By About = By.id("about_sidebar_link");
    private By logout = By.id("logout_sidebar_link");
    private By Reset_App_State = By.id("reset_sidebar_link");
    private By Cross_button = By.id("react-burger-cross-btn");

    // Filter Options
    private By filter_a_z = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]");
    private By filter_z_a = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]");
    private By filter_low_high = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]");
    private By filter_high_low = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]");

    // First Product
    private By SL_Bp_Name = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private By SL_Bp_Image = By.xpath("//*[@id=\"item_4_img_link\"]/img");
    private By SL_Bp_Addtocartbutton = By.id("add-to-cart-sauce-labs-backpack");
    private By SL_Bp_removeproduct1 = By.id("remove-sauce-labs-backpack");
    private By Price1 = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");

    // Second Product
    private By SL_Bl_Name = By.xpath("//*[@id=\"item_0_title_link\"]/div");
    private By SL_Bl_Image = By.xpath("//*[@id=\"item_0_img_link\"]/img");
    private By SL_BL_Addtocartbutton2 = By.id("add-to-cart-sauce-labs-bike-light");
    private By SL_Bp_removeproduct2 = By.id("remove-sauce-labs-bike-light");

    // Third Product
    private By SL_BT_Name = By.xpath("//*[@id=\"item_1_title_link\"]/div");
    private By SL_BT_Image = By.xpath("//*[@id=\"item_1_img_link\"]/img");
    private By SL_BT_Addtocartbutton3 = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By SL_Bp_removeproduct3 = By.id("remove-sauce-labs-bolt-t-shirt");

    // Fourth Product
    private By SL_FJ_Name = By.xpath("//*[@id=\"item_5_title_link\"]/div");
    private By SL_FJ_Image = By.xpath("//*[@id=\"item_5_img_link\"]/img");
    private By SL_FJ_Addtocartbutton4 = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By SL_Bp_removeproduct4 = By.id("remove-sauce-labs-fleece-jacket");

    // Fifth Product
    private By SL_Onesie_Name = By.xpath("//*[@id=\"item_2_title_link\"]/div");
    private By SL_Onesie_Image = By.xpath("//*[@id=\"item_2_img_link\"]/img");
    private By SL_Onesie_Addtocartbutton5 = By.id("add-to-cart-sauce-labs-onesie");
    private By SL_Bp_removeproduct5 = By.id("remove-sauce-labs-onesie");

    // Sixth Product
    private By Test_allTheThings_Name = By.xpath("//*[@id=\"item_3_title_link\"]/div");
    private By Test_allTheThings_Image = By.xpath("//*[@id=\"item_3_img_link\"]/img");
    private By Test_allTheThings_Addtocartbutton6 = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private By SL_Bp_removeproduct6 = By.id("remove-test.allthethings()-t-shirt-(red)");

    // Footer Items
    private By Linkedin_icon = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a");
    private By Facbook_icon = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a");
    private By X_icon = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a");

    // Constructor
    public Products(WebDriver driver) {
        this.driver = driver;
    }

    // Logout Method (مطلوبة في FilterTest)
    public void logout() {
        driver.findElement(burger_menu).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logout));
        driver.findElement(logout).click();
    }

    // Filter Methods (مطلوبة في FilterTest)
    public void applyFilterAtoZ() {
        driver.findElement(Product_Sort).click();
        driver.findElement(filter_a_z).click();
    }

    public void applyFilterZtoA() {
        driver.findElement(Product_Sort).click();
        driver.findElement(filter_z_a).click();
    }

    public void applyFilterLowToHigh() {
        driver.findElement(Product_Sort).click();
        driver.findElement(filter_low_high).click();
    }

    public void applyFilterHighToLow() {
        driver.findElement(Product_Sort).click();
        driver.findElement(filter_high_low).click();
    }

    // Product Name and Price Methods (مطلوبة في FilterTest)
    public List<String> getAllProductNames() {
        List<WebElement> productElements = driver.findElements(By.className("inventory_item_name"));
        return productElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<Double> getAllProductPrices() {
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        return priceElements.stream()
                .map(element -> element.getText().replace("$", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    // Other Methods
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
        clickElement(burger_menu);
    }

    public void clickLogoutButton() {
        clickElement(logout);
    }
}