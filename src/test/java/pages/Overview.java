package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Overview {
    WebDriver driver;

    public Overview(WebDriver driver) {
        this.driver = driver;
    }
        By finish_button = By.id("finish");
        By cansel_button = By.id("cancel");


    public void Clicking_cansel_button () {
        driver.findElement(cansel_button).click();

    }
    public void Clicking_finish_button () {
        driver.findElement(finish_button).click();

    }






}
/* By chart_icon = By.className("shopping_cart_link");
        By Burger_menu = By.id("react-burger-menu-btn");
        By All_items =By.id("inventory_sidebar_link");
        By About = By.id("about_sidebar_link");
        By logout =By.id("logout_sidebar_link");
        By Reset_App_State =By.id("reset_sidebar_link");
        By Linkedin_icon = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a");
        By Facbook_icon = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a");
        By X_icon =By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a");
           public void Clicking_About (By about) {
        driver.findElement(About).click();

    }
    public void Clicking_All_items (By all_items) {
        driver.findElement(All_items).click();

    }
    public void Clicking_Burger_menu (By burger_menu) {
        driver.findElement(Burger_menu).click();

    }
    public void Clicking_chart_icon  (By chart) {
        driver.findElement(chart_icon).click();

    }
     public void Clicking_logout_button (By logout_a) {
        driver.findElement(logout).click();

    }
    public void Clicking_Reset_App_State (By Reset) {
        driver.findElement(Reset_App_State).click();

    }
    public void Clicking_Linkedin_icon (By Linkedin) {
        driver.findElement(Linkedin_icon).click();

    }
    public void Clicking_Facbook_icon (By Facbook) {
        driver.findElement( Facbook_icon).click();

    }
    public void Clicking_X_icon(By X) {
        driver.findElement(X_icon).click();

    }
*/