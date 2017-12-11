import java.awt.*;
import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Iterator;

public class User implements Sortable {
    private String username;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private Address address;
    private String profileImagePath;
    private ArrayList<Auction> listedAuctions;
    private ArrayList<Auction> wonAuctions;
    private ArrayList<Auction> completedAuctions;
    private ArrayList<User> favouriteUsers;

    public User(String username, String firstName, String lastName, String
            telephoneNumber, Address address, String profileImagePath) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        if (profileImagePath.equals("null")) {
            this.profileImagePath = "profile-pics/1.jpg";
        } else {
            this.profileImagePath = profileImagePath;
        }
        favouriteUsers = new ArrayList<>();
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

    public void setAFavouriteUsers(User user){
      this.favouriteUsers.add(user);
    }

    public void RemoveAFavouriteUsers(User user){
      for(Iterator<User> i = this.favouriteUsers.iterator(); i.hasNext();){
          User users = i.next();
          if(user.equals(users)){
            i.remove();
          }

        }
    }

    public Boolean isFavourites(User user){
      for(User userList: this.favouriteUsers){
        if(user.equals(userList)){
          return true;
        }
      }
      return false;
    }

    public void setFavouriteUsers(ArrayList<User> favouriteUsers) {
        this.favouriteUsers = favouriteUsers;
    }

    public ArrayList<User> getFavouriteUsers() {
        return favouriteUsers;
    }
}
