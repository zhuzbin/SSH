<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/5/22
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/Huploadify/Huploadify.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/Huploadify/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/Huploadify/jquery.Huploadify.js"></script>

    <script>
        $(function(){
            $(function(){
                $('#upload').Huploadify({
                    auto:true,
                    fileTypeExts:'*.jpg;*.png;*.exe',
                    multi:true,
                    fileSizeLimit:9999,
                    showUploadedPercent:false,//是否实时显示上传的百分比，如20%
                    showUploadedSize:false,
                    removeTimeout:9999999,
                    uploader:'${pageContext.request.contextPath}/uploadFile/upload',
                    onUploadStart:function(){
                        //alert('开始上传');
                    },
                    onInit:function(){
                        //alert('初始化');
                    },
                    onUploadComplete:function(data){
                        //alert('上传完成');
                        console.log(data);
                    },
                    onDelete:function(file){
                        console.log('删除的文件：'+file);
                        console.log(file);
                    },
                    onUploadSuccess:function(file,data,response){
                        $("#imgs").attr("src","http://localhost:8080/"+data);
                        $("#imgs").css("display","block");
                        console.log(data);
                    }
                });
            });
        })
    </script>
</head>
<body>
<span id="upload"></span>
<img  id="imgs" style="display: none;width: 100px;height: 100px;" />
</body>
</html>
