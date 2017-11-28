import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReadFiles {
    public BST readUsers() {
        File inputFile = new File("users.txt");
        Scanner in = null;

        try {
            in = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("oops");
        }

        BST userTree = new BST();

        while (in.hasNextLine()) {
            String currLine = in.nextLine();
            Scanner lineScanner = new Scanner(currLine);
        lineScanner.useDelimiter(";");
        String username = lineScanner.next();
        String firstName = lineScanner.next();
        String lastName = lineScanner.next();
        String telNo = lineScanner.next();
        String add1 = lineScanner.next();
        String add2 = lineScanner.next();
        String add3 = lineScanner.next();
        String add4 = lineScanner.next();
        String postcode = lineScanner.next();

        DateFormat df = new SimpleDateFormat();
        Date lastLogin = null;
        try {
            lastLogin = df.parse(lineScanner.next());
        } catch (ParseException e) {
            System.out.println("ohnoes");
        }
        String imagePath = lineScanner.next();

        Address add = new Address(add1, add2, add3, add4, postcode);

        User user = new User(username, firstName, lastName, telNo, add, lastLogin, imagePath);
        BSTNode node = new BSTNode(user);
           userTree.addNode(node);
        }
        in.close();

        return userTree;
    }

    public BST readAuctions() {
//        File inputFile = new File("users.txt");
//        Scanner in = null;
//
//        try {
//            in = new Scanner(inputFile);
//        } catch (FileNotFoundException e) {
//            System.out.println("oops");
//        }
//
        BST userTree = new BST();
//
//        while (in.hasNextLine()) {
//
//            Scanner lineScanner = new Scanner(currLine);
//        lineScanner.useDelimiter(";");
//        String username = lineScanner.next();
//        String firstName = lineScanner.next();
//        String lastName = lineScanner.next();
//        String telNo = lineScanner.next();
//        String add1 = lineScanner.next();
//        String add2 = lineScanner.next();
//        String add3 = lineScanner.next();
//        String add4 = lineScanner.next();
//        String postcode = lineScanner.next();
//
//        DateFormat df = new SimpleDateFormat();
//        Date lastLogin = null;
//        try {
//            lastLogin = df.parse(lineScanner.next());
//        } catch (ParseException e) {
//            System.out.println("ohnoes");
//        }
//        String imagePath = lineScanner.next();
//
//        Address add = new Address(add1, add2, add3, add4, postcode);
//
//        User user = new User(username, firstName, lastName, telNo, add, lastLogin, imagePath);
//        BSTNode node = new BSTNode(user);
//           userTree.addNode(node);
//        }
//        in.close();

        return userTree;
    }

    public BST readArtworks() {
//        File inputFile = new File("users.txt");
//        Scanner in = null;
//
//        try {
//            in = new Scanner(inputFile);
//        } catch (FileNotFoundException e) {
//            System.out.println("oops");
//        }
//
        BST userTree = new BST();
//
//        while (in.hasNextLine()) {
//
//            Scanner lineScanner = new Scanner(currLine);
//        lineScanner.useDelimiter(";");
//        String username = lineScanner.next();
//        String firstName = lineScanner.next();
//        String lastName = lineScanner.next();
//        String telNo = lineScanner.next();
//        String add1 = lineScanner.next();
//        String add2 = lineScanner.next();
//        String add3 = lineScanner.next();
//        String add4 = lineScanner.next();
//        String postcode = lineScanner.next();
//
//        DateFormat df = new SimpleDateFormat();
//        Date lastLogin = null;
//        try {
//            lastLogin = df.parse(lineScanner.next());
//        } catch (ParseException e) {
//            System.out.println("ohnoes");
//        }
//        String imagePath = lineScanner.next();
//
//        Address add = new Address(add1, add2, add3, add4, postcode);
//
//        User user = new User(username, firstName, lastName, telNo, add, lastLogin, imagePath);
//        BSTNode node = new BSTNode(user);
//           userTree.addNode(node);
//        }
//        in.close();

        return userTree;
    }
}
