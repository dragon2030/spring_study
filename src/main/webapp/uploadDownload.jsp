<%--
  Created by IntelliJ IDEA.
  User: G003759
  Date: 2020/9/30
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploadDownload</title>
</head>
<body>
    <form action="ServletUpload" enctype="multipart/form-data" method="post">
        选择文件<input type="file" name="file1" id="file1">
        <input type="submit" name="upload" value="上传">
    </form>
</body>
</html>
