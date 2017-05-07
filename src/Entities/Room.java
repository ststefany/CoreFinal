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
        if (people == 0 || hotel == null || price == 0) throw new NonValidDataException();
        this.people = people;
        this.hotel = hotel;
        this.price = price;
        this.userReserved = null;
        this.city = hotel.getCity();
        this.id = Math.round(Math.random() * 10110);
        DAORooms.save(this);
    }

    public boolean isFree() {
        if (userReserved == null)
            return true;
        return false;
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
