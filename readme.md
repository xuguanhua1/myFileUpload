#自己手动写一个上传文件工具

#核心API
-FileItemFactory   文件上传工厂类

      fac.setRepository();  //设置临时目录

-ServletFileUpload  文件上传核心类，可以获取所有的fileitem

       List<FileItem> parseRequest(request);  拿到文件对象集合

       isMultipartContent(request); 判断表单类型

       upload.setFileSizeMax(10);  设置单个文件最大大小

       upload.setSizeMax(100); 设置总文件最大大小

       upload.setHeaderEncoding; 设置上传文件名的编码
|-FileItem

       item.getFieldName();   获取上传表单元素名称

       item.getString(); 获取上传数据

       item.getSring("UTF-8")  获取上传文件数据，处理中文

       item.getContentType();  获取上传文件类型[文件项]

       item.getInputStream();  获取文件流[文件项目]

       item.getName();  获取文件名

       item.write(file); 写文件

       item.delete();删除临时文件

