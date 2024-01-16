
package com.qinweizhao.sample.basic.psd.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PsdUtils {
	
	/**
	 * 解析psd文件 生成类文件以及json信息
	 * @Title: execute
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param pyPath python编写的py文件路径
	 * @param: @param psdPath psd文件路径
	 * @param: @param pngPath 生成png的图片路径
	 * @param: @param preName 生成png的图片的名称，
	 * 			原文件：preName.png，图层文件名 preName-1.png,preName-2.png
	 * 			缩略图文件：s-preName.png，图层文件名 s-preName-1.png,s-preName-2.png
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public static String execute(String pythonHome,String pyPath,String psdPath,String pngPath,String preName,String pngScale){

		List<String> result = new ArrayList<String>();
		Process process = null;
		BufferedReader bufrIn = null;
		System.out.println(pythonHome+"\\python.exe");
		String[] cmdArr = new String[] {pythonHome+"\\python.exe", pyPath, psdPath, pngPath,preName,pngScale};
		try {
			// 执行命令, 返回一个子进程对象（命令在子进程中执行）
			process = Runtime.getRuntime().exec(cmdArr);
			// 方法阻塞, 等待命令执行完成（成功会返回0）
			process.waitFor(); 
			// 获取命令执行结果, （PS: 子进程的输出就是主进程的输入）
			bufrIn = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
			String line;
			System.out.println("解析返回数据开始····························");
			while ((line = bufrIn.readLine()) != null) {
				System.out.println(line);
				result.add(line);
			}
			System.out.println("解析返回数据结束····························");
			return result.get((result.size()-2));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if(bufrIn != null){
				try {
					bufrIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(process != null){
				try {
					process.waitFor();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}

