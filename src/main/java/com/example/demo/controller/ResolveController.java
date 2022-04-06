package com.example.demo.controller;

import com.example.demo.model.DecodeModel;
import com.example.demo.service.ResolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// API RESTful Controller for handling encryption resolve requests
@RequestMapping("api/v1/decode")
@RestController
@CrossOrigin("*")
public class ResolveController {
    
    // Resolve service for decoding the message using the flag
    final ResolveService service;
    
    @Autowired
    public ResolveController(ResolveService resolveService) {
        service = new ResolveService();
    }
    
    @PostMapping
    public DecodeModel resolve(@RequestBody DecodeModel model) {
        System.out.println("Got: " + model.toString());
        // use service resolving function for receiving a Decoded message Model
        DecodeModel decodeModel = service.resolve(model);
        System.out.println("Res: " + decodeModel.toString());
        // Respond to the request with a proper result: turn off the flag and return the decoded message as well
        return decodeModel;
    }
    
}
