package aks.freshers.service.firebase;

import org.springframework.stereotype.Component;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import aks.freshers.model.Item;

@Component
public class DataWriter {
    private static FirebaseDatabase firebaseDatabase;

    public DataWriter(){
        firebaseDatabase = FirebaseInit.getInstance();
    }

    public void writeData(Item item){
        DatabaseReference ref = firebaseDatabase.getReference("Items");
        DatabaseReference newItemRef = ref.push();
        
        newItemRef.setValueAsync(item); 
    }
}
