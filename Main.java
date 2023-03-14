import java.util.LinkedList; //well... some may call it the easy way out to import this, but it exists.. so y not rite?
import java.util.Scanner;

public class Main {

    private static LinkedList<Contact> contacts = new LinkedList<>();

    public static void main(String[] args)
    {
        // some basic printouts

        Scanner scanner = new Scanner(System.in);

        // A while loop which carries out actions based on what user inputs
        while (true)
        {
            System.out.println("*********************************************");
            System.out.println("(A)dd\n(D)elete\n(E)mail Search\n(P)rint List\n(S)earch\n(Q)uit");
            System.out.println("*********************************************");
            System.out.print("Please enter a command:   ");
            String command = scanner.next();
            System.out.println("\n");

            switch (command.toUpperCase()) {
                case "A":
                    addContact(scanner);
                    break;
                case "D":
                    deleteContact(scanner);
                    break;
                case "E":
                    emailSearch(scanner);
                    break;
                case "P":
                    printContacts();
                    break;
                case "S":
                    searchContacts(scanner);
                    break;
                case "Q":
                    System.out.println("Exiting program."); // :(
                    return;
                default:
                    System.out.println("Invalid command."); // :/
                    break;
            }
        }
    }

    // function for add contact. feels like im making a class more than a function... -ex python user
    private static void addContact(Scanner scanner)
    {
        System.out.print("Please enter the name: ");
        String name = scanner.next();
        System.out.println("Please enter the phone number: ");
        String phone = scanner.next();
        System.out.println("Please enter the email: ");
        String email = scanner.next();

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        System.out.println("Contact added.");

        // make the program stop for a while, better that way imo, java makes this so complicated doe... -Ex python user, and some C
        try {
            Thread.sleep(2000); // sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace(); //have no clue what this thing means but if i don't do this, there's a redline error
        }
    }

    // function to delete contact
    private static void deleteContact(Scanner scanner)
    {
        System.out.print("Who do u wish to exterminate?: ");
        String name = scanner.next(); // scan the name typed down

        boolean removed = false; // define the boolean for removed

        // a simple for loop which checks if name typed down exists, and if so, make that boolean of remove contact true

        for (Contact contact : contacts)
        {
            if (contact.getName().equalsIgnoreCase(name))
            {
                contacts.remove(contact);
                removed = true;
                System.out.println("Target Exterminated (contact removed)");
                try {
                    Thread.sleep(2000); // sleep for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        // an if statement that covers the scenario if name typed does not exist in contact
        if (!removed) {
            System.out.println("Contact not found.");
            try {
                Thread.sleep(2000); // sleep for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Function for the email search thing, who even uses this... Wish to survey their sanity..
    private static void emailSearch(Scanner scanner) {
        System.out.print("enter da email to search: ");
        String email = scanner.next();// scan what they're about to type next

        boolean found = false; // define the boolean for "found", self explanitory what found does..
        for (Contact contact : contacts) {
            if (contact.getEmail().equalsIgnoreCase(email)) // if email is on the contacts, put that boolean to true
            {
                System.out.println(contact);

                found = true;

                try {
                    Thread.sleep(2000); // sleep for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        if (!found)  // if not, print not found
        {
            System.out.println("Contact found, NOT!");
            try {
                Thread.sleep(2000); // sleep for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // function to print contacts
    private static void printContacts()
    {
        if (contacts.isEmpty()) // scenario if user does not have friends :(
        {
            System.out.println("nothing here, try going outside sometime.");
            try {
                Thread.sleep(2000); // sleep for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        else // scenario if user does have friends :)
        {
            for (Contact contact : contacts)  // for everything that's there in contacts, print each one of em
            {
                System.out.println(contact);
                try {
                    Thread.sleep(2000); // sleep for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // function for da searching
    private static void searchContacts(Scanner scanner)
    {
        System.out.print("Who to stalk this time? (enter name): ");
        String name = scanner.next();

        boolean found = false;// define boolean for if found or not
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println(contact);
                found = true;
                try {
                    Thread.sleep(2000); // sleep for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        if (!found)
        {
            System.out.println("Target AWOL. (not found)");
            try {
                Thread.sleep(2000); // sleep for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // class which stores pretty much all the detail for the functions to actually be working later [name, phone, email]
    private static class Contact
    {
        //simple declarations
        private String name;
        private String phone;
        private String email;

        // initialize the declarations just made,
        public Contact(String name, String phone, String email)
        {
            this.name = name; // using "this." so ribet -Ex python user
            this.phone = phone;
            this.email = email;
        }

        // everything below are public methods to be used anywhere at all:
        public String getName()  // to return name
        {
            return name;
        }

        public String getPhone() // to return the phone number
        {
            return phone;
        }

        public String getEmail() // to return the email
        {
            return email;
        }

        @Override // needs this to pretty much override from the super class. Assert dominance.
        public String toString()
        { // to return ALL!
            return "Contact{name='" + name + "', phone='" + phone + "', email='" + email + "'}";

        }
    }
}