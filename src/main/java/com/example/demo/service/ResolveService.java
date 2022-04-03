package com.example.demo.service;

import com.example.demo.algorithm.Decode;
import com.example.demo.algorithm.Encode;
import com.example.demo.model.DecodeModel;
import com.example.demo.model.EncodeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Class for Encoding service
 * Returns the encoded message and the flag of it for saving to database through the app
 */
@Service
public class ResolveService {
    
    Decode decode;
    DecodeModel response;
    
    /**
     * Auto wired method for creating the Encode service
     */
    @Autowired
    public ResolveService() {
        decode = null;
        response = null;
    }
    
    /**
     * GET method for retrieving an encrypted message
     * @return - New encode model with encoded message and a new flag
     */
    @GetMapping
    public DecodeModel resolve(DecodeModel decodeModel) {
        decode = new Decode(decodeModel.getFlag(), decodeModel.getContent());
        
        // Prepare a response
        response = new DecodeModel(decodeModel.getId(), decode.getResult(), 0);
        
        System.out.println("Response: " + response.toString());
        // Return the response to the api controller
        return response;
    }
}