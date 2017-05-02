package Entities;

import Exceptions.NonValidDataException;

public class Room {
    long id;
    int people;
    Hotel hotel;
    User userReserved;

    public Room(int people, Hotel hotel) throws NonValidDataException {
        this.id = Math.round(Math.random()*1010);
        if (people == 0 || hotel == null) throw new NonValidDataException();
        this.people = people;
        this.hotel = hotel;
        this.userReserved = null;
    }

    boolean isFree() {
        if (userReserved==null)
            return true;
        else return false;
    }

    public long getId() {
        return id;
    }
}
