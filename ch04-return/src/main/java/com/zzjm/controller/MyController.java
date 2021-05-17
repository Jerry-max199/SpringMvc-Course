package com.zzjm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzjm.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(value = "/returnString-view.do",method = RequestMethod.POST)
    public String returnStringview(HttpServletRequest request,String name, int age){
        System.out.println(name+age);
        //我们可以自己手工添加数据到request作用域
        request.setAttribute("myname",name);
        request.setAttribute("myage",age);
        //show:试图逻辑名称，项目中配置了视图解析器
        //框架对视图执行forword操作
        return "show";
    }
    //处理器方法返回void，相应ajax请求
    @RequestMapping(value = "/returnVoid-ajax.do",method = RequestMethod.POST)
    public void returnVoid(HttpServletResponse response, String name, Integer age) throws IOException {
        System.out.println(name+age);
        //处理ajax，使用json做数据格式
        //service调用完成了，使用student表示处理结果
        Student student=new Student();
        student.setName(name);
        student.setAge(age);
        String json="";
        //把结果的对象转换为json格式
        if (student !=null){
            ObjectMapper om=new ObjectMapper();
          json= om.writeValueAsString(student);
            System.out.println("student转换的json格式数据====="+json);
        }
        //输出数据响应ajax请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw=response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
    /**
     *处理器方法返回一个student，通过框架转为json，输出给ajax
     * @ResponseBody:
     *      作用：把处理器方法返回对象转为json后，通过HttpServletResonse输出给浏览器
     *      位置：方法的定义上面。和其他注解没有顺序关系
     * 返回对象框架的处理流程：
     * 1.框架会把返回student类型，调用框架中的ArrayList<HttpMessageConverter>的canwrite（）方法
     * 检查数据那个HttpMessageConverter接口的实现类能处理的student类型的数据--MappingJackson2HttpMessageConverter
     *
     * 2.框架会调用实现类的write(),MappingJackson2HttpMessageConverter的write（）方法
     *  把student对象转换为json，调用Jackson的ObjectMapper实现json
     *
     *  3.框架会调用@ResponseBody把结果数据输出到浏览器，ajax请求处理完成
     */

    @RequestMapping(value = "/returnStudent.do")
    @ResponseBody
    public Student doReturnStudent(){
        Student student=new Student();
        student.setName("李四同学");
        student.setAge(32);
        return student;
    }

    /**
     * 处理器方法返回list<>类型
     * 返回对象框架的处理流程：
     * 1.框架会把返回student类型，调用框架中的ArrayList<HttpMessageConverter>的canwrite（）方法
     * 检查数据那个HttpMessageConverter接口的实现类能处理的student类型的数据--MappingJackson2HttpMessageConverter
     *
     * 2.框架会调用实现类的write(),MappingJackson2HttpMessageConverter的write（）方法
     *  把student对象转换为json，调用Jackson的ObjectMapper实现json array
     *
     *  3.框架会调用@ResponseBody把结果数据输出到浏览器，ajax请求处理完成
     */
    @RequestMapping(value = "/returnlist.do")
    @ResponseBody
    public List<Student> returnList(){
        List<Student> list=new ArrayList<>();
        Student student=new Student();
        student.setName("李松亚");
        student.setAge(89);
        list.add(student);
        Student student1=new Student();
        student1.setName("小狗");
        student1.setAge(12);
        list.add(student1);
        return list;
    }
    /**
     * 处理器返回一个String,string表示数据，不是视图
     * 区分视图和数据的方法，看有没有@ResponseBody注解
     * 如果有@Response注解时数据，反之是视图
     * 默认使用的是text/plain;charset=Iso-8899-1"作为contentType,导致中文乱码
     * 解决方案：给ResquestMapping增加一个属性produce，这个属性指定新的字符集
     * 返回对象框架的处理流程：
     * 1.框架会把返回student类型，调用框架中的ArrayList<HttpMessageConverter>的canwrite（）方法
     * 检查数据那个HttpMessageConverter接口的实现类能处理的S类型tring的数据--StringHttpMessageConverter
     *
     * 2.框架会调用实现类的write(),StringHttpMessageConverter的write（）方法
     *  把字符按照指定的编码处理
     *
     *  3.框架会调用@ResponseBody把结果数据输出到浏览器，ajax请求处理完成
     */
    @RequestMapping(value = "/returnString.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringDate(){
        return "hello springmvc 返回对象，表示数据";
    }
}
