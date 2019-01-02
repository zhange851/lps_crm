<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>新增用户</title>
    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script type="text/javascript">
        function jumpList() {
            alert("不进行新增操作了");
            window.location.href="<%=basePath%>customer/list.do";
        }
    </script>
</head>
<body>
<div>
    <form action="<%=basePath%>customer/insert.do" method="post">
        <div>
            <label for="insertCustomerName">客户名称</label>
            <input id="insertCustomerName" name="cust_name" />
        </div>
        <div>
            <label for="insertCustomerForm">客户来源</label>
            <select id="insertCustomerForm" name="cust_source">
                <option value="">--请选择</option>
                <c:forEach items="${fromType}" var="item">
                    <option value="${item.dict_id}">${item.dict_item_name}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label for="insertCustomerIndustry">所属行业</label>
            <select id="insertCustomerIndustry" name="cust_industry">
                <option value="">--请选择</option>
                <c:forEach items="${industryType}" var="item">
                    <option value="${item.dict_id}">${item.dict_item_name}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label for="insertCustomerLevel">客户级别</label>
            <select id="insertCustomerLevel"  name="cust_level">
                <option value="">--请选择</option>
                <c:forEach items="${levelType}" var="item">
                    <option value="${item.dict_id}">${item.dict_item_name}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label for="insertCustomerLinkman">联系人</label>
            <input id="insertCustomerLinkman" name="cust_linkman" />
        </div>
        <div>
            <label for="insertCustomerPhone">固定电话</label>
            <input id="insertCustomerPhone" name="cust_phone" />
        </div>
        <div>
            <label for="insertCustomerMobile">移动电话</label>
            <input id="insertCustomerMobile" name="cust_mobile" />
        </div>
        <div>
            <label for="insertCustomerZipcode">邮政编码</label>
            <input id="insertCustomerZipcode" name="cust_zipcode" />
        </div>
        <div>
            <label for="insertCustomerAddress">联系地址</label>
            <input id="insertCustomerAddress" name="cust_address" />
        </div>
        <div>
            <button type="submit">保存修改</button>
            <button type="button" onclick="jumpList()">不保存</button>
        </div>
    </form>
</div>
</body>
</html>