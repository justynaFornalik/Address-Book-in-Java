package controller;

import dao.AddressDao;
import dao.AddressDaoSQLite;
import model.Address;
import view.RootView;

import java.sql.SQLException;

public class AddressBookController {

    private RootView rootView = new RootView();
    private AddressDao addressDao = new AddressDaoSQLite();

    void showAddresses() {
        try {
            for (Address address : addressDao.selectFullAddresses()) {
                rootView.printMsg(address.getFullAddres());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insertAddress() {
        Address addressToInsert = rootView.getAddressInput();
        int result = 0;
        try {
            result = addressDao.insertAddress(addressToInsert);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String status = result > 0 ? "Address inserted" : "Address not inserted" ;
        rootView.printMsg(status);
    }

    void showAddressesByInput() {
        String input = rootView.getInput("Enter the phrase: ");
        try {
            for(Address address: addressDao.findAddress(input)) {
                rootView.printMsg(address.getFullAddres());
            }
            } catch (SQLException e) {
            e.printStackTrace();
        }

        }
    }
