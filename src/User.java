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

    public User(String username, String firstName, String lastName, String
            telephoneNumber, Address address, ZonedDateTime lastLogin, String profileImagePath) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.lastLoginTime = lastLogin;
        if (profileImagePath.equals("null")) {
            this.profileImagePath = "profile-pics/1.jpg";
        } else {
            this.profileImagePath = profileImagePath;
        }
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ZonedDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(ZonedDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int compareTo(Sortable s) {
        User otherUser = (User) s;
        return this.getUsername().compareTo(otherUser.getUsername());
    }

    public String getSearchKey() {
        return this.username;
    }

    public void setFavouriteUsers(ArrayList<User> favouriteUsers) {
        this.favouriteUsers = favouriteUsers;
    }

    public ArrayList<User> getFavouriteUsers() {
        return favouriteUsers;
    }
}
