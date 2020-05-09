package logic.view;


import model.user.User;

import java.util.List;

public class UserView {

    public void printUserDetails(User user) {
        System.out.println(user.getUserId());
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getBirthId());
        System.out.println(user.getEmail());
        System.out.println(user.getAddress());
        System.out.println(user.getCorrespAddress());
        //System.out.println(user.getListOfContracts());
        System.out.println("\n");
    }

    public void printAllUsers(List<User> userList) {
        for (User user : userList) {
            printUserDetails(user);

        }
        System.out.println("\n");
    }
}
