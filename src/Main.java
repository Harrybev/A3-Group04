import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String fakeImagePath = "yo";
        Date someDate = new Date();
        Address testAdd = new Address("Add1", "Add2", "Add3", "Add4", "postcode");
        User chris = new User("Chris", "Chris", "Evans", "01259301359", testAdd, someDate, fakeImagePath);
        User tom = new User("Tom", "Chris", "Evans", "01259301359", testAdd, someDate, fakeImagePath);

        WriteFiles writer = new WriteFiles();

//        writer.addUser(chris);

        ReadFiles reader = new ReadFiles();

//        for (User u : reader.readUsers().inOrderList()) {
//            System.out.println(u.getUsername());
//        }
//        System.out.println("It works!");

        // Testing changes to BST
        BST testTree = new BST();
        BSTNode chrisNode = new BSTNode(chris);
        BSTNode tomNode = new BSTNode(tom);

        testTree.addNode(chrisNode);
        testTree.addNode(tomNode);

        for (Sortable s : testTree.inOrderList()) {
            User user = (User) s;
            System.out.println(user.getUsername());
        }


    }
}
