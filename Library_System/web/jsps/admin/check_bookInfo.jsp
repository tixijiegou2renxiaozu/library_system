<%@ page import="java.util.List" %>
<%@ page import="model.Book" %><%--
  Created by IntelliJ IDEA.
  User: lx
  Date: 2019/1/22
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑文献信息</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/foundation/5.5.3/css/foundation.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/foundation/5.5.3/js/foundation.min.js"></script>
    <script src="https://cdn.bootcss.com/foundation/5.5.3/js/vendor/modernizr.js"></script>

    <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">

    <style rel="stylesheet">
        .yuan{
            width: 100px;
            height: 100px;
            background-color: white;
            border-radius: 50%;
            border:1px solid #ccc;
        }
        .one,.two{
            width: 50%;
            height: 30px;
            float: left;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
<%
    List<Book> bookList = (List<Book>) session.getAttribute("bookInfoList");
    String username = (String) session.getAttribute("username");
%>
<div class="panel panel-info">
    <!--标题-->
    <div class="panel-heading">
        <b class="panel-title">图书馆信息系统</b>
        <!--左边-->
        <div align="right">
            <b id="b_userId" style="alignment: right">管理员：<%=username%></b>
            <form method='GET' action="/admin_login">
                <input class="btn btn-default" style="alignment: right" type='submit' name='Logout' value='Logout'>
            </form>
        </div>
    </div>

    <!--内容-->
    <div class="panel-body">
        <div class="row" style="height: 2000px">
            <!--左边-->
            <div class="col-md-3" style="background-color: white;box-shadow: inset 1px -1px 1px #fffb4b, inset -1px 1px 1px #fffe7a;height: 70%;" align="center">
                <ul class="no-bullet">
                    <li>
                        <br>
                        <div class="yuan" align="center">
                            <br>
                            <i class="fa fa-user-o" style="font-size:30px"></i>
                            <br>
                            <b>系统管理</b>
                        </div>
                    </li>
                    <br>
                    <li>
                        <button type="button" class="button secondary" style="width: 100%" onclick="javascript:location.href='/check_user_data'"><a href="/check_user_data">用户信息</a></button>
                    </li>
                    <li>
                        <button type="button" class="button secondary" style="width: 100%" onclick="javascript:location.href='/check_bollowing'"><a href="/check_bollowing">借阅记录</a></button>
                    </li>
                    <li>
                        <button type="button" class="button secondary" style="width: 100%" onclick="javascript:location.href='/check_bookInfo'"><a href="/check_bookInfo" style="color: #FF0543">书籍信息</a></button>
                    </li>
                    <li>
                        <button type="button" class="button secondary" style="width: 100%" onclick="javascript:location.href='/check_user_changed'"><a href="/check_user_changed">用户信息修改记录</a></button>
                    </li>
                </ul>
            </div>

            <!--右边-->
            <div class="col-md-9" style="background-color: white;box-shadow: inset 1px -1px 1px #f7ff62, inset -1px 1px 1px #fff626;height: 70%;">
                <br>
                <br>
                <div class="panel panel-default">
                    <form method="get" action="/modify_book">
                    <table class="table" id="project">
                        <tr><th>书籍ID</th><th>名称</th><th>类型</th><th>作者</th><th>出版社</th><th>逾期每日罚款</th><th>状态</th><th>操作</th></tr>

                        <%
                            for(int i=0;i<bookList.size();i++){
                                out.println("<tr>\n" +
                                        "<td>"+bookList.get(i).getId()+"</td><td>"+bookList.get(i).getName()+"</td>" +
                                        "<td>"+bookList.get(i).getType()+"</td><td>"+bookList.get(i).getAuthor()+"</td>" +
                                        "<td>"+bookList.get(i).getPublishCompany()+"</td><td>" +bookList.get(i).getFineMoneyPerDay()+"</td><td>"+bookList.get(i).getState()+
                                        "</td><td><button name='change' type='submit' value='"+bookList.get(i).getId()+"'>修改</button></td>" +
                                        "</tr>");
                            }
                        %>
                    </table></form>
                </div>
                <a href="/add_book"><button >添加书籍入库</button></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
