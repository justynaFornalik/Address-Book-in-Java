package controller;

import view.RootView;

public class RootController {

    private RootView rootView = new RootView();
    private AddressBookController addressBookController =  new AddressBookController();

    public void start () {

        String option = "";

        while (!option.equals("0")) {

            rootView.printMenu();
            option = rootView.getInput("Enter option: ");

            switch (option) {
                case "1":
                    addressBookController.insertAddress();
                    break;
                case "2":
                    addressBookController.showAddressesByInput();
                    break;
                case "3":
                    addressBookController.showAddresses();
                    break;
            }
        }
    }

}
