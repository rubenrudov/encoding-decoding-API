package com.example.demo.service;

import com.example.demo.algorithm.Encode;
import com.example.demo.model.EncodeModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

/**
 * Class for Encoding service
 * Returns the encoded message and the flag of it for saving to database through the app
 */
@Service
public class EncodeService {
    
    Encode encode;
    EncodeModel response;
    
    /**
     * Auto wired method for creating the Encode service
     */
    @Autowired
    public EncodeService() {
        encode = null;
        response = null;
    }
    
    /**
     * GET method for retrieving an encrypted message
     * @return - New encode model with encoded message and a new flag
     */
    @GetMapping
    public EncodeModel getEncryptedMessage(EncodeModel encodeModel) {
        encode = new Encode(encodeModel.getContent());
        
        // Prepare a response
        response = new EncodeModel(encodeModel.getId(), encode.getResult(), encode.getFlag());
    
        System.out.println("Response: " + response.toString());
        // Return the response to the api controller
        return response;
    }
}
