package com.zzjm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @RequestMapping("/test")
 * value:所有请求地址的公共部分，叫做模块名称
 * 位置放在类上面。
 *
 */
@RequestMapping("/test")
@Controller
public class MyController {
    /**
     * @RequestMapping:请求映射
     *                  属性method,表示请求的方式，他的值是RequestMethod类的枚举值
     *                  例如表示get请求方式method= RequestMethod.GET
     *                  post请求方式：method = RequestMethod.POST。
     * 用错方式汇报405错误，
     * @return
     */
    @RequestMapping(value = "/some.do",method= RequestMethod.GET)
    public ModelAndView dosome(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc做web项目开发");
        mv.addObject("fun","执行的是dosome方法，这是一个get请求");
        mv.setViewName("show");
        return mv;
    }
    @RequestMapping(value = "/other.do",method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc做web项目开发");
        mv.addObject("fun","执行的是doOther方法，这是一个post请求");
        mv.setViewName("show");
        return mv;
    }
    @RequestMapping(value = "/fist.do")
    public ModelAndView dofirst(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc做web项目开发");
        mv.addObject("fun","执行的是doOther方法，这是一个post请求"+request.getParameter("name"));
        mv.setViewName("show");
        return mv;
    }
}
