package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        WebDriver driver2 = new FirefoxDriver();
        driver2.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> inputWebElements=driver2.findElements(By.cssSelector("#checkboxes > input[type=checkbox]"));
        boolean t;
        System.out.println(inputWebElements.size());
        t =inputWebElements.get(1).isSelected();
System.out.println (t);


       /*
        driver2.findElement(By.id("user-name")).sendKeys("standard_user");
        driver2.findElement(By.id("password")).sendKeys("secret_sauce");
        driver2.findElement(By.id("login-button")).click();
        driver2.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver2.findElement(By.className("shopping_cart_link")).click();
        driver2.findElement(By.id("checkout")).click();
        driver2.findElement(By.id("first-name")).sendKeys("mostafa");
        driver2.findElement(By.id("last-name")).sendKeys("waled");
        driver2.findElement(By.id("postal-code")).sendKeys("12563");
        driver2.findElement(By.id("continue")).click();
        driver2.findElement(By.id("finish")).click();
        driver2.findElement(By.id("back-to-products")).click();*/

      /*driver2.manage().window().maximize();
        driver2.get("https://seleniumbase.io/demo_page");
        driver2.findElement(By.id("myTextInput")).sendKeys("First Input ");
        driver2.findElement(By.id("myTextInput2")).clear();
        driver2.findElement(By.id("myTextInput2")).sendKeys("second Input ");
        driver2.findElement(By.id("placeholderText")).sendKeys("3 ");
        driver2.findElement(By.id("svgRect")).click();
        driver2.findElement(By.id("myTextarea")).sendKeys("october");
        driver2.findElement(By.id("myButton")).click();
        driver2.findElement(By.id("radioButton2")).click();
        driver2.findElement(By.id("checkBox2")).click();
        driver2.findElement(By.id("checkBox3")).click();
        driver2.findElement(By.id("checkBox4")).click();
        driver2.findElement(By.id("myLink1")).click();
        String web1=driver2.getTitle();
        System.out.println(web1);
        driver2.navigate().back();
        driver2.findElement(By.id("myLink2")).click();
        String web2=driver2.getTitle();
        System.out.println(web2);
        driver2.navigate().back();
        driver2.findElement(By.id("myLink3")).click();
        String web3=driver2.getTitle();
        System.out.println(web3);
        driver2.navigate().back();
        // need to take screen shot for the inactive link
        //driver2.findElement(By.id("myLink4")).
        driver2.findElement(By.id("mySelect")).isSelected();
        driver2.switchTo().frame("myFrame3");
        driver2.findElement(By.id("checkBox6")).click();
   System.out.println(driver2.getWindowHandles());





       WebDriver driver2 = new FirefoxDriver();
        driver2.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> inputWebElements=driver2.findElements(By.cssSelector("#checkboxes > input[type=checkbox]"));
        boolean t;
        System.out.println(inputWebElements.size());
        t =inputWebElements.get(1).isSelected();
System.out.println (t);
*/
       







    }
}