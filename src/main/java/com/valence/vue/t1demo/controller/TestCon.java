package com.valence.vue.t1demo.controller;

import com.valence.vue.t1demo.bean.BasicBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/testCon")
public class TestCon {
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BasicBean addAssessItems(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//    @PostMapping(value = "/login")
//    public BasicBean addAssessItems(@RequestBody User user) {
//        String username = user.getUsername();
//        String password = user.getPassword();
        BasicBean basicBean;
        if ("admin".equals(username) && "123456".equals(password)) {
            // token 已失效
            basicBean = new BasicBean(0, 10000);
        } else {
            basicBean = new BasicBean(1000, 10000);
        }
        return basicBean;
    }
}
