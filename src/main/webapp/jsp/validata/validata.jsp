<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/5/23
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/static/h/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/static/h/js/bootstrap.min.js?v=3.3.6"></script>
    <!-- validate -->
    <script src="${pageContext.request.contextPath}/static/h/js/jquery.min.js?v=2.1.4"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>

    <script>
        var validator;
        $.validator.setDefaults({
            submitHandler: function() {
                alert("提交事件!");
            }
        });
        $().ready(function() {
            validator = $("#commentForm").validate();
        });

        function check(){
            var flag = validator.element("#cname");
            console.log(flag);
        }
    </script>
    <style>
        .error{
            color:red;
        }
    </style>
</head>
<body>
<form class="cmxform" id="commentForm" method="get" action="">
    <fieldset>
        <legend>输入您的名字，邮箱，URL，备注。</legend>
        <p>
            <label for="cname">Name (必需, 最小两个字母)</label>
            <input id="cname" name="name" minlength="2" class="" onblur="check()" type="text" required>
        </p>
        <p>
            <label for="cemail">E-Mail (必需)</label>
            <input id="cemail" type="email" name="email" required>
        </p>
        <p>
            <label for="curl">URL (可选)</label>
            <input id="curl" type="url" name="url">
        </p>
        <p>
            <label for="ccomment">备注 (必需)</label>
            <textarea id="ccomment" name="comment" required></textarea>
        </p>
        <p>
            <input class="submit" type="submit" value="Submit">
        </p>
    </fieldset>
</form>
</body>
</html>
