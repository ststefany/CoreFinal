package Model;
//create and least 2 hotels in 3 unique cities with at least 10 rooms each


import Entities.*;
import Exceptions.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Controller ctrl = new Controller();

        try {
            Hotel hotel = new Hotel("Hilton", "NY");
            Hotel hotel1 = new Hotel("Ritz", "SF");
            Hotel hotel2 = new Hotel("Cococo", "Kyiv");

            Room room = new Room(4, 999, hotel);
            Room room1 = new Room(2, 750, hotel);
            Room room2 = new Room(3, 750, hotel);
            Room room3 = new Room(6, 750, hotel);
            Room room4 = new Room(18, 90750, hotel);
            Room room5 = new Room(1, 750, hotel);
            Room room6 = new Room(1, 999, hotel);
            Room room7 = new Room(4, 999, hotel);
            Room room8 = new Room(3, 111, hotel);
            Room room9 = new Room(2, 999, hotel);


            Room room0 = new Room(4, 750, hotel1);
            Room room01 = new Room(2, 53, hotel1);
            Room room02 = new Room(3, 750, hotel1);
            Room room03 = new Room(6, 750, hotel1);
            Room room04 = new Room(18, 750, hotel1);
            Room room05 = new Room(1, 750, hotel1);
            Room room06 = new Room(1, 76, hotel1);
            Room room07 = new Room(4, 750, hotel1);
            Room room08 = new Room(3, 111, hotel1);
            Room room09 = new Room(2, 999, hotel1);

            Room room00 = new Room(4, 750, hotel2);
            Room room001 = new Room(2, 750, hotel2);
            Room room002 = new Room(3, 750, hotel2);
            Room room003 = new Room(6, 750, hotel2);
            Room room004 = new Room(18, 11750, hotel2);
            Room room005 = new Room(1, 750, hotel2);
            Room room006 = new Room(1, 750, hotel2);
            Room room007 = new Room(4, 750, hotel2);
            Room room008 = new Room(3, 111, hotel2);
            Room room009 = new Room(2, 750, hotel2);


            User user = new User("vova", "football");
            ctrl.registerUser(user);
            CurrentUser.setCurrentUser(user);


            System.out.println(room00.getId() + " " + user.getId() + " " + hotel2.getId());

            ctrl.bookRoom(room00.getId(), user.getId(), hotel2.getId());
            System.out.println(room00.getUserReserved());

            System.out.println(ctrl.findHotelByName("Hilton"));
            System.out.println(ctrl.findHotelbyCity("Kyiv"));
        } catch (NonValidDataException e) {
            e.printStackTrace();
            System.err.println("Can't create an instance with null data");
        }
        Map<String, String> params = new HashMap<>();
        params.put("people", "18");
        params.put("city", "SF");

        try {

            System.out.print(ctrl.findRoom(params));
        } catch (Exception e) {
            System.err.println("wrong");
        }

        params.put("city", "NY");
        try {
            System.out.print(ctrl.findRoom(params));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Can't create an instance with null data");
        }

    }
}
