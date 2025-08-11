package aks.freshers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aks.freshers.model.Item;
import aks.freshers.service.firebase.DataWriter;

@Service
public class FrService {
    @Autowired
    private final DataWriter dataWriter;
    public FrService(DataWriter dataWriter){
        this.dataWriter = dataWriter;
    }

    public void addItem(Item item){
        dataWriter.writeData(item);
    }
}
