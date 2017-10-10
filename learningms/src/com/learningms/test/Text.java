package com.learningms.test;

import java.util.Map;

import com.learningms.system.dao.impl.BaseDaoImpl;

public class Text {
public static void main(String[] args) {
	double a = 1;
	double b = 3;
	long c  = Math.round(a*100/b);
	System.out.println(c);
	System.out.println(String.format("%08d", 20));
	System.out.println(String.format("%08d", 111));
	System.out.println(String.format("%08d", 1));
}
}
