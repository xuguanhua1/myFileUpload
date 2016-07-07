package com.cx.fileUpload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by cxspace on 16-7-7.
 */
@WebServlet(name = "FileUpload")
public class FileUpload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.创建文件上传工厂类
        FileItemFactory fac = new DiskFileItemFactory();

        //2.创建文件上传核心对象
        ServletFileUpload upload = new ServletFileUpload(fac);
        //单文件最大值
        upload.setFileSizeMax(30*1024*1024);

        //全部文件最大值
        upload.setSizeMax(50*1024*1024);

        //3.判断当前是否为文件上传表单
        if (upload.isMultipartContent(request)){
            //把请求数据转换为FileItem集合
            try {
                List<FileItem> list = upload.parseRequest(request);

                for (FileItem item : list){
                    if (item.isFormField())
                    {
                        // 普通表单
                        String fieldName = item.getFieldName();  //文本框名称
                        String content = item.getString("UTF-8"); //文本框值

                        System.out.println(fieldName+content);
                    }
                    else
                    {
                        String name = item.getName();



                        String basePath = getServletContext().getRealPath("/upload");


                        //新建一个文件类，处理没有当前目录文件夹，就自动创建一个的逻辑

                        File file = new File(basePath);

                        if(!file.exists()&&!file.isDirectory())
                        {
                            file.mkdir();
                        }


                        File upfile = new File(basePath,name);


                        item.write(upfile);

                        item.delete();

                    }
                }

            } catch (FileUploadException e) {
                System.out.println("当前表单不是文件上传表单");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
