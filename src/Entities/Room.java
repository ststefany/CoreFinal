package Entities;

import DAOpackage.*;
import Exceptions.NonValidDataException;

public class Room {
    private long id;
    private int people;
    private Hotel hotel;
    private User userReserved;
    private String city;
    private int price;

    public Hotel getHotel() {
        return hotel;
    }

    public Room(int people, int price, Hotel hotel) throws NonValidDataException {
        this.id = Math.round(Math.random()*1010);
        if (people == 0 || hotel == null || price == 0) throw new NonValidDataException();
        this.people = people;
        this.hotel = hotel;
        this.price = price;
        this.userReserved = null;
        this.city = hotel.getCity();
        DAORooms.save(this);
    }

    public boolean isFree() {
        if (userReserved==null)
            return true;
        else return false;
    }

    public long getId() {
        return id;
    }



    public void setUserReserved(User userReserved) {
        this.userReserved = userReserved;
    }
}
