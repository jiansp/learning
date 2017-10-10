<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<!-- 引入jQuery -->
<script src="${ctx}/jslib/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	function proString() {
		var names = "冯培智,任鹏飞,杨凯团";
		names = names.replace(/,/g, "、");
		$("#span").text(names);
	}
</script>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>个贷客户信息维护</title>
</head>
<body>
	<input id="name" type="text" />
	<span id="span"></span>
	<a onclick="addSearch();" href="javascript:void(0);">添加</a>
	<span id="span"></span>

</body>
</html>