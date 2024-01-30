import org.example.domain.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface UserService {
    List<User> USERS = Collections.synchronizedList(new ArrayList<>());
    User login(String password, String name);

    String registerUser(User user);

    boolean doesTheUserExist(User user);


    void showAllActiveUsers();

    User getUserById(Integer id);
}

public boolean doesTheUserExist(User user) {
    if (User.stream().anyMatch(user1 -> user1.getName().equals(user.getName()))) {
        return true;
    } else if (User.stream().anyMatch(user1 -> user1.getPassword().equals(user.getPassword()))) {
        return true;
    }
    return false;
}


public static UserServiceImpl getInstance(){
    if (UserService == null){
        UserService = new UserServiceImpl();
        return UserService;
    }
    return userService;
}

