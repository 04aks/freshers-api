package aks.freshers.model;

import java.util.HashMap;
import java.util.Map;

public class Item {
    String owner; // IGN 
    int type; // 
    int price; // either viles or coins 

    public Item(){}

    public Item(String owner, int type, int price){
        this.owner = owner;
        this.type = type;
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }
    public int getType() {
        return type;
    }
    public int getPrice() {
        return price;
    }

    public enum ItemType{
        SWORD(1), 
        BOW(2), 
        RED_PANTS(3), 
        ORANGE_PANTS(4), 
        YELLOW_PANTS(5), 
        GREEN_PANTS(6), 
        BLUE_PANTS(7);

        private int value;
        private static final Map<Integer, ItemType> lookup = new HashMap<>();

        static{
            for(ItemType itemType : ItemType.values()){
                lookup.put(itemType.getValue(), itemType);
            }
        }

        ItemType(int value){
            this.value = value;
        }
        public int getValue(){return value;};
        public static ItemType fromValue(int v){
            
            ItemType type = lookup.get(v); 
            if(type != null){
                return type;
            }
            
            throw new IllegalArgumentException("unknown ID: " + v);
        }
    }
}



