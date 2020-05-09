package model.user;


import model.contract.Contract;

import java.util.List;

public class User {

    private Long userId;
    private String firstName;
    private String lastName;
    private int birthId;
    private String email;
    private UserAddress address;
    private UserAddress correspAddress;
    private List<Contract> listOfContracts;

    public User() {
    }

    public User(Long userId, String firstName, String lastName, int birthId, String email, UserAddress address, UserAddress correspAddress) {
        this.userId = userId;
        setFirstName(firstName);
        setLastName(lastName);
        this.birthId = birthId;
        setEmail(email);
        setAddress(address);
        this.correspAddress = correspAddress;
    }

    public User(Long userId, String firstName, String lastName, int birthId, String email, UserAddress address, UserAddress correspAddress, List<Contract> listOfContracts) {
        this.userId = userId;
        setFirstName(firstName);
        setLastName(lastName);
        this.birthId = birthId;
        setEmail(email);
        setAddress(address);
        this.correspAddress = correspAddress;
        this.listOfContracts = listOfContracts;
    }

    public Long getUserId() {
        return userId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.trim().isEmpty())
            throw new IllegalArgumentException("You have to specify users first name.");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.trim().isEmpty())
            throw new IllegalArgumentException("You have to specify users last name.");
        this.lastName = lastName;
    }

    public int getBirthId() {
        return birthId;
    }

    public void setBirthId(int birthId) {
        if (birthId <= 0)
            throw new IllegalArgumentException("You have to specify users birth ID.");
        this.birthId = birthId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.trim().isEmpty())
            throw new IllegalArgumentException("You have to specify users email.");
        this.email = email;
    }

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        if (address == null)
            throw new IllegalArgumentException("You have to specify users address.");
        this.address = address;
    }

    public UserAddress getCorrespAddress() {
        return correspAddress;
    }

    public void setCorrespAddress(UserAddress correspAddress) {
        this.correspAddress = correspAddress;
    }

    public List<Contract> getListOfContracts() {
        return listOfContracts;
    }

    public void setListOfContracts(List<Contract> listOfContracts) {
        this.listOfContracts = listOfContracts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", meno='" + firstName + '\'' +
                ", priezvisko='" + lastName + '\'' +
                ", rodnecislo=" + birthId +
                ", email='" + email + '\'' +
                ", adresa=" + address +
                ", korespadresa=" + correspAddress +
                ", zoznamzmluv=" + listOfContracts +
                '}';
    }
}
