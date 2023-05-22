package com.qinweizhao.basic.ftp.util;

import org.apache.commons.lang.time.DateFormatUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * @功能描述：解析properties文件工具类
 * @author json
 * @创建日期：2016-09-22
 * @版本号：V0.1
 */
public class GetParam {
	
	private static String settingPath = "/config.properties";
	/**
	 * ftp
	 */
	public static String ftpIpAddr;
	public static String ftpPort;
	public static String ftpUserName;
	public static String ftpPassWord;
	public static String ftpStoreUploadDir;

	// 创建Properties对象
	private static Properties properties = null;

	static {
		loadFile();// 调用该类时立即执行静态块加载初始化Properties对象中的属性参数
	}

	private static void loadFile() {
		InputStream inputStream = GetParam.class.getResourceAsStream(settingPath);
		properties = new Properties();
		try {
			properties.load(inputStream);
			ftpIpAddr = properties.getProperty("ftpIpAddr");
			ftpPort = properties.getProperty("ftpPort");
			ftpUserName = properties.getProperty("ftpUserName");
			ftpPassWord = properties.getProperty("ftpPassWord");
			Date date = new Date();
			ftpStoreUploadDir = ftpStoreUploadDir + File.separator + DateFormatUtils.format(date, "yyyy") + File.separator +
					DateFormatUtils.format(date, "MM") + File.separator +
					DateFormatUtils.format(date, "dd") + File.separator
				;

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}