import java.util.ArrayList;

public class ShoppingCart{
  private String customerName;
  private String currentDate;
  private ArrayList<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();
  public ShoppingCart(){
    customerName = "none";
    currentDate = "January 1, 2016";
  }
  public ShoppingCart(String customName, String date){
    customerName = customName;
    currentDate = date;
  }
  public String getCustomerName(){
    return customerName;
  }
  public String getDate(){
    return currentDate;
  }
  public void addItem(ItemToPurchase itp){
    cartItems.add(itp);
  }
  public void removeItem(String itpName){
    int x = -1;
    for(int i=0; i<cartItems.size(); i++){
      if (cartItems.get(i).getName().equals(itpName)){
        x = i;
      }
    }
    if(x == -1){
      System.out.println("Item not found in cart. Nothing removed.");
    }
    if(x != -1){
      cartItems.remove(x);
    }
  }
  public void modifyItem(ItemToPurchase itp){
    int noPrint = 0;
    for(int i=0; i<cartItems.size(); i++){
      int good = itp.getName().compareTo(cartItems.get(i).getName());
      if(good == 0){
        ItemToPurchase item = cartItems.get(i);
        String description = item.getDescription();
        itp.setDescription(description);
        int price = item.getPrice();
        itp.setPrice(price);
        item.setPrice(itp.getPrice());
        if(item.getDescription().compareTo("")!=0||item.getPrice()!=0||item.getQuantity()!=0){
          cartItems.set(i,itp);
        }
      }
      else{
        noPrint += 1;
      }
    }
    if(noPrint == cartItems.size()){
      System.out.println("Item not found in cart. Nothing modified.");
    }
  }
  public int getNumItemsInCart(){
    return cartItems.size();
  }
  public int getCostOfCart(){
    int total = 0;
    for(int i =0; i<cartItems.size(); i++){
      total += cartItems.get(i).getPrice()*cartItems.get(i).getQuantity();
    }
    return total;
  }
  public void printTotal(){
    int subTot = 0;
    int items = 0;
    if(cartItems.size()>0){
      for(int i=0; i<cartItems.size(); i++){
        ItemToPurchase itp = cartItems.get(i);
        items += itp.getQuantity();
      }
      System.out.println(getCustomerName()+"'s Shopping Cart - "+getDate()+"\nNumber of Items: "+items+"\n");
      for(int i=0; i<cartItems.size(); i++){
        ItemToPurchase itp = cartItems.get(i);
        subTot = itp.printItemCost();
        System.out.println(itp.getName()+" "+itp.getQuantity()+" @ $"+itp.getPrice()+" = $"+subTot);
      }
      System.out.println("\nTotal: $"+getCostOfCart());
    }
    else{
      System.out.println(getCustomerName()+"'s Shopping Cart - "+getDate()+"\nNumber of Items: 0\n\nSHOPPING CART IS EMPTY\n\nTotal: $0");
    }
  }
  public void printDescriptions(){
    System.out.println(getCustomerName()+"'s Shopping Cart - "+getDate()+"\n\nItem Descriptions");
    for(int i=0; i<cartItems.size(); i++){
      ItemToPurchase itp = cartItems.get(i);
      System.out.println(itp.getName()+": "+itp.printItemDescription());
    }
  }
}
