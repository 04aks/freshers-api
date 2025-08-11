package aks.freshers.model;

public class Item {
    String owner; // IGN 
    ItemType type; // 
    int price; // either viles or coins 

    public Item(){}

    public Item(String owner, ItemType type, int price){
        this.owner = owner;
        this.type = type;
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }
    public ItemType getType() {
        return type;
    }
    public int getPrice() {
        return price;
    }

    public enum ItemType{
        SWORD, BOW, RED_PANTS, ORANGE_PANTS, YELLOW_PANTS, GREEN_PANTS, BLUE_PANTS
    }
}



