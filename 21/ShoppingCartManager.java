import java.util.Scanner;

public class ShoppingCartManager{
  public static void main(String[] args) {
    Scanner customer = new Scanner(System.in);
    boolean shopping = true;
    System.out.println("Enter Customer's Name:");
    String customName = customer.nextLine();
    System.out.println("Enter Today's Date:");
    String date = customer.nextLine();
    ShoppingCart cart = new ShoppingCart(customName,date);
    System.out.println("\nCustomer Name: "+cart.getCustomerName()+"\nToday's Date: "+cart.getDate());
    while(shopping){
      char choice = printMenu(cart, customer);
      if(choice == 'q'){
        shopping = false;
      }
      else if(choice == 'a'){
        System.out.println("ADD ITEM TO CART\nEnter the item name:");
        String itemNam = customer.nextLine();
        System.out.println("Enter the item description:");
        String description = customer.nextLine();
        System.out.println("Enter the item price:");
        int price = customer.nextInt();
        System.out.println("Enter the item quantity:");
        int amount = customer.nextInt();
        ItemToPurchase itp = new ItemToPurchase(itemNam,description,price,amount);
        cart.addItem(itp);
        customer.nextLine();
      }
      else if(choice == 'd'){
        System.out.println("REMOVE ITEM FROM CART\nEnter name of item to remove:");
        String itpName = customer.nextLine();
        cart.removeItem(itpName);
      }
      else if(choice == 'c'){
        System.out.println("CHANGE ITEM QUANTITY\nEnter the item name:");
        ItemToPurchase itp = new ItemToPurchase();
        String itemNam = customer.nextLine();
        itp.setName(itemNam);
        System.out.println("Enter the new quantity:");
        int amount = customer.nextInt();
        itp.setQuantity(amount);
        cart.modifyItem(itp);
        customer.nextLine();
      }
      else if(choice == 'i'){
        System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
        cart.printDescriptions();
      }
      else if(choice == 'o'){
        System.out.println("OUTPUT SHOPPING CART");
        cart.printTotal();
      }
    }
  }
  public static char printMenu(ShoppingCart cart, Scanner customer){
    char choice = 'z';
    System.out.println("\nMENU\na - Add item to cart");
    System.out.println("d - Remove item from cart");
    System.out.println("c - Change item quantity");
    System.out.println("i - Output items' descriptions");
    System.out.println("o - Output shopping cart");
    System.out.println("q - Quit\n");
    do{
      System.out.println("Choose an option:");
      choice = customer.nextLine().charAt(0);
    }while(choice!= 'a'&&choice!='d'&&choice!='c'&&choice!='i'&&choice!='o'&&choice!='q');
    return choice;
  }
}
