package model;

public class WorkAddress extends Address {
    private String companyName;

    WorkAddress(String person, String city, String street, String houseNo, String companyName){
        super(person, city, street, houseNo);
        this.companyName = companyName;
    }

    @Override
    public String getFullAddres() {
        return super.getFullAddres()+" "+companyName;
    }

}
