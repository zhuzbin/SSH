<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="zhangfn" uri="/tld/zhang-functions.tld" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - Bootstrap Table</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="${pageContext.request.contextPath}/static/h/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/h/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/h/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/h/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/h/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/bootstrap-select/css/bootstrap-select.min.css">
    <script>
        function retBtn(){
            window.location.href = "${pageContext.request.contextPath}/user";
        }

        function subBtn(){
            $("#myForm").submit();
        }
    </script>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>增加用户</h5>
                </div>
                <div class="ibox-content">
                    <form id="myForm" method="post" class="form-horizontal" action="${pageContext.request.contextPath}/user/create">
                        <!-- 开始：放入隐藏的input -->
                        <input type="text" hidden="hidden" name="roleIds" id="roleIds" value="" />
                        <!-- 结束：放入隐藏的input -->

                        <div class="form-group">
                            <label class="col-sm-1 control-label">用户名：</label>

                            <div class="col-sm-7">
                                <input name="username" class="form-control"/>
                            </div>
                        </div>

                        <div class="hr-line-dashed"></div>

                        <div class="form-group">
                            <label class="col-sm-1 control-label">密码：</label>

                            <div class="col-sm-7">
                                <input type="password" name="password" class="form-control">
                            </div>
                        </div>

                        <div class="hr-line-dashed"></div>

                        <div class="form-group">
                            <label class="col-sm-1 control-label">角色：</label>

                            <div class="col-sm-7">
                                <select class="form-control m-b" name = "roleIds" id="roleIds" multiple="">
                                    <c:forEach var="obj" items="${roleList}">
                                        <option value="${obj.id}">${obj.role}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="hr-line-dashed"></div>

                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <a class="btn btn-primary" href="javascript:subBtn();">提交</a>
                                <a class="btn btn-default" href="javascript:retBtn();">返回</a>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>


</div>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/static/h/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/static/h/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/static/bootstrap-select/js/bootstrap-select.min.js"/>
<script src="${pageContext.request.contextPath}/static/bootstrap-select/js/i18n/defaults-zh_CN.js"/>

</body>
</html>