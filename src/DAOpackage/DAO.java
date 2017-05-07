package DAOpackage;

import Entities.Room;
import Entities.User;
import Exceptions.NonValidDataException;
import Exceptions.WrongUserException;

public class DAO<T> implements AbstractDAO<T> {
    private static DAO database = new DAO();

    private DAO() {
    }

    public static AbstractDAO getData() {
        return database;
    }


    public static void bookRoom(long roomId, long userId, long hotelId) {
        if (checkData(roomId, userId, hotelId)) {
            User user = DAOUsers.findUserByID(userId);
            Room room = DAOHotels.findHotelbyID(hotelId).findRoom(roomId);
            if (room.isFree()) {
                room.setUserReserved(user);
                user.addReservedRoom(room);
            } else System.err.println("Room is already booked");
        }
    }

    public static void cancelReservation(long roomId, long userId, long hotelId) {
        if (checkData(roomId, userId, hotelId)) {
            Room room = DAOHotels.findHotelbyID(hotelId).findRoom(roomId);
            User user = DAOUsers.findUserByID(userId);
            if (!room.isFree()) {
                room.setUserReserved(null);
                user.removeReservedRoom(room);
                System.out.println("Reservation cancelled");
            } else System.err.println("Room is free");
        }

    }


    private static boolean checkData(long roomId, long userId, long hotelId) {
        boolean checked = false;
        Room room = null;
        try {
            User user = DAOUsers.findUserByID(userId);
            if (!user.isCurrent()) throw new WrongUserException();
            room = DAOHotels.findHotelbyID(hotelId).findRoom(roomId);
            if (room == null) throw new NonValidDataException();
            else checked = true;
        } catch (WrongUserException e) {
            System.err.println("Change current user");
        } catch (NonValidDataException e) {
            System.err.println("Entered data contains a mistake");
        }
        return checked;
    }

}
