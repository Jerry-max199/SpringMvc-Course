package com.zzjm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzjm.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    /**
     * 处理器方法返回一个String---表示逻辑视图名称，需要配置视图解析器
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/some")
    public ModelAndView dosom(String name, int age) {
        System.out.println(name + age);
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }
}
