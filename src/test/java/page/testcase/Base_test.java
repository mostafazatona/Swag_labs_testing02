package page.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base_test {
    WebDriver base_driver;
@BeforeTest
public void beforecless(){
base_driver=new FirefoxDriver();
    base_driver.get("https://www.saucedemo.com/");

}

@AfterTest
public void methodName() {
base_driver.quit();

}


}