package com.zhjie.ithenticate.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/ithenticate")
public class IthenticateController {

//  跳转页面
	@RequestMapping("/ithenticateHome/portal")
    public String ithenticateHome(){
        return "ithenticate/ithenticateHome";
    }
	
//  跳转页面
	@RequestMapping("/ithenticateTop/portal")
    public String ithenticateTop(){
        return "ithenticate/top";
    }
	
//  跳转页面
	@RequestMapping("/ithenticateLeft/portal")
    public String ithenticateLeft(){
        return "ithenticate/left";
    }
//  跳转页面
	@RequestMapping("/ithenticateContent/portal")
    public String ithenticateContent(){
        return "ithenticate/content";
    }
	
	/*
     *采用spring提供的上传文件的方法
     */
    @RequestMapping("/paperUpload")
    @ResponseBody
    public String  paperUpload(HttpServletRequest request)
    {
        long  startTime=System.currentTimeMillis();
         //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path="E:/springUpload/"+file.getOriginalFilename();
                    //上传
                    try {
						file.transferTo(new File(path));
					} catch (IllegalStateException e) {
						 return "上传失败";
					} catch (IOException e) {
						 return "上传失败";
					}
                }
            }
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");
    return "上传成功";  
    }
}
