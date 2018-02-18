package dao;

import model.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {
    List<Address> selectFullAddresses() throws SQLException;
    int insertAddress(Address address) throws SQLException;
    List<Address> findAddress(String input) throws SQLException;
}
