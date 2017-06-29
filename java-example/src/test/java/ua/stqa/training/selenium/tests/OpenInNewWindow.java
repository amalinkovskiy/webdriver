package ua.stqa.training.selenium.tests;

import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by amalinkovskiy on 6/27/2017.
 */
public class OpenInNewWindow extends TestBase{

    @Test
    public void testOpenInNewWindow(){
        loginAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        String mainWindow = driver.getWindowHandle();
        Set<String> oldWindows = driver.getWindowHandles();
        driver.findElement(By.cssSelector("a[href*='doc=edit_country&country_code=AF']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement form = wait.until(presenceOfElementLocated(By.cssSelector("form[method='post']")));


        List<WebElement> links = form.findElements(By.cssSelector("a[target='_blank']"));
        for (WebElement link:links) {

            link.click();
            String newWindow = wait.until(anyWindowOtherThan(oldWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);

        }

    }

}
