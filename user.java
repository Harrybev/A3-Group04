import java.awt.*;
import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class User implements Sortable {
    private String username;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private Address address;
    private ZonedDateTime lastLoginTime;
    private String profileImagePath;
    private ArrayList<Auction> listedAuctions;
    private ArrayList<Auction> wonAuctions;
    private ArrayList<Auction> completedAuctions;
    private ArrayList<User> favouriteUsers;

	 /**
     * 
     * @param username
     * @param firstName
     * @param lastName
     * @param telephoneNumber
     * @param ZonedDateTime
     * @param profileImagePath
     */
    public User(String username, String firstName, String lastName, String
            telephoneNumber, Address address, ZonedDateTime lastLogin, String profileImagePath) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.lastLoginTime = lastLogin;
        this.profileImagePath = profileImagePath;
    }

	/**
     * @return The profile image pathway
     */
    public String getProfileImagePath() {
        return profileImagePath;
    }

	/**
     * @param Set the profile image pathway
     */
    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

	/**
     * @return The username of the user
     */
    public String getUsername() {
        return username;
    }

	/**
     * @param Set the username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

	/**
     * @return The first name of the user
     */
    public String getFirstName() {
        return firstName;
    }

	/**
     * @param Set the first name of the user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

	/**
     * @return The last name of the user
     */
    public String getLastName() {
        return lastName;
    }

	/**
     * @return The date and time of last login of the user
     */
    public ZonedDateTime getLastLoginTime() {
        return lastLoginTime;
    }

	/**
     * @param Set the date and time of last login for this user
     */
    public void setLastLoginTime(ZonedDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

	/**
     * @param Set the last name of this user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	/**
     * @return The telephone number of the user
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

	/**
     * @param Set the telephone number of this user
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

	/**
     * @return The address of the user
     */
    public Address getAddress() {
        return address;
    }

	/**
     * @param Set the address of this user
     */
    public void setAddress(Address address) {
        this.address = address;
    }

	/**
     * 
     * @param s
     * @return
     */
    public int compareTo(Sortable s) {
        User otherUser = (User) s;
        return this.getUsername().compareTo(otherUser.getUsername());
    }
}