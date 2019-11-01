package com.lin.common.utils;

import java.util.Properties;

public class OSUtils {
	public static boolean isLinux() {
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		if (os != null && os.toLowerCase().indexOf("linux") > -1) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
//		boolean linux = isLinux();
//		System.out.println(linux);
		Properties properties = System.getProperties();
		System.out.println(properties);
		String property = properties.getProperty("os.name");
		System.out.println(property);
		if (property != null && property.toLowerCase().indexOf("windows")>-1) {
			System.out.println("System is Windows");
		}else {
			System.out.println("is not Windows");
		}
	}
}
