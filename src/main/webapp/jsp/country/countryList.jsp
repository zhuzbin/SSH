<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/1/30
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>查询条件</h5>
            </div>
            <div class="ibox-content">
                <form method="get" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-1 control-label">普通条件</label>

                        <div class="col-sm-2">
                            <input type="text" id="countryName" class="form-control">
                        </div>

                        <label class="col-sm-1 control-label">普通条件</label>

                        <div class="col-sm-2">
                            <input type="text" id="countryCode" class="form-control">
                        </div>

                        <label class="col-sm-1 control-label">普通条件</label>

                        <div class="col-sm-2">
                            <input type="text" class="form-control">
                        </div>

                        <label class="col-sm-1 control-label">普通条件</label>

                        <div class="col-sm-2">
                            <input type="text" class="form-control">
                        </div>
                    </div>
                    <div class="hr-line-dashed"></div>

                    <div class="form-group">
                        <div class="col-sm-7 col-sm-offset-5">
                            <button class="btn btn-white" type="reset">重置</button>
                            <span class="col-sm-offset-1"></span>
                            <button class="btn btn-primary" type="button" onclick="sub()">查询</button>
                        </div>
                    </div>

                </form>
            </div>
        </div>

        <div id="toolbar" class="btn_group">
            <button id="btn_add" type="button" class="btn btn-primary" onclick="add()">新增</button>
            <button id="btn_add" type="button" class="btn btn-primary" onclick="update()">修改</button>
            <button id="btn_add" type="button" class="btn btn-primary" onclick="del()">批量删除</button>
        </div>

        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>城市列表</h5>
            </div>
            <div class="ibox-content">
                <div class="row row-lg">
                    <div class="col-sm-12">
                        <!-- Example Card View -->
                        <table id="table"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>


<!-- 全局js -->
<script src="${pageContext.request.contextPath}/static/h/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/static/h/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->


<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/static/h/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/static/h/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/static/h/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>


<script>
    $(function(){
        $('#table').bootstrapTable({
            url: '/country/getList',
            dataType:"json",
            method:'get',
            striped:true, // 是否显示行间色
            pagination:true, // 是否显示分页
            paginationLoop:false, //分页是否循环
            toolbar:'#toolbar',//设置toolbar
            toolbarAlign:'right',//设置toolbar位置
            sidePagination: "server", // 请求资源
            queryParamsType : "",
            queryParams : getParams,
            pageSize :3, // 每页显示条数
            pageNumber:1,//显示页数
            pageList:[1,5,10,50],
            paginationPreText:'上一页',
            paginationNextText:'下一页',
            columns: [{
                field: 'id',
                title: 'Item ID'
            }, {
                field: 'countryName',
                title: 'Item countryName'
            }, {
                field: 'countryCode',
                title: 'Item countryName'
            }]
        });
    });

    //获取参数
    function getParams(params) {
        var temp = {
            pageSize : params.pageSize,
            pageNumber : params.pageNumber,
            countryName:$("#countryName").val(),
            countryCode:$("#countryCode").val()
        };
        return temp;
    }

    //提交查询
    function sub(){
        $("#table").bootstrapTable('refresh');
    }

    //跳转到增加页面
    function add() {

    }

    //跳转到修改页面
    function update(){

    }

    //删除数据
    function del(){

    }
</script>
</body>
</html>
