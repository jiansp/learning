package com.learningms.system.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sun.misc.BASE64Encoder;

import com.learningms.system.dao.UsersDao;
import com.learningms.system.model.Users;
import com.learningms.system.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Resource
	private UsersDao usersDao;
	
	public Users login(String username, String password ) throws Exception {
		// TODO Auto-generated method stub
		Users user = usersDao.getUserInfo(username);
		if (user != null) {
			if (user.getPasswd().equals(EncoderByMd5(password)) || user.getPasswd().equals(password)) {
					return user;
			}
		}
		
		return null;
	}
	
    /**利用MD5进行加密
     * @param str  待加密的字符串
     * @return  加密后的字符串
     * @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
     * @throws UnsupportedEncodingException  
     */
    public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    public static void main(String[] args) {
    	try {
			System.out.println(new LoginServiceImpl().EncoderByMd5("ENTER_INFO_SYS"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
