/*
Jakob Karhinen
CS145
4/24/23
This program implements a phone book using the PhonebookManager class. The user
can add, delete, modify, lookup and print contacts.
*/

import java.util.*;

public
class TestClass {
 public
  static void main(String[] args) {
    PhonebookManager phonebook =
        new PhonebookManager();  // Create a new phone book manager
    Scanner scanner = new Scanner(System.in);
    int position = 1;  // Initialize position to 1
    String input;
    // Repeat until user enters "quit" command
    do {
      System.out.print(
          "Enter a command (add, delete, modify, lookup, print, quit):");
      input = scanner.next().toLowerCase();

      // Handle add command
      if (input.equals("add")) {
        String first = promptForFirstName(scanner);
        String last = promptForLastName(scanner);
        String address = promptForAddress(scanner);
        String city = promptForCity(scanner);
        String phone = promptForPhone(scanner);

        // If phone book is not empty, prompt user to enter a position to add
        // the new contact
        if (phonebook.getSize() > 0) {
          System.out.print(
              "At which position do you want to insert this contact in the list? Please enter a number from 1 to " +
              (phonebook.getSize() + 1) + ": ");
          position = scanner.nextInt();
        }

        // Add contact to phone book based on the user's input position
        if (position == 1) {
          phonebook.addToStart(first, last, address, city, phone);
        } else if (position == phonebook.getSize() + 1) {
          phonebook.addToEnd(first, last, address, city, phone);
        } else if (position > 1 && position <= phonebook.getSize()) {
          phonebook.addToMiddle(first, last, address, city, phone, position);
        } else {
          System.out.println("Invalid position!");
        }
      }
      // Handle delete command
      else if (input.equals("delete")) {
        String first = promptForFirstName(scanner);
        String last = promptForLastName(scanner);

        phonebook.delete(first, last);
      }
      // Handle modify command
      else if (input.equals("modify")) {
        String first = promptForFirstName(scanner);
        String last = promptForLastName(scanner);
        String address = promptForAddress(scanner);
        String city = promptForCity(scanner);
        String phone = promptForPhone(scanner);

        phonebook.modify(first, last, address, city, phone);
      }
      // Handle lookup command
      else if (input.equals("lookup")) {
        String first = promptForFirstName(scanner);
        String last = promptForLastName(scanner);

        phonebook.lookup(first, last);
      }
      // Handle print command
      else if (input.equals("print")) {
        phonebook.printList();
      }
    } while (!input.equalsIgnoreCase(
        "quit"));  // Repeat until user enters "quit" command
  }

  // Prompt user for first name and validate input
 private
  static String promptForFirstName(Scanner scanner) {
    String first = "";

    while (first.equals("")) {
      System.out.print("Enter first name:");

      first = scanner.next();

      if (first.equals("")) {
        System.out.println("Invalid input! First name cannot be empty.");
      }
    }

    return first;
  }
  // This method prompts the user to enter their last name and returns it as a
  // String
 private
  static String promptForLastName(Scanner scanner) {
    String last = "";  // initialize last name to an empty string
    scanner
        .nextLine();  // consume the new line character from the previous input
    // keep prompting the user until a non-empty last name is entered
    while (last.equals("")) {
      System.out.print("Enter last name:");

      last = scanner.nextLine();  // read user input for last name

      if (last.equals("")) {  // check if the input is empty
        System.out.println("Invalid input! Last name cannot be empty.");
      }
    }

    return last;  // return the last name as a String
  }
  // This method prompts the user to enter their address and returns it as a
  // String
 private
  static String promptForAddress(Scanner scanner) {
    String address = "";  // initialize address to an empty string
    // keep prompting the user until a non-empty address is entered
    while (address.equals("")) {
      System.out.print("Enter address:");

      address = scanner.nextLine();  // read user input for address

      if (address.equals("")) {  // check if the input is empty
        System.out.println("Invalid input! Address cannot be empty.");
      }
    }

    return address;  // return the address as a String
  }

  // This method prompts the user to enter their city and returns it as a String
 private
  static String promptForCity(Scanner scanner) {
    String city = "";  // initialize city to an empty string
    // keep prompting the user until a non-empty city is entered
    while (city.equals("")) {
      System.out.print("Enter city:");

      city = scanner.nextLine();  // read user input for city

      if (city.equals("")) {  // check if the input is empty
        System.out.println("Invalid input! City cannot be empty.");
      }
    }

    return city;  // return the city as a String
  }

  // This method prompts the user to enter their phone number and returns it as
  // a String
 private
  static String promptForPhone(Scanner scanner) {
    String phone = "";  // initialize phone number to an empty string
    // keep prompting the user until a non-empty phone number is entered
    while (phone.equals("")) {
      System.out.print("Enter phone number:");

      phone = scanner.nextLine();  // read user input for phone number

      if (phone.equals("")) {  // check if the input is empty
        System.out.println("Invalid input! Phone number cannot be empty.");
      }
    }

    return phone;  // return the phone number as a String
  }
}