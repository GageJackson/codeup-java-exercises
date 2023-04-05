package contacts;

public class Contact {
    private String name;
    private String phoneNumber;

    /*
    Constructors
     */
    public void Contact(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void Contact(String name, int phoneNumber){
        this.name = name;
        this.phoneNumber = Integer.toString(phoneNumber);
    }


    /*
    Getters and Setters
     */
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
