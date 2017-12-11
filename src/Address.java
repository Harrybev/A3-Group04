/**
*This class stores all of the information to do with address for a user
*/
public class Address {
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String postCode;

    /**
    *Constructor for address class takes 5 strings
    **/
    public Address(String address1, String address2, String address3,
                   String address4, String postCode) {
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.address4 = address4;
        this.postCode = postCode;
    }
    /**
    *Getters And Setters
    **/
    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getAddress3() {
        return address3;
    }

    public String getAddress4() {
        return address4;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
