package ua.stqa.training.selenium.model;

/**
 * Created by amalinkovskiy on 6/19/2017.
 */
public class Country {
    private int id;
    private String Name;
    private String Link;
    private int Zones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public void setZones(int zones) {
        Zones = zones;
    }

    public int getZones() {
        return Zones;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Link='" + Link + '\'' +
                ", Zones=" + Zones +
                '}';
    }

}
