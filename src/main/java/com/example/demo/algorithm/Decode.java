package com.example.demo.algorithm;

import java.util.Stack;

/**
 * Class for decoding an encrypted text message from a word/pdf file
 */
public class Decode {
    
    // Decode props
    private int flag;
    private String encryptedMessage;
    private String result;
    
    /**
     * Decode object c'tor
     * @param flag - int triple digit number
     * @param encryptedMessage - encrypted string to decode
     */
    public Decode(int flag, String encryptedMessage) {
        this.flag = flag;
        this.encryptedMessage = encryptedMessage;
        decode();
    }
    
    /**
     * Method for processing the encrypted message back to the original message
     * The steps: reverse-engineering the original com.example.Encryptolog.encryption
     */
    private void decode() {
        char[] msgChars = encryptedMessage.toCharArray();
        decodeCeaser(msgChars);
        stackFormat(msgChars);
    }
    
    /**
     * Method for deciphering the ceaser cipher part of the wncrypted message
     * @param msgChars - char[]
     */
    private void decodeCeaser(char[] msgChars) {
        for (int i = 0; i < msgChars.length; i++) {
            msgChars[i] = (char)(msgChars[i] - flag % 10);
        }
    }
    
    /**
     * Method for formatting the stack to a string
     */
    private void stackFormat(char[] msgChars) {
        StringBuilder res = new StringBuilder();
        Stack<Character> decryption = new Stack<>();
        
        for (char c: msgChars) {
            decryption.push(c);
        }
        
        while (!decryption.isEmpty()) {
            res.append(decryption.pop());
        }
        
        result = res.toString();
        trimRandomChars();
    }
    
    /**
     * Finishing the decoding process by trimming the unnecessary characters
     */
    private void trimRandomChars() {
        StringBuilder decryption = new StringBuilder();
        int offset = flag / 10 % 10;
        int first = flag / 100;
        
        for (int i = first; i < result.length(); i += offset) {
            decryption.append(result.charAt(i));
        }
        
        result = decryption.toString();
    }
    
    /**
     * Method for retrieving the decryption result
     * @return - Decrypted string that the receiver can easily read.
     */
    public String getResult() {
        return result;
    }
}