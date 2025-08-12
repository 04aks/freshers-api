package aks.freshers.service.firebase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import aks.freshers.model.Item;

@Component
public class DataReader {
    private FirebaseDatabase firebaseDatabase;
    
    public DataReader(){
        firebaseDatabase = FirebaseInit.getInstance();
    }

    public void readData(String type, ICallback iCallback){
        
        List<Item> itemsList = new ArrayList<>();
        DatabaseReference ref = firebaseDatabase.getReference("items/" + type);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
            
                for(DataSnapshot ss : snapshot.getChildren()){
                    Object obj = ss.getValue();
                    if(obj instanceof Map){
                        
                        @SuppressWarnings("unchecked")
                        Map<String, Object> data = (Map<String, Object>) obj;

                        String owner = (String) data.get("owner");
                        int type = ((Number) data.get("type")).intValue();
                        int price = ((Number) data.get("price")).intValue();

                        Item item = new Item(owner, type, price);
                        itemsList.add(item);
                    }
                }
                // send data back to where this method is called from on some real shi
                iCallback.callback(itemsList);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.err.println(error.getMessage());
            }
            
        });
    }
}
