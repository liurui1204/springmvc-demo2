package com.LiuR.springmvc.file.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @Description 文件上传、下载
 * @Auther 刘瑞
 * @create 2022-01-15
 */
@Controller
@RequestMapping("file")
public class FileController {

    /**
     * 使用ResponseEntity实现文件下载
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("download")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws Exception {
        //获取ServletContext对象
        ServletContext context = session.getServletContext();
        //获取服务器中文件的真实路径
        String filePath = context.getRealPath("static/img/面试和笔试.txt");
        //创建输入流
        InputStream inputStream = new FileInputStream(filePath);
        //创建字节数组
        //inputStream.available():这个方法可以在读写操作前先得知数据流里有多少个字节可以读取
        byte[] bytes = new byte[inputStream.available()];
        //将流读到字节数组中
        inputStream.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        //URLEncoder.encode()解决文件名中文乱码
        headers.add("Content-Disposition","attachment;filename="+ URLEncoder.encode("面试和笔试.txt","UTF-8"));
        //设置响应头状态码
        HttpStatus status = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes,headers,status);
        //关闭输入流
        inputStream.close();
        return responseEntity;
    }

}
