package aks.freshers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aks.freshers.service.firebase.FirebaseInit;

@RestController
@RequestMapping("/api")
public class FrController {

    @GetMapping("/test")
    public String test(){
        return FirebaseInit.getInstance().toString();
    }
}
