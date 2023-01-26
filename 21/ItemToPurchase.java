public class ItemToPurchase{
  private String itemName;
  private int itemPrice;
  private int itemQuantity;
  private String itemDescription;
  public ItemToPurchase(){
      itemName = "";
      itemDescription = "";
      itemPrice = 0;
      itemQuantity = 0;
  }
  public ItemToPurchase(String itemNam, String description, int price, int amount){
      itemName = itemNam;
      itemDescription = description;
      itemPrice = price;
      itemQuantity = amount;
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
  public String setDescription(String description){
    itemDescription = description;
    return itemDescription;
  }
  public String getDescription(){
    return itemDescription;
  }
  public int printItemCost(){
    int total = itemPrice*itemQuantity;
    return total;
  }
  public String printItemDescription(){
    String descript = itemDescription;
    return descript;
  }
}
