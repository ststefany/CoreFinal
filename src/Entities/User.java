package Entities;

import java.util.*;

public class User {
    private long id;
    private String login;
    private String password;
    private Set<Room> reservedRooms = new HashSet<>();
    private static Random random = new Random();


    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.id = random.nextLong();
        System.out.println(login + " " + id);
    }

    public long getId() {
        return id;
    }

    public void addReservedRoom (Room room) {
        this.reservedRooms.add(room);
    }

    public void removeReservedRoom (Room room) {
        this.reservedRooms.remove(room);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    public boolean isCurrent() {
        if (this == null || !this.equals(CurrentUser.getCurrentUser())) return false;
        return true;
    }
}
