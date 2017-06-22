package ua.stqa.training.selenium.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ua.stqa.training.selenium.model.Customer;

/**
 * Created by amalinkovskiy on 6/22/2017.
 */
public class TestRegisterCustomer extends TestBase{
    @Test
    public void registerNewCustomer(){
        driver.get("http://localhost/litecart/en/create_account");
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Kolpstoff");
        customer.setAddress1("Wall st. 5086");
        customer.setPostcode("12345");
        customer.setCity("new York");
        customer.setCountry("United States");
        Long now = System.currentTimeMillis();
        String email = String.format("user1%s@localhost", now);
        customer.setEmail(email);
        customer.setPhone("04445566");
        customer.setPassword("ForTheBestSecurity7^5");

        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(customer.getFirstName());
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(customer.getLastName());
        driver.findElement(By.cssSelector("input[name='address1']")).sendKeys(customer.getAddress1());
        driver.findElement(By.cssSelector("input[name='postcode']")).sendKeys(customer.getPostcode());
        driver.findElement(By.cssSelector("input[name='city']")).sendKeys(customer.getCity());
        WebElement element = driver.findElement(By.cssSelector("select[name='country_code']"));
        Select countrySelect = new Select(element);
        countrySelect.selectByVisibleText("Uganda");

//        WebElement zoneElement = driver.findElement(By.cssSelector("select[name='zone_code']"));
//        Select zoneSelect = new Select(zoneElement);
//        zoneSelect.selectByVisibleText("Alabama");

        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(customer.getEmail());
        driver.findElement(By.cssSelector("input[name='phone']")).clear();
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys(customer.getPhone());
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(customer.getPassword());
        driver.findElement(By.cssSelector("input[name='confirmed_password']")).sendKeys(customer.getPassword());

        driver.findElement(By.cssSelector("button[name='create_account']")).click();


    }


}
