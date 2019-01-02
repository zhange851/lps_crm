<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="paging" uri="http://core.com/paging/" %>
<%@ taglib prefix="lpstag" uri="http://core.com/lpstag" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>查询用户</title>
    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script>
        function insertCustomer() {
            window.location.href = "<%=basePath%>customer/edit.do?custId=0";
        }

        function deleteCustomer(id) {
            if (confirm("确实要删除吗？")) {
                $.post("<%=basePath%>customer/delete.do", {"id": id}, function (data) {
                    alert("客户删除数据成功！");
                    window.location.reload();
                });
            }
        }
        
        function insertCustomerTan(id) {
            document.getElementById("all_light").style.display = "block";
            document.getElementById("contes").style.display = "block";
        }
        
        function  insertCustomerTanSubmit() {
            $.post("<%=basePath%>customer/insert_tan.do", $("#insert_customer_from").serialize(), function(data){
                alert("客户信息更新成功！");
                window.location.reload();
            });
        }

        function updateCustomerTan(id) {
            $.post("<%=basePath%>customer/edit_tan.do",{"custId":id}, function (data) {
                $("#editCustomerId").val(data.cust_id);
                $("#editCustomerName").val(data.cust_name);
                $("#editCustomerSource").val(data.cust_source);
                $("#editCustomerIndustry").val(data.cust_industry);
                $("#editCustomerLevel").val(data.cust_level);
                $("#editCustomerLinkman").val(data.cust_linkman);
                $("#editCustomerPhone").val(data.cust_phone);
                $("#editCustomerMobile").val(data.cust_mobile);
                $("#editCustomerZipcode").val(data.cust_zipcode);
                $("#editCustomerAddress").val(data.cust_address);
            });
            document.getElementById("all_light").style.display = "block";
            document.getElementById("contes1").style.display = "block";
        }

        function updateCustomerTanSubmit() {
            $.post("<%=basePath%>customer/update.do", $("#editCustomerForm").serialize(), function (data) {
                alert("客户信息更新成功");
                window.location.reload();
            });
        }

        function jumpList() {
            alert("不进行保存操作了");
            window.location.reload();
        }
    </script>
    <style type="text/css">
        #all_light { /*整个弹窗的页面*/
            opacity: 0.8; /*透明度*/
            width: 100%; /*宽度*/
            height: 2300px; /*高度，不能百分百*/
            background: #000; /*背景色*/
            position: absolute;
            top: 0;
            left: 0; /*定位*/
            display: none; /*隐藏*/
            z-index: 2; /*覆盖*/
        }
        #contes { /* 弹框的页面*/
            width: 500px; /*宽度*/
            height: 500px; /*高度*/
            background: #fff; /*背景色*/
            display: none; /*隐藏*/
            z-index: 2; /*覆盖*/
            position: absolute;
            top: 100px;
            left: 400px; /* 定位*/
        }
        #contes1 { /* 弹框的页面*/
            width: 500px; /*宽度*/
            height: 500px; /*高度*/
            background: #fff; /*背景色*/
            display: none; /*隐藏*/
            z-index: 2; /*覆盖*/
            position: absolute;
            top: 100px;
            left: 400px; /* 定位*/
        }
        input {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<%--<div id="allbody"></div>--%>
<div>
    <div>
        <h1>客户管理</h1>
    </div>
    <div>
        <%--<form action="${pageContext.request.contextPath}/customer/list.do" method="get">--%>
        <form action="<%=basePath%>customer/list.do" method="get">
            <div>
                <label for="customerName">客户名称</label>
                <input type="text" id="customerName" value="${custName}" name="custName">
            </div>
            <div>
                <label for="customerFrom">客户来源</label>
                <select id="customerFrom" name="custSource">
                    <option value="">--请选择--</option>
                    <c:forEach items="${fromType}" var="item">
                        <option value="${item.dict_id}" <c:if
                                test="${item.dict_id == custSource}"> selected</c:if>>${item.dict_item_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="custIndustry">所属行业</label>
                <select id="custIndustry" name="custIndustry">
                    <option value="">--请选择--</option>
                    <c:forEach items="${industryType}" var="item">
                        <option value="${item.dict_id}"
                                <c:if test="${item.dict_id ==custIndustry}">selected</c:if>>${item.dict_item_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="custLevel">客户级别</label>
                <select id="custLevel" name="custLevel">
                    <option value="">--请选择--</option>
                    <c:forEach items="${levelType}" var="item">
                        <option value="${item.dict_id}"
                                <c:if test="${item.dict_id==custLevel}">selected</c:if>>${item.dict_item_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <button type="submit">查询</button>
                <button type="button" onclick="insertCustomer()">新增</button>
                <button type="button" onclick="insertCustomerTan()">新增弹框</button>
            </div>

        </form>
    </div>
    <div>
        <div>客户信息列表</div>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>客户名称</th>
                <th>客户来源</th>
                <th>客户所属行业</th>
                <th>客户级别</th>
                <th>固定电话</th>
                <th>手机</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.rows}" var="row">
                <tr>
                    <td>${row.cust_id}</td>
                    <td>${row.cust_name}</td>
                    <td>${row.cust_source}</td>
                    <td>${row.cust_industry}</td>
                    <td>${row.cust_level}</td>
                    <td>${row.cust_phone}</td>
                    <td>${row.cust_mobile}</td>
                    <td>
                            <%--<a href="../query.jsp" >修改</a>--%>
                        <a href="<%=basePath%>customer/edit.do?custId=${row.cust_id}">修改</a>
                        <a href="#" onclick="deleteCustomer(${row.cust_id})">删除</a>
                        <a href="#" onclick="updateCustomerTan(${row.cust_id})">修改弹框</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div>
            <%--<paging:page url="<%=basePath%>customer/list.do" />--%>
            <paging:page url="${pageContext.request.contextPath }/customer/list.do"/>
        </div>
        <div>
            <lpstag:lpstag></lpstag:lpstag>
        </div>
    </div>
    <div id="all_light">
    </div>
    <div id="contes" style="">
        <div style="width:500px;height:40px;">
            <form id="insert_customer_from" style=" margin-left: 100px;">
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
                    <button type="button" onclick="insertCustomerTanSubmit()">新增修改</button>
                    <button type="button" onclick="jumpList()">不保存</button>
                </div>
            </form>
        </div>
    </div>
    <div id="contes1" style="">
        <div style="width: 500px;height: 40px;">
            <form id="editCustomerForm" style=" margin-left: 100px;">
                <input id="editCustomerId" type="hidden" name="cust_id" />
                <div>
                    <label for="editCustomerName">客户名称</label>
                    <input id="editCustomerName" name="cust_name" />
                </div>
                <div>
                    <label for="editCustomerSource">客户来源</label>
                    <select id="editCustomerSource" name="cust_source">
                        <option value="">--请选择</option>
                        <c:forEach items="${fromType}" var="item">
                            <option value="${item.dict_id}" <c:if test="${item.dict_id == cust_source}">selected</c:if>>${item.dict_item_name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label for="editCustomerIndustry">所属行业</label>
                    <select id="editCustomerIndustry" name="cust_industry">
                        <option value="">--请选择</option>
                        <c:forEach items="${industryType}" var="item">
                            <option value="${item.dict_id}" <c:if test="${item.dict_id == cust_industry}">selected</c:if>>${item.dict_item_name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label for="editCustomerLevel">客户级别</label>
                    <select id="editCustomerLevel"  name="cust_level">
                        <option value="">--请选择</option>
                        <c:forEach items="${levelType}" var="item">
                            <option value="${item.dict_id}" <c:if test="${item.dict_id == cust_level}">selected</c:if>>${item.dict_item_name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label for="editCustomerLinkman">联系人</label>
                    <input id="editCustomerLinkman" name="cust_linkman" />
                </div>
                <div>
                    <label for="editCustomerPhone">固定电话</label>
                    <input id="editCustomerPhone" name="cust_phone" />
                </div>
                <div>
                    <label for="editCustomerMobile">移动电话</label>
                    <input id="editCustomerMobile" name="cust_mobile" />
                </div>
                <div>
                    <label for="editCustomerZipcode">邮政编码</label>
                    <input id="editCustomerZipcode" name="cust_zipcode" />
                </div>
                <div>
                    <label for="editCustomerAddress">联系地址</label>
                    <input id="editCustomerAddress" name="cust_address" />
                </div>
                <div>
                    <button type="button" onclick="updateCustomerTanSubmit()">保存修改</button>
                    <button type="button" onclick="jumpList()">不保存</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>