package ua.stqa.training.selenium.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.stqa.training.selenium.model.Country;
import ua.stqa.training.selenium.model.Zone;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by amalinkovskiy on 6/17/2017.
 */
public class TestBase {
    protected WebDriver driver;
    public List<WebElement> submenuItems;
    public WebElement element;
    public WebElement subElement;
    public List<WebElement> menuItems;
    private WebDriverWait wait;

    @Before
    public void start() {

//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
//        driver = new InternetExplorerDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);


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

    public List<Country> getCountriesList() {
        driver.findElement(By.cssSelector("ul#box-apps-menu a[href*='app=countries&doc=countries'")).click();
        List<WebElement> rows = driver.findElements(By.cssSelector("form[name='countries_form'] tr.row"));
        List<Country> countries = new ArrayList<Country>();
        for (WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            Country country = new Country();
            country.setId(Integer.parseInt(cells.get(2).getText()));
            country.setName(cells.get(4).getText());
            country.setZones(Integer.parseInt(cells.get(5).getText()));
            if (country.getZones() > 0) {
                country.setLink(cells.get(4).findElement(By.cssSelector("a")).getAttribute("href"));
            }
            countries.add(country);
        }
        return countries;
    }

    public boolean alphabetZonesSorted(List<Country> conutries) {
        boolean sorted = true;

        for (Country country : conutries){

            if (country.getZones() >0) {

                driver.get(country.getLink());
                List<WebElement> rows = driver.findElements(By.cssSelector("table#table-zones tr:not(.header)"));
                rows.remove(rows.size() - 1);
                Zone zone = new Zone();
                List<Zone> zones = new ArrayList<Zone>();


                for (WebElement row : rows) {
                    List<WebElement> cells = row.findElements(By.tagName("td"));
                    zone.setId(Integer.parseInt(cells.get(0).getText()));
                    zone.setName(cells.get(2).getText());
                    zones.add(zone);
                }
                List<Zone> sortedZones = zones.stream()
                        .sorted((z1, z2) -> z1.getName().compareTo(z2.getName())).collect(Collectors.toList());
                if (! sortedZones.equals(zones)){
                    sorted =false;
                }

            }

        }

        return sorted;
    }

    protected void goToGeoZones() {
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    }

    protected List<Country> getCountriesInGeo() {
        List<WebElement> rows = driver.findElements(By.cssSelector("table.dataTable tr.row"));
        List<Country> countries = new ArrayList<Country>();

        for (WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            Country country = new Country();
            country.setId(Integer.parseInt(cells.get(1).getText()));
            country.setName(cells.get(2).getText());
            country.setLink(cells.get(2).findElement(By.cssSelector("a")).getAttribute("href"));
            countries.add(country);
        }
        return countries;
    }

    protected boolean checkZonesSortedForCountriesInGeo(List<Country> countries) {
        boolean sorted = true;
        for (Country country : countries){
            driver.get(country.getLink());
            List<WebElement> rows = driver.findElements(By.cssSelector("table#table-zones tr:not(.header)"));
            rows.remove(rows.size() - 1);
            List<Zone> zones = new ArrayList<Zone>();
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                Zone zone = new Zone();
                zone.setId(Integer.parseInt(cells.get(0).getText()));
                zone.setName(cells.get(2).findElement(By.cssSelector("select option:checked")).getText());
                zones.add(zone);
            }
            List<Zone> sortedZones = zones.stream()
                    .sorted((z1, z2) -> z1.getName().compareTo(z2.getName())).collect(Collectors.toList());
            if (! sortedZones.equals(zones)){
                sorted =false;
            }
        }
        return sorted;
    }

    protected boolean verifyColor(String locator, String targetColor, List<WebElement> products) {

        String color = products.get(0).findElement(By.cssSelector(locator))
                .getCssValue("color");
        int r = Color.fromString(color).getColor().getRed();
        int g = Color.fromString(color).getColor().getBlue();
        int b = Color.fromString(color).getColor().getGreen();

        if (targetColor.equals("grey")){
            return r==g && r==b;
        }

        if (targetColor.equals("red")){
            return r>0 && g==0 && b==0;
        }
        return false;
    }

    protected boolean verifyColor(String locator, String targetColor) {

        String color = driver.findElement(By.cssSelector(locator))
                .getCssValue("color");
        int r = Color.fromString(color).getColor().getRed();
        int g = Color.fromString(color).getColor().getBlue();
        int b = Color.fromString(color).getColor().getGreen();

        if (targetColor.equals("grey")){
            return r==g && r==b;
        }

        if (targetColor.equals("red")){
            return r>0 && g==0 && b==0;
        }
        return false;
    }

    public ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows){
        return new ExpectedCondition<String>(){
            public String apply(WebDriver driver){
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() >  0 ? handles.iterator().next(): null;
            }
        };
    }
}
