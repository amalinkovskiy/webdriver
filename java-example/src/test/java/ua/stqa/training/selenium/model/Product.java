package ua.stqa.training.selenium.model;

/**
 * Created by amalinkovskiy on 6/21/2017.
 */
public class Product {
    private String name;
    private String price;
    private String promoPrice;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(String promoPrice) {
        this.promoPrice = promoPrice;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", promoPrice='" + promoPrice + '\'' +
                '}';
    }
}
