package ua.stqa.training.selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * Created by amalinkovskiy on 6/26/2017.
 */
public class TestShoppingCart extends TestBase{
    @Test
    public void testShoppingCart(){
        String quantityLocator = "div#cart a.content[href='http://localhost/litecart/en/checkout'] span.quantity";

        for (int i=0; i<3;i++) {
            driver.get("http://localhost/litecart/en/");
            List<WebElement> products = driver.findElements(By.cssSelector("div#box-most-popular li.product"));
            products.get(0).click();
            WebElement cartQuantity = driver.findElement(By.cssSelector(quantityLocator));
            String quantity = cartQuantity.getText();

            if (isElementPresent(By.cssSelector("select[name='options[Size]']"))){
                Select productSize = new Select(driver.findElement(By.cssSelector("select[name='options[Size]']")));
                productSize.selectByIndex(1);
            }
            driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until((WebDriver d) -> (!d.findElement(By.cssSelector(quantityLocator)).getText().equals(quantity)));
        }

        Assert.assertTrue(driver.findElement(By.cssSelector(quantityLocator)).getText().equals("3"));

        driver.findElement(By.cssSelector("div#cart a.link[href='http://localhost/litecart/en/checkout']")).click();
        String iconsLocator = "div#checkout-cart-wrapper li.shortcut";
        List<WebElement> icons = driver.findElements(By.cssSelector(iconsLocator));

        for (int i=0; i<icons.size(); i++) {
            driver.findElement(By.cssSelector("button[name='remove_cart_item']")).click();
            WebDriverWait wait = new WebDriverWait(driver, 30);
            List<WebElement> finalIcons = icons;
            wait.until((WebDriver d) -> (d.findElements(By.cssSelector(iconsLocator)).size() != finalIcons.size()));
            icons = driver.findElements(By.cssSelector(iconsLocator));
        }
        Assert.assertTrue(driver.findElements(By.cssSelector(iconsLocator)).size() == 0);
    }
}
