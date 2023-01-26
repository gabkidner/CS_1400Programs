public class ItemToPurchase{
  private String itemName;
  private int itemPrice;
  private int itemQuantity;
  public ItemToPurchase(){
      itemName = "";
      itemPrice = 0;
      itemQuantity = 0;
  }
  public String setName(String itemNam){
    itemName = itemName.concat(itemNam);
    return itemNam;
   }
  public String getName(){
    return itemName;
  }
  public int setPrice(int price){
    itemPrice = price;
    return itemPrice;
  }
  public int getPrice(){
    return itemPrice;
  }
  public int setQuantity(int amount){
    itemQuantity = amount;
    return itemQuantity;
  }
  public int getQuantity(){
    return itemQuantity;
  }
}
