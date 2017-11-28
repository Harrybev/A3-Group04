public class Main {
    public static void main(String[] args) {
        Address testAdd = new Address("Add1", "Add2", "Add3", "Add4", "postcode");
//        User chris = new User("test2", "Chris", "Evans", "01259301359", testAdd);

        WriteFiles writer = new WriteFiles();

//        writer.addUser(chris);

        ReadFiles reader = new ReadFiles();

//        for (User u : reader.readUsers().inOrderList()) {
//            System.out.println(u.getUsername());
//        }
    }
}
