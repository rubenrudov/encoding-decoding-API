package com.example.demo.controller;

import com.example.demo.model.EncodeModel;
import com.example.demo.service.EncodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/encode")
@RestController
@CrossOrigin("*")
public class EncryptionController {
    
    final EncodeService service;
    
    @Autowired
    public EncryptionController(EncodeService encodeService) {
        service = new EncodeService();
    }
    
    @GetMapping
    public EncodeModel getEncryptedMessage(@RequestBody EncodeModel model) {
        System.out.println("Got: " + model.toString());
        EncodeModel encodeModel = service.getEncryptedMessage(model);
        System.out.println("Res: " + encodeModel.toString());
        return encodeModel;
    }
    
}
