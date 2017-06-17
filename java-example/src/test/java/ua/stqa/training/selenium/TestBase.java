package ua.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by amalinkovskiy on 6/17/2017.
 */
public class TestBase {
    protected WebDriver driver;
    List<WebElement> submenuItems;
    WebElement element;
    WebElement subElement;
    List<WebElement> menuItems;
    private WebDriverWait wait;

    @Before
    public void start() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);


    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    public boolean isElementPresent(By locator){
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    protected void loginAdmin() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }



    public List<WebElement> getSubmenuItems(int i) {
        menuItems = driver.findElements(By.cssSelector("ul#box-apps-menu li#app-"));
        element = menuItems.get(i);
        return element.findElements(By.cssSelector("ul.docs a[href*='?app=']"));
    }
}
