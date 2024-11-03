import java.io.*;
import java.util.Scanner;

public class Contacts {
    File file = new File("contact.txt");
    Scanner scan = new Scanner(System.in);
    
    private boolean contactExists(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(name)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addContact(String str) {
        if (!contactExists(str)) {
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.append(str + "\n");
                writer.close();
                return true;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public void viewContact() {
        if (file.length() > 0) {
            try (FileReader fileR = new FileReader(file); BufferedReader bf = new BufferedReader(fileR)) {
                String line;
                System.out.println("Contacts:");
                while ((line = bf.readLine()) != null) {
                    System.out.println(line);
                }
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            System.out.println("Contact file is empty.");
    }
    public boolean updateContact(String str) {
        boolean updated = false;
        File tempFile = new File("tempFile.txt"); // Temporary file to store updates
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            
            String line;
            
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(str)) {
                    System.out.print("Enter the new name: ");
                    String newStr = scan.nextLine();
                    
                    if(contactExists(newStr))
                        break;

                    writer.write(newStr);
                    updated = true;
                } else {
                    writer.write(line);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (updated) {
            if (file.delete()) {
                tempFile.renameTo(file);
            } else {
                System.out.println("Failed to delete the original file");
                return false;
            }
        } else {
            tempFile.delete();
        }
        
        return updated;
    }
    public boolean deleteContact(String str) {
        boolean del = false;

        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")){
            long length = raf.length(), writePointer = 0;
            String line;

            while (raf.getFilePointer() < length) {
                long readPointer = raf.getFilePointer();
                line = raf.readLine();

                if (line != null) {
                    if (line.trim().equals(str)) {
                        del = true;
                        continue;
                    }

                    raf.seek(writePointer);
                    raf.writeBytes(line + "\n");
                    writePointer = raf.getFilePointer();

                    raf.seek(readPointer + line.length() + 1);
                }
            }
            raf.setLength(writePointer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return del;
    }
}