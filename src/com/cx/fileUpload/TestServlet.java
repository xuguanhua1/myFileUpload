package com.cx.fileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by cxspace on 16-7-7.
 */

public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取表单数据
        InputStream in = request.getInputStream();
        //转换流
        InputStreamReader inReader = new InputStreamReader(in);
        //缓冲流
        BufferedReader reader = new BufferedReader(inReader);

        String str = null;

        while ((str=reader.readLine())!=null){
            System.out.println(str);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             doPost(request,response);
    }
}
