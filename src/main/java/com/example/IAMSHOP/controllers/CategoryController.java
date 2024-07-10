package com.example.IAMSHOP.controllers;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/category")
public class CategoryController {




    @RequestMapping(value="/product", method= RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getProduct(){
        ModelAndView modelAndView = new ModelAndView("home/product");
        return modelAndView;
    }
}
