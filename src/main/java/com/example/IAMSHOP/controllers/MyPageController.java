package com.example.IAMSHOP.controllers;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/mypage")
public class MyPageController {

    @RequestMapping(value="/index", method= RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getIndex(){
        ModelAndView modelAndView = new ModelAndView("user/myPage");
        return modelAndView;
    }

    @RequestMapping(value="/modify", method= RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getModify(){
        ModelAndView modelAndView = new ModelAndView("user/modify");
        return modelAndView;
    }

}
