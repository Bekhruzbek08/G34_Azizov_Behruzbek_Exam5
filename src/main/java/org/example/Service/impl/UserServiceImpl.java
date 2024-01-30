package org.example.Service.impl;

import org.example.domain.User;

public class UserServiceImpl implements UserService {

    User user1 = new User("Behruzbek","15","+998977072159","azizovbehruz445@gamil.com","1","R001");

    @Override
    public User login(String password, String name) {
        for (User user : User){
            if (user.getPassword().equals(password) && user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    public String registerUser(User user) {
        if (doesTheUserExist(user)) {
            return null;
        }
        User.add(user);
        return "Successfully";
    }

    public boolean doesTheUserExist(User user) {
        if (User.stream().anyMatch(user1 -> user1.getName().equals(user.getName()))){
            return true;
        } else if (User.stream().anyMatch(user1 -> user1.getPassword().equals(user.getPassword()))){
            return true;
        }
        return false;
    }
    public User getUserById(Integer id) {
        for (User user : USERS) {
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }
}
