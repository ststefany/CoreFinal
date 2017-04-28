package Entities;

import DAOpackage.DAOHotels;
import Exceptions.NonValidDataException;

import java.util.*;

public class Hotel {
    private Set<Room> rooms = new HashSet<>();
    private String name;
    private String city;

    public Hotel(Set<Room> rooms, String name, String city) throws NonValidDataException{
        if (rooms.isEmpty() || name ==null || city == null) throw new NonValidDataException();
        this.rooms = rooms;
        this.name = name;
        this.city = city;
        DAOHotels.save(this);
    }

    public Hotel(String name, String city) throws NonValidDataException {
        if (name ==null || city == null) throw new NonValidDataException();
        this.name = name;
        this.city = city;
        DAOHotels.save(this);
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
