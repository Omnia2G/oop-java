package logic.repository;

import model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
    private List<User> allUser;


    public UserRepository() {
        allUser = new ArrayList<>();
    }

    public User getUserById(Long userId) {
        User tmpuser = null;
        for (User user : allUser) {
            if (user.getUserId().equals(userId)) {
                tmpuser = user;
            }
        }
        return tmpuser;
    }

    public void addUser(User user) {
        allUser.add(user);
    }

    public List<User> getAllUser() {
        return new ArrayList<>(allUser);
    }

    public boolean checkIfUserIdExists(Long userId) {
        List<Long> userIdList = allUser.stream().map(User::getUserId).collect(Collectors.toList());
        return userIdList.contains(userId);
    }

    public void editUser(User user) {
        System.out.println(user);
        User tempUser = getUserById(user.getUserId());

        allUser.remove(tempUser);
        tempUser.setAddress(user.getAddress());
        tempUser.setEmail(user.getEmail());
        tempUser.setLastName(user.getLastName());
        tempUser.setFirstName(user.getFirstName());
        tempUser.setCorrespAddress(user.getCorrespAddress());
        tempUser.setListOfContracts(user.getListOfContracts());
        allUser.add(tempUser);
    }

}
