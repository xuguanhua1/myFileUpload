<%--
  Created by IntelliJ IDEA.
  User: cxspace
  Date: 16-7-7
  Time: 下午10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>文件上传</title>
  </head>
  <body>
      <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/FileUpload">
        用户名：<input type="text" name="username"><br>
        文件：<input type="file" name="file">
        <br>
        <input type="submit">
      </form>
  </body>
</html>
