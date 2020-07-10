package com.locke.order.controller;

import com.locke.order.model.ResponseMessage;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {


    @RequestMapping(value = "/test",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage index(){
        return new ResponseMessage("Hello World!");
    }

}
