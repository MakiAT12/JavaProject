import java.util.Scanner;
public class InternetDelicatessen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float deliverPrice;

        System.out.print("Enter the item: ");
        String item = scan.nextLine();
        System.out.print("Enter the price: ");
        float price = scan.nextFloat();
        System.out.print("Overnight delivery (0==no, 1==yes): ");
        byte option = scan.nextByte();

        if(option == 1) {
            if (price >= 10)
                deliverPrice = 3;
            else
                deliverPrice = 2 + 3;       
        }
        else {
            if (price >= 10) 
                deliverPrice = 0;
            else
                deliverPrice = 2;
        }
        System.out.printf("\nInvoice:");
        System.out.printf("\n\t%s\t\t%.2f", item, price);
        System.out.printf("\n\tdeliver\t\t\t%.2f", deliverPrice);
        System.out.printf("\n\ttotal\t\t\t%.2f", (price + deliverPrice));
    }
}