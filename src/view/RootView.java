package view;

import model.Address;

import java.util.Scanner;

public class RootView {

    public void printMenu() {
        System.out.println();
        System.out.println("(1) Add a new address\n"
                + "(2) Search for an address\n"
                + "(3) List the addresses\n"
                + "(0) Exit");
        System.out.println();
    }

    public String getInput(String msg){

        System.out.println();
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println();
        return input;
    }

    public void printMsg(String msg){
        System.out.println(msg);
    }


    public Address getAddressInput(){

        String person = getInput("Enter full name: ");
        String city = getInput("Enter city: ");
        String street = getInput( "Enter street: ");
        String houseNo = getInput( "Enter house number: ");

        return new Address(person, city, street, houseNo);
    }
}

