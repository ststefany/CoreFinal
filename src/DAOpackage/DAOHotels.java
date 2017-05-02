package DAOpackage;

import Entities.*;
import Exceptions.DataBaseException;

import java.util.stream.*;
import java.util.*;
import java.util.Set;

public class DAOHotels implements AbstractDAO{

    static private Set<Hotel> allHotels = new HashSet<>();


    public static void save(Hotel hotel) {
        if (hotel!= null) allHotels.add(hotel);
    }

    public static Set<Hotel> findHotelbyName (String name) {
        Set<Hotel> set = allHotels.stream().filter(h -> h.getName().equals(name)).collect(Collectors.toSet());
        if (set.isEmpty()) {
            System.out.println("No matches found");
            return null;
        }
        else return set;
    }

    public static Set<Hotel> findHotelbyCity (String city) {
        Set<Hotel> set = allHotels.stream().filter(h -> h.getCity().equals(city)).collect(Collectors.toSet());
        if (set.isEmpty()) {
            System.out.println("No matches found");
            return null;
        }
        else return set;
    }

    public static Hotel findHotelbyID (long id) {
        List<Hotel> list = allHotels.stream().filter(h -> h.getId()==id).collect(Collectors.toList());
        if (list.size()>1) { System.err.println("Database error"); throw new DataBaseException();}
        else return list.get(0);
    }
}
