package aks.freshers.service.firebase;

import java.util.List;
import aks.freshers.model.Item;

public interface ICallback {
    public void callback(List<Item> itemsList);
}
