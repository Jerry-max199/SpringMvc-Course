package com.zzjm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.awt.event.MouseAdapter;

/**
 *@Controller:创建处理器对象，对象就放在springmvc容器中。
 * 位置：再类上面
 *
 * 能处理请求的控制器：MyController能处理请求，叫做后端控制器
 */
@Controller
public class MyController {
    /*
    处理用户提交的请求，springmvc中使用方法来处理的
    方法是自定义的，可以有多种返回值，多种参数，方法名称自定义
     */

    /**
     * 准备使用dosome方法来处理dome.do请求。
     * @RequestMapping:请求映射，作用是把一个请求地址和一个方法绑定在一起。一个请求指定一个方法来处理
     *      属性：1.value 是一个string，表示请求的url地址的（some.do）.
     *              value的值必须是唯一的，不能重复。在使用时，推荐地址以“/”开头
     *      位置：1.在方法的上面
     *           2.在类的上面
     *      说明：使用@RequestMapping修饰的方法叫做控制器方法，使用@RequestMapping修饰的方法是可以处理请求的，
     *      类似与servlet中doget，dopost
     *      返回值：ModelAndView 表示本次请求的处理结果、
     *      Model：数据，请求处理完成后，显示给用户的数据
     *      View:视图，比如jsp
     *
     */
    @RequestMapping(value = "/some.do")
    public ModelAndView dosome(){//相当于doget()----service请求处理
            //处理some.do请求。相当于service调用处理完成了
        ModelAndView mv=new ModelAndView();
            //添加数据，框架在请求的最后把数据放入到resquest作用域中
        mv.addObject("msg","欢迎使用springmvc做web项目开发");
        mv.addObject("fun","执行的是dosome方法");
            //指定视图的完整路径
            //框架对试图执行forward（重定向操作，request.getRequestDispatcher("/show.jsp").forward()）
        //mv.setViewName("/WEB-INF/view/show.jsp");
            //当配置了视图解析器后，可以使用逻辑名称（文件名），指定视图
            //框架会使用视图解析器的前缀＋后缀做成完整路径，这里就是字符串连接操作
        mv.setViewName("show");
            //返回mv
        return mv;
    }
}
