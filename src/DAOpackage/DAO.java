package DAOpackage;

import Entities.*;
import java.lang.reflect.*;
import Exceptions.NonValidDataException;
import Exceptions.WrongUserException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DAO<T> implements AbstractDAO<T> {
    private static DAO database = new DAO();
    private static DAOHotels hotels = new DAOHotels();
    private static DAOUsers users = new DAOUsers();
    private static DAORooms rooms = new DAORooms();
    private Room ;


    private DAO() {
    }

    public static AbstractDAO getData() {
        return database;
    }


    public static void bookRoom(long roomId, long userId, long hotelId) {
        if (checkData(roomId, userId, hotelId)) {
            Room room = DAOHotels.findHotelbyID(hotelId).findRoom(roomId);
            if (room.isFree()) room.setUserReserved(DAOUsers.findUserByID(userId));
            else System.err.println("Room is already booked");
        }
    }

    public static void cancelReservation(long roomId, long userId, long hotelId) {
        if (checkData(roomId, userId, hotelId)) {
            Room room = DAOHotels.findHotelbyID(hotelId).findRoom(roomId);
            if (!room.isFree()) {
                room.setUserReserved(null);
                System.out.println("Reservation cancelled");
            } else System.err.println("Room is free");
        }

    }
    public Collection<Hotel> findRoom(Map<String, String> params) {
    Set<Hotel> hotels = new HashSet<>();
    Class clazz = Room.class;
    Field field;
    boolean fits = false;
            try {for (Map.Entry<Room, Hotel> roomEntry : rooms.getAllRooms().entrySet()) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                field = clazz.getDeclaredField(entry.getKey());
                if ()
                }
    }}
    catch (Exception e) {}
    }



    private static boolean checkData(long roomId, long userId, long hotelId) {
        boolean checked = false;
        Room room = null;
        try {
            User user = DAOUsers.findUserByID(userId);
            if (user == null || !user.isCurrent()) throw new WrongUserException();
            else {
                room = DAOHotels.findHotelbyID(hotelId).findRoom(roomId);
                if (room == null) throw new NonValidDataException();
                else checked = true;
            }
        } catch (WrongUserException e) {
            System.err.println("Change current user");
        } catch (NonValidDataException e) {
            System.err.println("Entered data has a mistake");
        }
        return checked;
    }

}
