package ua.stqa.training.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by amalinkovskiy on 6/7/2017.
 */
public class MyFirstTest {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);


    }

@Test
public void myFirstTest(){
    driver.get("http://www.google.com");
    driver.findElement(By.name("q")).sendKeys("hello webdriver");
    WebElement btnG = driver.findElement(By.name("btnG"));
    btnG.click();
}

    @Test
    public void loginToLiteCartAdmin() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();


        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=appearance&doc=template'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Template"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=appearance&doc=logotype'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Logotype"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=catalog&doc=catalog'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Catalog"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=catalog&doc=product_groups'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Product Groups"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=catalog&doc=option_groups'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Option Groups"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=catalog&doc=manufacturers'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Manufacturers"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=catalog&doc=suppliers'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Suppliers"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=catalog&doc=delivery_statuses'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Delivery Statuses"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=catalog&doc=sold_out_statuses'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Sold Out Statuses"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=catalog&doc=quantity_units'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Quantity Units"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=catalog&doc=csv'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("CSV Import/Export"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=countries&doc=countries'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Countries"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=currencies&doc=currencies'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Currencies"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=customers&doc=customers'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Customers"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=customers&doc=csv'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("CSV Import/Export"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=customers&doc=newsletter'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Newsletter"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=geo_zones&doc=geo_zones'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Geo Zones"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=languages&doc=languages'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Languages"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=languages&doc=storage_encoding'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Storage Encoding"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=modules&doc=jobs'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Job Modules"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=modules&doc=customer'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Customer Modules"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=modules&doc=shipping'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Shipping Modules"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=modules&doc=payment'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Payment Modules"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=modules&doc=order_total'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Order Total Modules"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=modules&doc=order_success'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Order Success Modules"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=modules&doc=order_action'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Order Action Modules"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=orders&doc=orders'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Orders"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=orders&doc=order_statuses'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Order Statuses"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=pages&doc=pages'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Pages"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=reports&doc=monthly_sales'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Monthly Sales"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=reports&doc=most_sold_products'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Most Sold Products"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=reports&doc=most_shopping_customers'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Most Shopping Customers"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=settings&doc=store_info'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Settings"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=settings&doc=defaults'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Settings"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=settings&doc=general'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Settings"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=settings&doc=listings'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Settings"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=settings&doc=images'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Settings"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=settings&doc=checkout'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Settings"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=settings&doc=advanced'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Settings"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=settings&doc=security'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Settings"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=slides&doc=slides'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Slides"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=tax&doc=tax_classes'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Tax Classes"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=tax&doc=tax_rates'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Tax Rates"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=translations&doc=search'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Search Translations"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=translations&doc=scan'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Scan Files For Translations"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=translations&doc=csv'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("CSV Import/Export"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=users&doc=users'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("Users"));
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=vqmods&doc=vqmods'")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("td#content h1")).getText().equals("vQmods"));


    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}

