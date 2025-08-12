package aks.freshers.service.firebase;

import org.springframework.stereotype.Component;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import aks.freshers.model.Item;
import aks.freshers.model.Item.ItemType;
import aks.freshers.service.utils.FirebasePaths;

@Component
public class DataWriter {
    private static FirebaseDatabase firebaseDatabase;

    public DataWriter(){
        firebaseDatabase = FirebaseInit.getInstance();
    }

    public void writeData(Item item){
        String path = "";

        String itemName = ItemType.fromValue(item.getType()).toString();
        
        if(itemName.toLowerCase().contains("pants")){path = FirebasePaths.DB_PANTS;}
        if(itemName.toLowerCase().equals("sword")){path = FirebasePaths.DB_SWORD;}
        if(itemName.toLowerCase().equals("bow")){path =  FirebasePaths.DB_BOW;}

        DatabaseReference ref = firebaseDatabase.getReference(path);
        DatabaseReference newItemRef = ref.push();
        
        newItemRef.setValueAsync(item); 
    }
}
