package DAOpackage;

import Entities.Hotel;
import Exceptions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DAOHotels implements DAOInterface {
    private static final DAOHotels hotels = new DAOHotels();
    private static Set<Hotel> allHotels = new HashSet<>();

    private DAOHotels() {
    }

    static DAOHotels getInstance() {
        return hotels;
    }


    public static void save(Hotel hotel) {
        if (hotel != null) allHotels.add(hotel);
    }


    public static Set<Hotel> findHotelbyName(String name) {
        Set<Hotel> set = allHotels.stream().filter(h -> h.getName().equals(name)).collect(Collectors.toSet());
        if (set.isEmpty()) {
            System.out.println("No matches found");
            return null;
        } else return set;
    }

    public static Set<Hotel> findHotelbyCity(String city) {
        Set<Hotel> set = allHotels.stream().filter(h -> h.getCity().equals(city)).collect(Collectors.toSet());
        if (set.isEmpty()) {
            System.out.println("No matches found");
            return null;
        } else return set;
    }

    public static Hotel findHotelbyID(long id) {
        List<Hotel> list = allHotels.stream().filter((Hotel h) -> (h.getId() == id)).collect(Collectors.toList());
        System.out.println(list);
       if (list.size() != 1) {
           System.err.println("Database error");
           throw new DataBaseException();
        } else
            return list.get(0);
    }

}
