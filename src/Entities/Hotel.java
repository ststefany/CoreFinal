package Entities;

import DAOpackage.DAOHotels;
import Exceptions.*;

import java.util.*;
import java.util.stream.Collectors;

public class Hotel {
    private Set<Room> rooms = new HashSet<>();
    private String name;
    private String city;
    private long id;



    public Hotel(Set<Room> rooms, String name, String city) throws NonValidDataException {
        if (rooms.isEmpty() || name ==null || city == null) throw new NonValidDataException();
        this.rooms = rooms;
        this.name = name;
        this.city = city;
        this.id = Math.round((Math.random())*10013);
        DAOHotels.save(this);
    }

    public Hotel(String name, String city) throws NonValidDataException {
        if (name ==null || city == null) throw new NonValidDataException();
        this.name = name;
        this.city = city;
        DAOHotels.save(this);
    }

    public Room findRoom (long id) {
        List list = rooms.stream().filter(r -> r.getId()==id).collect(Collectors.toList());
        if (list.size()!=1) throw new DataBaseException();
        else
            return (Room) list.get(0);
    }


    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public long getId() {
        return id;
    }

}
