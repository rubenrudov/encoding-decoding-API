package com.example.demo.controller;

import com.example.demo.model.EncodeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("api/v1")
@Controller
@CrossOrigin("*")
public class DocumentationController {
    
    @Autowired
    public DocumentationController() {
    
    }
   
    @GetMapping
    @ResponseBody
    public ModelAndView documentation() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("docu.html");
        return modelAndView;
    }
}
