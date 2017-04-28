package DAOpackage;

import Entities.*;
import Exceptions.NonValidDataException;

import java.util.*;

public class DAO <T> implements AbstractDAO <T> {
    private static DAO database = new DAO();
    static private DAOHotels hotels;
    static private DAOUsers users;

    private DAO() {}



    public static AbstractDAO getData() {
        return database;
    }


    public static void bookRoom (long roomId, long userId, long hotelId) {
        try {
        User user = DAOUsers.findUserByID(userId);
        if (!user.isCurrent()) throw new NonValidDataException();
        else DAOHotels.findHotelbyId()
    }
        catch (
    NonValidDataException e) {
        System.err.println("Wrong user ID");
    }
}}
