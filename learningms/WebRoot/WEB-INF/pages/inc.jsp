<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="edge" />
<link rel="shortcut icon" href="${ctx}/style/images/index/favicon.png" />
<!-- 引入my97日期时间控件 -->
<script type="text/javascript" src="${ctx}/jslib/My97DatePicker/WdatePicker.js" charset="utf-8"></script>

<!-- 引入jQuery -->
<script src="${ctx}/jslib/easyui1.4.5/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>

<link rel="stylesheet" href="${ctx}/style/edittable.css" type="text/css">
<!-- 引入EasyUI -->
<link id="easyuiTheme" rel="stylesheet" href="${ctx}/jslib/easyui1.4.5/themes/<c:out value="${cookie.easyuiThemeName.value}" default="default"/>/easyui.css" type="text/css">
<script type="text/javascript" src="${ctx}/jslib/easyui1.4.5/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/jslib/easyui1.4.5/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<link rel="stylesheet" href="${ctx}/style/workflow.css" type="text/css">
<!-- 扩展EasyUI -->
<script type="text/javascript" src="${ctx}/jslib/extEasyUI.js" charset="utf-8"></script>

<!-- 扩展Jquery -->
<script type="text/javascript" src="${ctx}/jslib/extJquery.js" charset="utf-8"></script>

<!-- 自定义工具类 -->
<script type="text/javascript" src="${ctx}/jslib/workflow.js" charset="utf-8"></script>

<script type="text/javascript" src="${ctx}/jslib/JQueryTools/uploadify/jquery.uploadify.js"></script>
<link href="${ctx}/jslib/JQueryTools/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/jslib/JQueryTools/ckeditor/ckeditor.js"></script>

<!-- 扩展EasyUI图标 -->
<link rel="stylesheet" href="${ctx}/jslib/easyui1.4.5/themes/icon.css" type="text/css">

<%
	session.setAttribute("Language", "Message_zh_CN");
 %>
<fmt:setLocale value="zh_CN"/>

<fmt:setBundle basename="Message" var="Message" scope="application"/>
  
<script type="text/javascript">
$(window).load(function(){
	$("#loading").fadeOut();
});
//公共方法
var pubMethod = {
    bind: function (control, code, required, value) {
        if (control == ''|| code == '')
        {
            return;
        }

        $('#'+ control).combobox({
            url: '${ctx}/comboxUtil/combox?code=' + code + '&r=' + Math.random(),
            method: 'get',
            valueField: 'displayValue',
            textField: 'displayName',
            editable: false,
            panelHeight: 'auto',
            required:required
        });
        
        $('#'+ control).combobox({
        	onLoadSuccess: function() {
		        if (value && value != '') {
		        	 $('#'+ control).combobox('setValue', value);
		        }
        	}
        });
    }
}

var specMethod = {
    bind: function (control,code) {
        if (control == ''|| code == '')
        {
            return;
        }

        $('#'+ control).combobox({
            url: '${ctx}/comboxUtil/combox?code=' + code + '&r=' + Math.random(),
            method: 'get',
            valueField: 'key',
            textField: 'value',
            editable: false,
            panelHeight: 'auto',
            required:true
        });
    }
}

var pubSystemMethod = {
    bind: function (control, value, required, subFunction) {
        if (control == '') {
            return;
        }

        $('#'+ control).combobox({
            url: '${ctx}/system/combox' + '?r=' + Math.random(),
            method: 'get',
            valueField: 'id',
            textField: 'systemName',
            editable: false,
            panelHeight: 'auto',
            required: required
        });
        
        $('#'+ control).combobox({
        	onLoadSuccess: function() {
		        if (value && value != '') {
		        	 $('#'+ control).combobox('setValue', value);
		        	 
		        	 if (subFunction) {
		        	 	subFunction();
		        	 }
		        }
        	}
        });
    }
}


var pubSystemMethodParams = {
	    bind: function (control, value, required, subFunction) {
	        if (control == '') {
	            return;
	        }

	        $('#'+ control).combobox({
	            url: '${ctx}/system/comboxParam' + '?r=' + Math.random(),
	            method: 'get',
	            valueField: 'id',
	            textField: 'systemName',
	            editable: false,
	            panelHeight: 'auto',
	            required: required
	        });
	        
	        $('#'+ control).combobox({
	        	onLoadSuccess: function() {
			        if (value && value != '') {
			        	 $('#'+ control).combobox('setValue', value);
			        	 
			        	 if (subFunction) {
			        	 	subFunction();
			        	 }
			        }
	        	}
	        });
	    }
	}



var pubDomainMethod = {
    bind: function (control, value, required, subFunction) {
        if (control == '') {
            return;
        }

        $('#'+ control).combobox({
            url: '${ctx}/domain/combox' + '?r=' + Math.random(),
            method: 'get',
            valueField: 'id',
            textField: 'domainName',
            editable: false,
            panelHeight: 'auto',
            required: required
        });
        
        $('#'+ control).combobox({
        	onLoadSuccess: function() {
		        if (value && value != '') {
		        	 $('#'+ control).combobox('setValue', value);
		        	 
		        	 if (subFunction) {
		        	 	subFunction();
		        	 }
		        }
        	}
        });
    }
}

var pubMenuMethod = {
    bind: function (control, systemId, value, required) {
        if (control == '') {
            return;
        }

        $('#'+ control).combobox({
            url: '${ctx}/menu/combox?systemId=' + systemId + '&r=' + Math.random(),
            method: 'get',
            valueField: 'id',
            textField: 'menuName',
            editable: false,
            panelHeight: 'auto',
            required: required
        });
    }
}
</script>
