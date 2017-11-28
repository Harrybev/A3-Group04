import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class WriteFiles {
    public void writeUsers(BST userTree) {
        File outputFile = new File("users.txt");
        FileWriter out = null;
        try {
            out = new FileWriter(outputFile, true);
        } catch (IOException e) {
            System.out.println("File not found.");
            System.exit (0);
        }
        ArrayList<Sortable> userList = userTree.inOrderList();
        for (Sortable s : userList)  {
            User user = (User) s;
        String username = user.getUsername();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String telephoneNumber = user.getTelephoneNumber();
        String address1 = user.getAddress().getAddress1();
        String address2 = user.getAddress().getAddress2();
        String address3 = user.getAddress().getAddress3();
        String address4 = user.getAddress().getAddress4();
        String postcode = user.getAddress().getPostCode();
        Date lastLogin = (Date) user.getLastLoginTime();
        String profileImagePath = user.getProfileImagePath();

        try {
            out.write(username + ";" + firstName + ";" + lastName + ";" +
                    telephoneNumber + ";" + address1 + ";" + address2 + ";" +
                    address3 + ";" + address4 + ";" + postcode + ";" + lastLogin
                    + ";" + profileImagePath + ";");
            out.close();
        } catch (IOException e) {
            System.out.println("Error!");
        }
        }



   }

    public void writeArtworks(BST artworkTree) {

   }

    public void writeAuctions(BST auctionsTree) {

   }
}
