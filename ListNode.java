public class ListNode {
  //private variables to store contact info
   private String firstName;
   private String lastName;
   private String city;
   private String address;
   private String phoneNumber;
   //reference to next node
   public ListNode next;
   
   //constructor to initialize contact info
   public ListNode(String firstName, String lastName, String address, String city, String phoneNumber) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.address = address;
      this.city = city;
      this.phoneNumber = phoneNumber;
      this.next = null;
   }
   
   //getters and setters for contact info variables
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

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }
}
