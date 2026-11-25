package entities;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    String id;
    String name;
    City city;
    List<Screen> screenList;

    public Theatre(String id, String name, City city, List<Screen> screenList) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.screenList = screenList;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }
}
