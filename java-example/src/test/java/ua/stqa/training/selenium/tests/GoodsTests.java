package ua.stqa.training.selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.stqa.training.selenium.model.Product;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


import java.util.List;

/**
 * Created by amalinkovskiy on 6/20/2017.
 */
public class GoodsTests extends TestBase{

    @Test
    public void rightPageOpens() {
        driver.get("http://localhost/litecart/en/");

        Product product = new Product();
        List<WebElement> products = driver.findElements(By.cssSelector("div#box-campaigns li.product"));
        product.setName(products.get(0).findElement(By.cssSelector("div.name")).getText());
        product.setPrice(products.get(0).findElement(By.cssSelector("s.regular-price")).getText());
        String decor = products.get(0).findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration");

        Assert.assertTrue(decor.contains("line-through"));
        Assert.assertTrue(verifyColor("s.regular-price", "grey", products));

        String regularSize = products.get(0).findElement(By.cssSelector("s.regular-price")).getCssValue("font-size");
        product.setPromoPrice(products.get(0).findElement(By.cssSelector("strong.campaign-price")).getText());
        String campaignSize = products.get(0).findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-size");

        Assert.assertTrue(verifyColor("strong.campaign-price", "red", products));

        String campaignWeight = products.get(0).findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-weight");

        Assert.assertTrue(campaignWeight.equals("bold") || campaignWeight.equals("700")
                || campaignWeight.equals("800") || campaignWeight.equals("900"));
        Assert.assertTrue(regularSize.compareTo(campaignSize) < 0);

        products.get(0).findElement(By.cssSelector("a.link")).click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        String elementText = wait.until(presenceOfElementLocated(By.cssSelector("div#box-product h1.title"))).getText();

        Assert.assertTrue(elementText.equals(product.getName()));
        Assert.assertTrue(driver.findElement(By.cssSelector("div#box-product s.regular-price"))
                .getText().equals(product.getPrice()));
        Assert.assertTrue(driver.findElement(By.cssSelector("div#box-product strong.campaign-price"))
                .getText().equals(product.getPromoPrice()));
        Assert.assertTrue(verifyColor("div#box-product s.regular-price", "grey"));



        String detailsRegularDecor = driver
                .findElement(By.cssSelector("div#box-product s.regular-price")).getCssValue("text-decoration");

        Assert.assertTrue(detailsRegularDecor.contains("line-through"));

        String detailsRegularSize = driver
                .findElement(By.cssSelector("div#box-product s.regular-price")).getCssValue("font-size");

        Assert.assertTrue(verifyColor("div#box-product strong.campaign-price", "red"));

        String detailsCampaignSize = driver
                .findElement(By.cssSelector("div#box-product strong.campaign-price")).getCssValue("font-size");

        Assert.assertTrue(detailsRegularSize.compareTo(detailsCampaignSize) < 0);

        String detailsCampaignWeight = driver
                .findElement(By.cssSelector("div#box-product strong.campaign-price")).getCssValue("font-weight");

        Assert.assertTrue(detailsCampaignWeight.equals("bold") || detailsCampaignWeight.equals("700")
                || detailsCampaignWeight.equals("800") || detailsCampaignWeight.equals(900));

    }

}
