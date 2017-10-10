package com.learningms.system.controller;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.misc.BASE64Encoder;

import com.learningms.system.model.Users;
import com.learningms.system.service.LoginService;
import com.learningms.system.vo.Json;


@Controller
@RequestMapping("login")
public class LoginController{
	@Resource
	private LoginService loginService;
	

	@ResponseBody
	@RequestMapping("/login")
	public Json login(Users users, HttpSession session) {

		Json j = new Json();
		try {
			String passWd = new String(decode(users.getPasswd()));
			users.setPasswd(passWd);
			Users sysuser = loginService.login(users.getUserName(),
					users.getPasswd());
			
			if (sysuser != null) {

				j.setSuccess(true);
				j.setMsg("登陆成功！");
				session.setAttribute("currentUser", sysuser);
			} else {
				j.setMsg("用户名或密码错误！");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		} finally {

		}

		return j;
	}

	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		/*if(request.getSession().getAttribute("currentUser") == null){
			return "/login";
		}*/
		return "/index";
	}

	@ResponseBody
	@RequestMapping("/logout")
	public Json logout(HttpSession session) {
		Json j = new Json();
		if (session != null) {
			session.invalidate();
		}
		j.setSuccess(true);
		j.setMsg("注销成功！");
		return j;
	}

	@RequestMapping("/main")
	public String mainPage(HttpServletRequest request) {
		return "/index/main";
	}

	private static char[] base64EncodeChars = new char[] { 'A', 'B', 'C', 'D',
			'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
			'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
			'4', '5', '6', '7', '8', '9', '+', '/', };

	private static byte[] base64DecodeChars = new byte[] { -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59,
			60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
			10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1,
			-1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37,
			38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1,
			-1, -1 };

	/**
	 * 解密
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] decode(String str) {
		byte[] data = str.getBytes();
		int len = data.length;
		ByteArrayOutputStream buf = new ByteArrayOutputStream(len);
		int i = 0;
		int b1, b2, b3, b4;

		while (i < len) {
			do {
				b1 = base64DecodeChars[data[i++]];
			} while (i < len && b1 == -1);
			if (b1 == -1) {
				break;
			}

			do {
				b2 = base64DecodeChars[data[i++]];
			} while (i < len && b2 == -1);
			if (b2 == -1) {
				break;
			}
			buf.write((int) ((b1 << 2) | ((b2 & 0x30) >>> 4)));

			do {
				b3 = data[i++];
				if (b3 == 61) {
					return buf.toByteArray();
				}
				b3 = base64DecodeChars[b3];
			} while (i < len && b3 == -1);
			if (b3 == -1) {
				break;
			}
			buf.write((int) (((b2 & 0x0f) << 4) | ((b3 & 0x3c) >>> 2)));

			do {
				b4 = data[i++];
				if (b4 == 61) {
					return buf.toByteArray();
				}
				b4 = base64DecodeChars[b4];
			} while (i < len && b4 == -1);
			if (b4 == -1) {
				break;
			}
			buf.write((int) (((b3 & 0x03) << 6) | b4));
		}
		return buf.toByteArray();
	}

	// 自己加的方法
	public static char Hex(int bin) {
		char retval;

		if (bin >= 0 && bin <= 9)
			retval = (char) ('0' + bin);
		else if (bin >= 10 && bin <= 15)
			retval = (char) ('A' + bin - 10);
		else
			retval = '0';
		return retval;
	}

	public static int B2Int(byte[] bina) {
		int retval = 0;
		int t1 = 0;

		t1 = bina[3];
		retval = t1 & 0xFF;
		t1 = bina[2] & 0xFF;
		retval = retval * 0x100 + t1;
		t1 = bina[1] & 0xFF;
		retval = retval * 0x100 + t1;
		t1 = bina[0] & 0xFF;
		retval = retval * 0x100 + t1;
		return retval;
	}

	public static void TSleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println("Trouble with the lamp flash.");
		}
	}

	/**
	 * 利用MD5进行加密
	 * 
	 * @param str
	 *            待加密的字符串
	 * @return 加密后的字符串
	 * @throws NoSuchAlgorithmException
	 *             没有这种产生消息摘要的算法
	 * @throws UnsupportedEncodingException
	 */
	public String EncoderByMd5(String str) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		// 确定计算方法
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		// 加密后的字符串
		String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		return newstr;
	}
}
