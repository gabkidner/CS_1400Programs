import java.util.Scanner;

public class ShoppingCartPrinter{
  public static void main(String[] args) {
    String itemNam;
    int price;
    int amount;
    ItemToPurchase itp1 = new ItemToPurchase();
    ItemToPurchase itp2 = new ItemToPurchase();
    Scanner customer = new Scanner(System.in);
    System.out.println("Item 1\nEnter the item name:");
    itemNam = customer.nextLine();
    itp1.setName(itemNam);
    System.out.println("Enter the item price:");
    price = customer.nextInt();
    itp1.setPrice(price);
    System.out.println("Enter the item quantity:");
    amount = customer.nextInt();
    itp1.setQuantity(amount);
    customer.nextLine();
    System.out.println("\nItem 2\nEnter the item name:");
    itemNam = customer.nextLine();
    itp2.setName(itemNam);
    System.out.println("Enter the item price:");
    price = customer.nextInt();
    itp2.setPrice(price);
    System.out.println("Enter the item quantity:");
    amount = customer.nextInt();
    itp2.setQuantity(amount);
    int total1 = itp1.getQuantity()*itp1.getPrice();
    int total2 = itp2.getQuantity()*itp2.getPrice();
    int realTotal = total1+total2;
    System.out.println("\nTOTAL COST\n"+itp1.getName()+" "+itp1.getQuantity()+" @ $"+itp1.getPrice()+" = $"+total1);
    System.out.println(itp2.getName()+" "+itp2.getQuantity()+" @ $"+itp2.getPrice()+" = $"+total2);
    System.out.println("\nTotal: $"+realTotal);
  }
}
