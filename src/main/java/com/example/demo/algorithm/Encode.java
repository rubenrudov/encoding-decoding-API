package com.example.demo.algorithm;

import java.util.Random;
import java.util.Stack;

/**
 * Class for encoding a text message from a word/pdf file
 */
public class Encode {
    
    // Encode props
    private int flag;
    private String msg;
    private String result;
    private Random rnd = new Random();
    
    /**
     * Encoding class c'tor
     * @param msg - String
     */
    public Encode(String msg) {
        this.msg = msg;
        flag = generateFlag();
        encode();
    }
    
    /**
     * Method for generating a new Flag
     * @return - triple digit number, the units represent ceaser cipher key, the tens represent offsets between chars and hundreds represent first stack index
     */
    private int generateFlag() {
        int firstInd, offset, ceaserKey;
        firstInd = 1 + rnd.nextInt(9);
        offset = 1 + rnd.nextInt(9);
        ceaserKey = 1 + rnd.nextInt(9);
        
        return firstInd * 100 + offset * 10 + ceaserKey;
    }
    
    /**
     * Method for processing the message into an encrypted message
     * The steps: Putting chars to stack, causing a reversed com.example.Encryptolog.encryption (2 steps at once, then, Ceaser'ing the result
     */
    private void encode() {
        Stack<Character> encryption = getEncryptionStack();
        result = stackFormat(encryption);
    }
    
    /**
     * Method for creating an com.example.Encryptolog.encryption stack
     * @return - Stack<Character>
     */
    private Stack<Character> getEncryptionStack() {
        Stack<Character> res = new Stack<>();
        
        for (int i = 0; i < flag / 100; i++) {
            res.push((char) ('a' + rnd.nextInt(26)));
        }
        
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) != ' ') {
                res.push((char) (msg.charAt(i) + flag % 10));
            }
            
            else {
                res.push((char)(32 + flag % 10));
            }
            
            for (int j = 1; j < flag / 10 % 10; j++) {
                res.push((char) ('a' + rnd.nextInt(26) + flag % 10));
            }
        }
        
        return res;
    }
    
    /**
     * Method for formatting the stack to a reversed string
     * @param encryption - Stack<Character>
     * @return - encrypted string
     */
    private String stackFormat(Stack<Character> encryption) {
        StringBuilder res = new StringBuilder();
        
        while (!encryption.isEmpty()) {
            res.append(encryption.pop());
        }
        
        return res.toString();
    }
    
    /**
     * Method for retrieving the com.example.Encryptolog.encryption result
     * @return - Encrypted String, ready to be payloaded into a new word/pdf file
     */
    public String getResult() {
        return result;
    }
    
    /**
     * Encryption debug method !!! will be removed in runtime
     * @return - 3 digit int
     */
    public int getFlag() {
        return flag;
    }
}
