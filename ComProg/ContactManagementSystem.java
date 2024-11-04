// Name: Camporedondo, Bj S.        Date: 11/4/2024
import java.io.*;
import java.util.Scanner;

public class ContactManagementSystem {
    private static final File file = new File("contacts.txt");
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int opt = 0;
        createFileIfNotExists();
        do {

            try {
                System.out.println("Contact Management System\n" +
                        "1. Add Contact\n" +
                        "2. View Contacts\n" +
                        "3. Update Contact\n" +
                        "4. Delete Contact\n" +
                        "5. Exit");
                System.out.print("Choose an option: ");
                opt = Integer.parseInt(scan.nextLine().trim());

                if (opt == 5) break;

                switch (opt) {
                    case 1:
                        addContactPrompt();
                        break;
                    case 2:
                        viewContacts();
                        break;
                    case 3:
                        updateContactPrompt();
                        break;
                    case 4:
                        deleteContactPrompt();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.err.println("Invalid input, please try again.");
            }
            System.out.println();
        } while (true);

        System.out.println("Exiting...");
        scan.close();
    }
    private static void addContactPrompt() {
        System.out.print("Enter contact name: ");
        String contact = scan.nextLine().trim();
        if (contact.isEmpty()) 
            System.out.println("Contact not added (empty input).");
        else if (addContact(contact)) 
            System.out.println("Contact added.");
        else 
            System.out.println("Contact already exists and cannot be added.");
    }
    private static boolean addContact(String contact) {
        if (!contactExists(contact)) {
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.append(contact).append("\n");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    private static void viewContacts() {
        if (file.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                System.out.println("Contacts:");
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else 
            System.out.println("Contact file is empty.");
        
    }
    private static void updateContactPrompt() {
        if (file.length() < 1) {
            System.out.println("Contact file is empty.");
            return;
        }
        System.out.print("Enter the name of the contact to update: ");
        String oldContact = scan.nextLine().trim();
        System.out.print("Enter the new name: ");
        String newContact = scan.nextLine().trim();

        if (updateContact(oldContact, newContact)) 
            System.out.println("Contact updated.");
        else 
            System.out.println("Contact not found or new name already exists.");
        
    }
    private static boolean updateContact(String oldContact, String newContact) {
        boolean updated = false;
        File tempFile = new File("tempFile.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(oldContact) && !contactExists(newContact)) {
                    writer.write(newContact);
                    updated = true;
                } else 
                    writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (updated) {
            if (file.delete()) 
                tempFile.renameTo(file);
            else {
                System.out.println("Failed to delete the original file.");
                return false;
            }
        } else 
            tempFile.delete();
        return updated;
    }
    private static void deleteContactPrompt() {
        if (file.length() < 1) {
            System.out.println("Contact file is empty.");
            return;
        }
        System.out.print("Enter the name of the contact to delete: ");
        String contact = scan.nextLine().trim();
        if (deleteContact(contact))
            System.out.println("Contact deleted.");
        else 
            System.out.println("Contact not found.");
    }
    public static boolean deleteContact(String str) {
        boolean del = false;
    
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            long length = raf.length(), writePointer = 0;
            String line;
    
            while (raf.getFilePointer() < length) {
                long readPointer = raf.getFilePointer();
                line = raf.readLine();
    
                if (line != null) {
                    if (line.trim().equals(str)) {
                        del = true;
                        continue; // Skip writing this line
                    }
    
                    // Check if line is empty after trimming
                    if (!line.trim().isEmpty()) {
                        raf.seek(writePointer);
                        raf.writeBytes(line + "\n");
                        writePointer = raf.getFilePointer();
                    }
    
                    raf.seek(readPointer + line.length() + 1);
                }
            }
            raf.setLength(writePointer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return del;
    }
    
    private static boolean contactExists(String contact) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(contact)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    private static void createFileIfNotExists() {
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Created new contact file: " + file.getName());
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while creating the contact file.");
            e.printStackTrace();
        }
    }
}