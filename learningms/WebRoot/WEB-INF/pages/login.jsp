<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<script src="${ctx}/jslib/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学习系统</title>
<script>
	/* var sessionInfo_userId = '${sessionInfo.id}';
	if (sessionInfo_userId) {//如果登录,直接跳转到index页面
		window.location.href='${ctx}/login/index';
	} */

	function submitForm() {
		var empPattern = /^\s*$/;
		var userName = $('#userName').val();
		var passwd = $("#passwd").val();
		if (empPattern.test(userName) || empPattern.test(passwd)) {
			alert('用户名或者密码不能为空');
			return;
		}
		var password = encode64($("#passwd").val());
		$("#hidpasswd").val(password);

		$.ajax({
			type : "POST",
			url : "${ctx}/login/login",
			dataType : "json",
			data : $('#loginform').serialize(),
			cache : false,
			success : function(result) {

				if (result.success) {
					window.location.href = '${ctx}/login/index';
				} else {
					alert(result.msg);
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("系统错误");
			}
		});

	}

	var keyStr = "ABCDEFGHIJKLMNOP" + "QRSTUVWXYZabcdef" + "ghijklmnopqrstuv"
			+ "wxyz0123456789+/" + "=";
	function encode64(input) {
		var output = "";
		var chr1, chr2, chr3 = "";
		var enc1, enc2, enc3, enc4 = "";
		var i = 0;
		do {
			chr1 = input.charCodeAt(i++);
			chr2 = input.charCodeAt(i++);
			chr3 = input.charCodeAt(i++);
			enc1 = chr1 >> 2;
			enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
			enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
			enc4 = chr3 & 63;
			if (isNaN(chr2)) {
				enc3 = enc4 = 64;
			} else if (isNaN(chr3)) {
				enc4 = 64;
			}
			output = output + keyStr.charAt(enc1) + keyStr.charAt(enc2)
					+ keyStr.charAt(enc3) + keyStr.charAt(enc4);
			chr1 = chr2 = chr3 = "";
			enc1 = enc2 = enc3 = enc4 = "";
		} while (i < input.length);

		return output;
	}

	$(document).ready(function() {
		document.onkeydown = function(event) {
			if (event.keyCode == 13) //回车键的键值为13
				$('#btnLogin').click();
		};
	});

	function Init() {

		//开发时请参见"ET99多功能锁安全ActiveX控件参考手册.pdf"中的说明

		var ePassSN;
		var ePassPID;
		var ePassNum;
		var soPin;
		var fkey;
		try {
			var ePass = new ActiveXObject("ET99_FULL.ET99Full.1");
		} catch (error) {
			return false;
		}

		try {
			//找锁
			ePassPID = "1CD621C1";
			ePassNum = ePass.FindToken(ePassPID);
			//alert(ePassNum);

			//打开锁
			ePass.OpenToken(ePassPID, 1);

			//得到硬件ID
			ePassSN = ePass.GetSN();
			//alert(ePassSN);

			//验证SOPIN
			soPin = "FFFFFFFFFFFFFFFF";
			ePass.VerifyPIN(1, soPin);
			//alert("VerifyPIN Success!");

			//计算写入到锁内的MD5HMAC密钥,第二个参数"1234"没有实际意义
			var timestamp = Date.parse(new Date());
			fkey = ePass.Soft_MD5HMAC(0, "1234", timestamp);

			//读写
			//写示例中为“aaa”
			//第一个参数0表示以ASCII方式
			//第二个参数表示写入的起始位置，0表示从最开始的第1个字节开始写入
			//第三个参数表示读取的长度，3表示要写入3个字节
			//第四个参数表示要写入的字符串

			var keyPassword = encode64(ePass.read(0, 0, 50));
			$('#keyPassword').val(keyPassword);
			//设置密钥
			//ePass.SetKey(1,1,fkey);
			//alert("Setkey Success!");

			ePass.CloseToken();

		} catch (error) {
			ePass.CloseToken();
			console.log(error.number & 0xFFFF);
			return false;
		}

	}
</script>
</head>

<body>
	<div class="bg_box">
		<div class="OA_logo"></div>
		<div class="word"></div>

		<div class="login_box">
			<ul>
				<form id="loginform" method="post" language="jscript">
					<li>
						<input type="text" id="userName" name="userName" placeholder="输入用户名" />
						<input type="hidden" id="hidpasswd" name="passwd" />
					</li>
				</form>
				<li>
					<input type="password" id="passwd" name="passwd" placeholder="输入至少6位密码" />
				</li>
				<li>
					<input type="button" value="登录" id="btnLogin" onclick="submitForm()" />
				</li>
			</ul>
		</div>

	</div>
</body>

</html>