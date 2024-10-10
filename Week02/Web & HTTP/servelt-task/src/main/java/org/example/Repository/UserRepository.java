package org.example.Repository;
import org.example.Models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class UserRepository {
    static List<User> users = new ArrayList<>();
    static  {
        users.add(new User(1, "John Doe", 30, "a7med3del1973@gmail.com", "password123"));
        users.add(new User(2, "Jane Smith", 25, "jane.smith@example.com", "password456"));
        users.add(new User(3, "Alice Johnson", 28, "alice.johnson@example.com", "password789"));
        users.add(new User(4, "Bob Brown", 32, "bob.brown@example.com", "password101"));
        users.add(new User(5, "Charlie Davis", 27, "charlie.davis@example.com", "password202"));
        users.add(new User(6, "Emily Evans", 24, "emily.evans@example.com", "password303"));
        users.add(new User(7, "Frank Harris", 35, "frank.harris@example.com", "password404"));
        users.add(new User(8, "Grace Lee", 29, "grace.lee@example.com", "password505"));
        users.add(new User(9, "Henry Clark", 31, "henry.clark@example.com", "password606"));
        users.add(new User(10, "Ivy Wright", 26, "ivy.wright@example.com", "password707"));
    }
    public static Optional<User> getUserById(int id) {
        return users.stream()
                .filter((user) -> user.getId() == id)
                .findFirst();
    }
    public static boolean isAuthenticated(String email, String password) {
        if (email == null || password == null) {
            throw new IllegalArgumentException("Please provide all required data");
        }
        return users.stream()
                .anyMatch(
                        (user) -> email.equals(user.getEmail()) && password.equals(user.getPassword())
                );
    }
}
