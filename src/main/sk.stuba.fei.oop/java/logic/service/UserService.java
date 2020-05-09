package logic.service;

import logic.repository.UserRepository;
import model.user.User;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;
    private final User dummyUser;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        dummyUser = new User();
    }

    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }


    public User getUserById(Long userId) {
        try {
            checkIfUserIdExists(userId);
            return userRepository.getUserById(userId);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return dummyUser;
    }

    public void addNewUser(User user) {
        try {
            checkIfUserIsValid(user);
            userRepository.addUser(user);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void editUser(User user) {
        checkIfUserIsValid(user);
        userRepository.editUser(user);

    }

    private void checkIfUserIdExists(Long userId) {
        if (!userRepository.checkIfUserIdExists(userId)) {
            throw new IllegalArgumentException("User not in database");
        }
    }

    private void checkIfUserIsValid(User user) {
        if (user == null || user.getUserId() <= 0 || user.getFirstName() == null || user.getLastName() == null || user.getBirthId() <= 0 || user.getEmail() == null || user.getAddress() == null) {
            throw new IllegalArgumentException("Not valid user, cant be added.");
        }
    }

}
