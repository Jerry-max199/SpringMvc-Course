package com.zzjm.controller;


import com.zzjm.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    /**
     * 逐个接收请求参数：
     *      要求：处理器（控制器）方法的形参名和请求中参数名必须保持一致
     *              同名的请求参数赋值给同名的形参
     * 框架接收请求参数
     *      1.使用request对象接收请求参数
     *          request strName=request.getParameter("name");
     *          request strAge=request.getParameter("age");
     *      2.springmvc框架通过DispatcherServlet调用MyController的doSome()方法
     *          调用方法时，按名称对应，把接收的参数赋值给形参
     *          doSome(strName,Integer,valueOf(strAge))
     *          框架会提供类型转换的功能，能把String转为int long float等类型
     *   400状态码时客户端错误，表示提交请求参数过程中，发生问题
     *   Intarge是可以接收null的
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/receiveParam.do",method = RequestMethod.POST)
    public ModelAndView doOther(String name,int age){
        //可以在方法中直接使用name，age的值
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }
    /**
     * 请求参数名和处理器方法中的形参名不一样
     * @RequestParam:逐个接收参数中，解决请求中参数名形参名不一样问题
     *           属性：1.value 请求中的参数名称不一样
     *                2.required 是一个Boolean，默认是true
     *                      true：表示请求中必须包含此参数
     *           位置：在处理器方法的形参定义前面
     */
    @RequestMapping(value = "/receiveproperty.do")
    public ModelAndView receiveproperty(@RequestParam(value = "rname",required = false) String name,
                                        @RequestParam(value = "rage",required = false) Integer age){
        System.out.println(name+age);
        //可以在方法中直接使用name，age的值
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }

    /**
     * 处理器对象形参就是java对象，这个对象的属性名和请求中的形参名是一样的
     * 框架会自动创建形参的java对象，给属性赋值，请求中的参数时nama，框架会自动调用setName()方法
     * @param student
     * @return
     */
    @RequestMapping(value = "/receiveObject.do")
    public ModelAndView receiveObject(Student student){
        //可以在方法中直接使用name，age的值
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",student.getName());
        mv.addObject("myage",student.getAge());
        mv.setViewName("show");
        return mv;
    }
}
