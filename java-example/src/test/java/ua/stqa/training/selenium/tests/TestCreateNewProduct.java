package ua.stqa.training.selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by amalinkovskiy on 6/22/2017.
 */
public class TestCreateNewProduct extends TestBase{
    @Test
    public void createNewProduct(){
        loginAdmin();
        driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=catalog']")).click();
        driver.findElement(By.cssSelector
                ("a[href='http://localhost/litecart/admin/?category_id=0&app=catalog&doc=edit_product']")).click();

        driver.findElement(By.cssSelector("input[value='1']")).click();

        Long now = System.currentTimeMillis();
        String name = String.format("Duck%s", now);

        driver.findElement(By.cssSelector("input[name='name[en]']")).sendKeys(name);
        driver.findElement(By.cssSelector("input[name='code']")).sendKeys("code");
        driver.findElement(By.cssSelector("input[name='categories[]'][data-name='Rubber Ducks']")).click();
        driver.findElement(By.cssSelector("input[name='product_groups[]'][value='1-3']")).click();
        driver.findElement(By.cssSelector("input[name='quantity']")).clear();
        driver.findElement(By.cssSelector("input[name='quantity']")).sendKeys("1");



        File photo = new File("src/test/resources/duck_product.png");

        driver.findElement(By.cssSelector("input[name='new_images[]']")).sendKeys(photo.getAbsolutePath());
        driver.findElement(By.cssSelector("input[name='date_valid_from']")).sendKeys("10/11/2000");
        driver.findElement(By.cssSelector("input[name='date_valid_to']")).sendKeys("01/01/2018");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(presenceOfElementLocated(By.cssSelector("a[href='#tab-information']"))).click();


        WebElement element = driver.findElement(By.cssSelector("select[name='manufacturer_id']"));
        Select manufacturerSelect = new Select(element);
        manufacturerSelect.selectByVisibleText("ACME Corp.");

        driver.findElement(By.cssSelector("input[name='keywords']")).sendKeys("keyword");
        driver.findElement(By.cssSelector("input[name='short_description[en]']")).sendKeys("short description");
        driver.findElement(By.cssSelector("div.trumbowyg-editor")).sendKeys("description");
        driver.findElement(By.cssSelector("input[name='head_title[en]']")).sendKeys("head title");
        driver.findElement(By.cssSelector("input[name='meta_description[en]']")).sendKeys("meta description");

        wait.until(presenceOfElementLocated(By.cssSelector("a[href='#tab-prices']"))).click();
        driver.findElement(By.cssSelector("input[name='purchase_price']")).clear();
        driver.findElement(By.cssSelector("input[name='purchase_price']")).sendKeys("12");

        WebElement currency = driver.findElement(By.cssSelector("select[name='purchase_price_currency_code']"));
        Select currencySelect = new Select(currency);
        currencySelect.selectByVisibleText("US Dollars");

        driver.findElement(By.cssSelector("input[name='prices[USD]']")).clear();
        driver.findElement(By.cssSelector("input[name='prices[USD]']")).sendKeys("14");

        driver.findElement(By.cssSelector("button[name='save']")).click();

        List<WebElement> mainProducts = driver.findElements(
                By.cssSelector("a[href*='?app=catalog&doc=edit_product&category_id=0&product_id=']"));

        boolean productFound = false;
        for (WebElement product: mainProducts) {

            if (name.equals(product.getText())){
                productFound = true;
            }

        }

        Assert.assertTrue(productFound);

    }
}
