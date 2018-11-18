package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.vo.VueLoginInfoVo;
import com.example.demo.enums.ResultCode;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class AccountController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            String message = String.format("登录失败，详细信息【%s】。", bindingResult.getFieldError().getDefaultMessage());
            return new Result(ResultCode.FAIL.code, message, null);
        }

        if (!loginInfoVo.getUsername().equals("allen") || !loginInfoVo.getPassword().equals("123456")) {
            String message = String.format("登录失败，用户名或密码不正确");
            return new Result(ResultCode.FAIL.code, message, null);
        }

        HttpSession session = request.getSession();
        session.setAttribute("username", loginInfoVo.getUsername());
        session.setAttribute("password", loginInfoVo.getPassword());

        return new Result(ResultCode.SUCCESS.code, "登录成功", null);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = String.format("注册失败，详细信息【%s】。", bindingResult.getFieldError().getDefaultMessage());
            return new Result(ResultCode.FAIL.code, message, null);
        }

        return new Result("ok");
    }

}
