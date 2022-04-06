package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

// This is a Model for decoding messages
public class DecodeModel {
    
    // Props
    private final UUID id;
    private final String content;
    private final int flag;
    
    /**
     * DecodeModel constructor by Json properties (id, content)
     * @param id - UUID
     * @param content - String
     */
    public DecodeModel(
            @JsonProperty("id") UUID id,
            @JsonProperty("content") String content,
            @JsonProperty("flag") int flag
    ) {
        this.id = id;
        this.content = content;
        this.flag = flag;
    }
    
    /**
     * Method for retrieving UUID id
     * @return - UUID
     */
    public UUID getId() {
        return id;
    }
    
    /**
     * Method for retrieving a String content
     * @return - String
     */
    public String getContent() {
        return content;
    }
    
    public int getFlag() {
        return flag;
    }
    
    /**
     * To string method for Person model
     * @return - String
     */
    @Override
    public String toString() {
        return String.format("new Decode:{ id: %s, content: %s, flag: %d }", id, content, flag);
    }
}
