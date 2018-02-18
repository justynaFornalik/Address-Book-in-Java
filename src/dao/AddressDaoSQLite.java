package dao;

import model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoSQLite implements AddressDao {

    private Connection connection;

    public AddressDaoSQLite(){
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        connection = dbConnection.getConnection();

    }



    private List<Address> fillAddressList(ResultSet resultSet) throws SQLException {
        List<Address> addresses = new ArrayList<>();

        while (resultSet.next()) {
            String person = resultSet.getString("person");
            String city = resultSet.getString("city");
            String street = resultSet.getString("street");
            String houseNo = resultSet.getString("house_no");

            Address newAddress = new Address(person, city, street, houseNo);
            addresses.add(newAddress);
        }

        return addresses;
    }

    public List<Address> selectFullAddresses() throws SQLException {

        PreparedStatement preparedSelect = connection.prepareStatement("SELECT * FROM addresses");
        ResultSet resultSet = preparedSelect.executeQuery();

        return fillAddressList(resultSet);
    }

    public int insertAddress(Address address) throws SQLException {
        PreparedStatement preparedInsert = connection.prepareStatement("INSERT INTO addresses(person, city, street, house_no) VALUES (?,?,?,?)");
        preparedInsert.setString(1, address.getPerson());
        preparedInsert.setString(2,address.getCity());
        preparedInsert.setString(3, address.getStreet());
        preparedInsert.setString(4, address.getHouseNo());

        return preparedInsert.executeUpdate();
    }

    public List<Address> findAddress(String input) throws SQLException {
        PreparedStatement preparedSelect = connection.prepareStatement("SELECT * from addresses WHERE person LIKE ? OR city LIKE ? OR street LIKE ? OR house_no LIKE ?");
        preparedSelect.setString(1, input);
        preparedSelect.setString(2, input);
        preparedSelect.setString(3, input);
        preparedSelect.setString(4, input);

        ResultSet queryResult = preparedSelect.executeQuery();
        return fillAddressList(queryResult);
    }
}

