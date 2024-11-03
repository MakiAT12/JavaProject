import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Contacts contact = new Contacts();
        Scanner scan = new Scanner(System.in);
        int opt = 0;
        String str = null;
        do {
            try {
                System.out.println("Contact Management System\r\n" +
                        "1. Add Contact\r\n" +
                        "2. View Contacts\r\n" +
                        "3. Update Contact\r\n" +
                        "4. Delete Contact\r\n" +
                        "5. Exit");
                System.out.print("Choose an option: ");
                opt = scan.nextInt();
                scan.nextLine();
                if (opt == 5)
                    break;

                switch (opt) {
                    case 1:
                        System.out.print("Enter contact: ");
                        str = scan.nextLine().trim();
                        if (str.isEmpty())
                            System.out.println("Contact not added (empty input).");
                        else if (contact.addContact(str))
                            System.out.println("Contact added.");
                        else
                            System.out.println("Already existed contact cannot be added.");
                        break;
                    case 2:
                        contact.viewContact();
                        break;
                    case 3:
                        if (contact.file.length() < 1) {
                            System.out.println("Empty contact file.");
                            break;
                        }
                        System.out.print("Enter the name of the contact to update: ");
                        str = scan.nextLine().trim();
                        if (contact.updateContact(str))
                            System.out.println("Contact updated.");
                        else
                            System.out.println("Contact not found or updated name is alrealy existed.");
                        break;
                    case 4:
                        if (contact.file.length() < 1) {
                            System.out.println("Empty contact file.");
                            break;
                        }
                        System.out.print("Enter the name of the contact to delete: ");
                        str = scan.nextLine().trim();
                        if (contact.deleteContact(str))
                            System.out.println("Contact deleted.");
                        else
                            System.out.println("Contact not found.");
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.err.println("Invalid input please try again.");
                scan.nextLine();
            }
            System.out.println();
        } while (true);

        System.out.println("Exiting...");
        scan.close();
    }
}