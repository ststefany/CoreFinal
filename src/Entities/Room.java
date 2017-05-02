package Entities;

import Exceptions.NonValidDataException;

public class Room {
    private long id;
    private int people;
    private Hotel hotel;
    private User userReserved;

    public Room(int people, Hotel hotel) throws NonValidDataException {
        this.id = Math.round(Math.random()*1010);
        if (people == 0 || hotel == null) throw new NonValidDataException();
        this.people = people;
        this.hotel = hotel;
        this.userReserved = null;
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
