package aks.freshers.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aks.freshers.model.Item;
import aks.freshers.service.firebase.DataReader;
import aks.freshers.service.firebase.DataWriter;
import aks.freshers.service.firebase.ICallback;

@Service
public class FrService {
    @Autowired
    private final DataWriter dataWriter;
    private final DataReader dataReader;
    public FrService(DataWriter dataWriter, DataReader dataReader){
        this.dataWriter = dataWriter;
        this.dataReader = dataReader;
    }

    public void addItem(Item item){
        dataWriter.writeData(item);
    }

    public void readData(String type, ICallback iCallback){
        dataReader.readData(type, new ICallback() {

            @Override
            public void callback(List<Item> itemsList) {
                if(itemsList != null){
                    iCallback.callback(itemsList);
                }
            }
        });
    }
}
