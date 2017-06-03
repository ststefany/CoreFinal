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
    private static Random random = new Random();




    public Hotel(Set<Room> rooms, String name, String city) throws NonValidDataException {
        if (rooms.isEmpty() || name ==null || city == null) throw new NonValidDataException();
        this.rooms = rooms;
        this.name = name;
        this.city = city;
        this.id = random.nextLong();
        DAOHotels.save(this);
        System.out.println(name + " " + city + " " + id);
    }

    public Hotel(String name, String city) throws NonValidDataException {
        if (name ==null || city == null) throw new NonValidDataException();
        this.name = name;
        this.city = city;
        this.id = random.nextLong();
        DAOHotels.save(this);
    }

    public Room findRoom (long id) {
        List<Room> list = rooms.stream().filter((Room r) -> (r.getId()==id)).collect(Collectors.toList());
        System.out.println(list);
        if (list.size()>1) throw new DataBaseException();
        if (list.size()<1) return null;
        return list.get(0);
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

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", id=" + id +
                '}';
    }
}
