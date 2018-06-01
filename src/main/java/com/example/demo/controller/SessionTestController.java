package com.example.demo.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/session")
public class SessionTestController {
    @RequestMapping(value = "/set", method = RequestMethod.GET)
    public String setSession(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().setAttribute("name", "allen.yang");
        return "ok";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getSession(HttpServletRequest httpServletRequest) {
        Object nameInSession = httpServletRequest.getSession().getAttribute("name");
        return (String)nameInSession;
    }
}
