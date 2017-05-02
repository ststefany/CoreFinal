package Model;

import DAOpackage.*;
import Entities.*;
import Exceptions.*;
import java.util.*;

public class Controller {

    public void registerUser(String login, String password) {
        try {
            DAOUsers.saveUser(login, password);
        }
        catch (NonValidDataException e) {
            System.err.println("Null value of login or password. Please, try again with correct fields.");
        }
    }

    public Set<Hotel> findHotelByName(String name) {
           return DAOHotels.findHotelbyName(name);
    }

    public Set<Hotel> findHotelbyCity(String city) {
        return DAOHotels.findHotelbyCity(city);
    }

    public void bookRoom(long roomId, long userId, long hotelId) {
        DAO.bookRoom(roomId, userId, hotelId);
    }
}
