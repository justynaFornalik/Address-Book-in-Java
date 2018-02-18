package model;

public class Address {
    private String person;
    private String city;
    private String street;
    private String houseNo;

    public Address(String person, String city, String street, String houseNo){
        this.person = person;
        this.city = city;
        this.street = street;
        this.houseNo = houseNo;
    }

    public String getFullAddres(){
        return String.format("%s, %s, %s %s", person, city, street, houseNo);
    }

    public String getCity() {
        return city;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public String getPerson() {
        return person;
    }

    public String getStreet() {
        return street;
    }
}