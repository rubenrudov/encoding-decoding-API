package com.example.demo.controller;

import com.example.demo.algorithm.Decode;
import com.example.demo.model.DecodeModel;
import com.example.demo.model.EncodeModel;
import com.example.demo.service.EncodeService;
import com.example.demo.service.ResolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/decode")
@RestController
@CrossOrigin("*")
public class ResolveController {
    
    final ResolveService service;
    
    @Autowired
    public ResolveController(ResolveService resolveService) {
        service = new ResolveService();
    }
    
    @GetMapping
    public DecodeModel resolve(@RequestBody DecodeModel model) {
        System.out.println("Got: " + model.toString());
        DecodeModel decodeModel = service.resolve(model);
        System.out.println("Res: " + decodeModel.toString());
        return decodeModel;
    }
    
}
