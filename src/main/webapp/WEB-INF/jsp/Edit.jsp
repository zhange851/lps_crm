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
    <title>编辑用户</title>
    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script type="text/javascript">
        function jumpList() {
            alert("不保存修改了");
            window.location.href="<%=basePath%>customer/list.do";
        }
    </script>
</head>
<body>
<div>
    <form action="<%=basePath%>customer/updateNew.do?cust_id=${custCell.cust_id}" method="post">
        <div>
            <label for="editCustomerName">客户名称</label>
            <input id="editCustomerName" name="cust_name" value="${custCell.cust_name}" />
        </div>
        <div>
            <label for="editCustomerForm">客户来源</label>
            <select id="editCustomerForm" name="cust_source">
                <option value="">--请选择</option>
                <c:forEach items="${fromType}" var="item">
                    <option value="${item.dict_id}" <c:if test="${item.dict_id == custCell.cust_source}">selected</c:if>>${item.dict_item_name}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label for="editCustomerIndustry">所属行业</label>
            <select id="editCustomerIndustry" name="cust_industry">
                <option value="">--请选择</option>
                <c:forEach items="${industryType}" var="item">
                    <option value="${item.dict_id}" <c:if test="${item.dict_id == custCell.cust_industry}">selected</c:if>>${item.dict_item_name}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label for="editCustomerLevel">客户级别</label>
            <select id="editCustomerLevel"  name="cust_level">
                <option value="">--请选择</option>
                <c:forEach items="${levelType}" var="item">
                    <option value="${item.dict_id}" <c:if test="${item.dict_id == custCell.cust_level}">selected</c:if>>${item.dict_item_name}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label for="editCustomerLinkman">联系人</label>
            <input id="editCustomerLinkman" name="cust_linkman" value="${custCell.cust_linkman}" />
        </div>
        <div>
            <label for="editCustomerPhone">固定电话</label>
            <input id="editCustomerPhone" name="cust_phone" value="${custCell.cust_phone}" />
        </div>
        <div>
            <label for="editCustomerMobile">移动电话</label>
            <input id="editCustomerMobile" name="cust_mobile" value="${custCell.cust_mobile}" />
        </div>
        <div>
            <label for="editCustomerZipcode">邮政编码</label>
            <input id="editCustomerZipcode" name="cust_zipcode" value="${custCell.cust_zipcode}" />
        </div>
        <div>
            <label for="editCustomerAddress">联系地址</label>
            <input id="editCustomerAddress" name="cust_address" value="${custCell.cust_address}" />
        </div>
        <div>
            <%--<button type="button" onclick="updateCustomer()">保存修改</button>--%>
            <button type="submit">保存修改</button>
            <button type="button" onclick="jumpList()">不保存</button>
        </div>
    </form>
</div>
</body>
</html>