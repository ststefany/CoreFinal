package Entities;

import DAOpackage.DAORooms;
import Exceptions.DataBaseException;
import Exceptions.NonValidDataException;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Random;

public class Room {
    private long id;
    private int people;
    private Hotel hotel;
    private User userReserved;
    private String city;
    private int price;
    private static Random random = new Random();

    public Hotel getHotel() {
        return hotel;
    }

    public Room(int people, int price, Hotel hotel) throws NonValidDataException {
        if (people == 0 || hotel == null || price == 0) throw new NonValidDataException();
        this.people = people;
        this.hotel = hotel;
        this.price = price;
        this.userReserved = null;
        this.city = hotel.getCity();
        this.id = random.nextLong();
        DAORooms.save(this);
        System.out.println(hotel + " " + city + " " + "" + people + " " + id);

    }

    public boolean isFree() {
        if (userReserved == null)
            return true;
        return false;
    }

    private Field findFieldWithName(String name) throws NonValidDataException, DataBaseException {
        if (name == null) throw new NonValidDataException();
        for (Field field : Room.class.getDeclaredFields()) {
            if (name.equals(field.getName()))
                return field;
        }
        throw new DataBaseException();
    }

    public boolean doesFit(Map<String, String> params) {
        boolean fits = false;
        for (String param : params.keySet()) {
            try {
                Field field = this.findFieldWithName(param);
                if (field.get(this).equals(params.get(param)))
                    fits = true;
                else break;
            } catch (NonValidDataException e) {
                System.err.println("Entered parameters are not valid. Try with different parameneters");
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                System.err.println("Problem with access to the data");
                e.printStackTrace();
            }
        }
        return fits;
    }


    public long getId() {
        return id;
    }

    public User getUserReserved() {
        return userReserved;
    }

    public void setUserReserved(User userReserved) {
        this.userReserved = userReserved;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;

        Room room = (Room) o;

        if (getId() != room.getId()) return false;
        return getHotel().equals(room.getHotel());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getHotel().hashCode();
        return result;
    }


}
