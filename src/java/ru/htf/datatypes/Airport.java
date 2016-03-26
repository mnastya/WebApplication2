package ru.htf.datatypes;

/**
 *
 * @author chudin_e_v
 */
public class Airport {

    private String name;
    private String shortName;
    private String country;
    private String city;
    private Integer arpId;

    public Airport(String name, String shortName, String country, String city, Integer arpId) {
        this.name = name;
        this.shortName = shortName;
        this.country = country;
        this.city = city;
        this.arpId = arpId;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public Integer getArpId() {
        return arpId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(city);
        sb.append(", ");
        sb.append(name);
        sb.append(" ");
        sb.append(country);
        return sb.toString();
    }

    public String getString() {
        return toString();
    }
}
