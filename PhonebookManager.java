// Class to manage the phonebook using a linked list of ListNode objects
public class PhonebookManager {
// Private instance variables
   private ListNode head; // The head of the linked list
   private int size; // The size of the phonebook
// Constructor for the PhonebookManager class
   public PhonebookManager() {
      head = null;
      this.size = 0;
   }

// Method to add a new phonebook entry to the beginning of the list
   public void addToStart(String first, String last, String address, String city, String phone) {
    // Create a new ListNode object with the provided information
      ListNode newnode = new ListNode(first, last, address, city, phone);
    
    // Add the new node to the beginning of the list and update the head
      newnode.next = head;
      head = newnode;
    
    // Print a message confirming the addition and update the size
      System.out.println(first + " " + last + " added to the phonebook at the beginning");
      this.size++;
   }

// Method to add a new phonebook entry to the end of the list
   public void addToEnd(String first, String last, String address, String city, String phone) {
    // Create a new ListNode object with the provided information
      ListNode newnode = new ListNode(first, last, address, city, phone);
    
    // If the list is empty, add the new node as the head
      if (head == null) {
         head = newnode;
      } else {
        // Traverse the list to the end and add the new node there
         ListNode current = head;
         while (current.next != null) {
            current = current.next;
         }
         current.next = newnode;
      }
    
    // Print a message confirming the addition and update the size
      System.out.println(first + " " + last + " added to the phonebook at the end");
      this.size++;
   }

// Method to add a new phonebook entry to a specific position in the list
   public void addToMiddle(String first, String last, String address, String city, String phone, int position) {
    // Create a new ListNode object with the provided information
      ListNode newnode = new ListNode(first, last, address, city, phone);
    
    // If the position is 1, add the new node to the beginning of the list
      if (position == 1) {
         addToStart(first, last, address, city, phone);
      } else {
        // Traverse the list to the desired position and add the new node there
         ListNode current = head;
         int count = 1;
         while (count < position - 1 && current != null) {
            current = current.next;
            count++;
         }
        // If the desired position is invalid, print an error message and return
         if (current == null) {
            System.out.println("Invalid position!");
            return;
         }
         newnode.next = current.next;
         current.next = newnode;
        
        // Print a message confirming the addition and update the size
         System.out.println(first + " " + last + " added to the phonebook at position " + position);
         this.size++;
      }
   }

   public void printList() {
    // If the list is empty, print a message and return
      if (head == null) {
         System.out.println("Phonebook is empty.");
         return;
      }
    // Otherwise, print the header for the list
      System.out.println("Phonebook Entries:");
    // Start at the beginning of the list and iterate through each entry
      ListNode current = head;
      int count = 1;
      while (current != null) {
        // Print the current entry's information
         System.out.println("Entry #" + count + ":");
         System.out.println("Name: " + current.getFirstName() + " " + current.getLastName());
         System.out.println("Address: " + current.getAddress());
         System.out.println("City: " + current.getCity());
         System.out.println("Phone: " + current.getPhoneNumber());
         System.out.println("------------------------------");
        // Move on to the next entry
         current = current.next;
         count++;
      }
   }

   public void delete(String first, String last) {
    // Start at the beginning of the list and iterate through each entry
      ListNode current = head;
      ListNode previous = null;
      while (current != null && (!current.getFirstName().equals(first) || !current.getLastName().equals(last))) {
        // Keep track of the previous entry in case we need to delete the current one
         previous = current;
         current = current.next;
      }
    // If we reach the end of the list without finding the entry, print a message
      if (current == null) {
         System.out.println(first + " " + last + " not found in the phonebook");
      } else if (previous == null) {
        // If the entry is the first one in the list, update the head pointer
         head = current.next;
         System.out.println(first + " " + last + " deleted from the phonebook");
         this.size--;
      } else {
        // Otherwise, update the previous entry's next pointer
         previous.next = current.next;
         System.out.println(first + " " + last + " deleted from the phonebook");
         this.size--;
      }
   }

   public void modify(String first, String last, String address, String city, String phone) {
    // Start at the beginning of the list and iterate through each entry
      ListNode current = head;
      boolean found = false;
      while (current != null) {
        // If we find the entry we want to modify, update its information and print a message
         if (current.getFirstName().equals(first) && current.getLastName().equals(last)) {
            current.setAddress(address);
            current.setCity(city);
            current.setPhoneNumber(phone);
            System.out.println(first + " " + last + "'s information updated in the phonebook");
            found = true;
            break;
         }
        // Move on to the next entry
         current = current.next;
      }
    // If we reach the end of the list without finding the entry, print a message
      if (!found) {
         System.out.println(first + " " + last + " not found in the phonebook");
      }
   }

   public ListNode lookup(String firstName, String lastName) {
      ListNode current = head;
    // Traverse the list until either the end is reached or the matching entry is found
      while (current != null && !(current.getFirstName().equals(firstName) && current.getLastName().equals(lastName))) {
         current = current.next;
      }
    // If the matching entry is not found, print a message indicating so
      if (current == null) {
         System.out.println("Entry not found!");
      } else {
        // Otherwise, print the details of the matching entry
         System.out.println("Phonebook Entry:");
         System.out.println("Name: " + current.getFirstName() + " " + current.getLastName());
         System.out.println("Address: " + current.getAddress());
         System.out.println("City: " + current.getCity());
         System.out.println("Phone: " + current.getPhoneNumber());
         System.out.println("------------------------------");
      }
    // Return the matching entry, or null if it was not found
      return current;
   }

// Return the number of entries in the phonebook
   public int getSize() {
      return this.size;
   }
}
