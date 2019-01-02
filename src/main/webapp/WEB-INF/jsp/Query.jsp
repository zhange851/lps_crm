<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>查询用户</title>
</head>
<body>
<table>
    <tr>
        <th>客户名称</th>
        <th>客户来源</th>
        <th>客户所属行业</th>
        <th>客户级别</th>
        <th>固定电话</th>
        <th>手机</th>
        <th>操作</th>
    </tr>
    <tr>
        <td>${custCell.cust_id}</td>
        <td>${custCell.cust_name}</td>
        <td>${custCell.cust_source}</td>
        <td>${custCell.cust_industry}</td>
        <td>${custCell.cust_level}</td>
        <td>${custCell.cust_phone}</td>
        <td>${custCell.cust_mobile}</td>
    </tr>
</table>
</body>
</html>