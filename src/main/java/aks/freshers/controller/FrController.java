package aks.freshers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import aks.freshers.model.Item;
import aks.freshers.service.FrService;
import aks.freshers.service.firebase.FirebaseInit;

@RestController
@RequestMapping("/api")
public class FrController {

    private final FrService frService;
    @Autowired
    public FrController(FrService frService){
        this.frService = frService;
    }

    @GetMapping("/test")
    public String test(){
        return FirebaseInit.getInstance().toString();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestBody Item item){
        frService.addItem(item);
        return ResponseEntity.ok("Item added successfully");
    }
}
