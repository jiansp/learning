<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<!-- 引入jQuery -->
<script src="${ctx}/jslib/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">


function addSearch() {
	var name = $("#name").val();
	$.ajax({
		type : "POST",
		url : "${ctx}/test/test",
		dataType : "json",
		data : {name : name},
		cache : false,
		success : function(result) {
			$("#span").text(result.displayName);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("系统错误");
		}
	});				
				
}

</script>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>个贷客户信息维护</title>
</head>
<body  >
	<input id = "name" type = "text" />
	<a onclick="addSearch();" href="javascript:void(0);" >添加</a><span id = "span"></span>
		
</body>
</html>