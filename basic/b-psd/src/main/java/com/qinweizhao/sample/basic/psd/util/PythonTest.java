package com.qinweizhao.sample.basic.psd.util;

import java.io.IOException;


public class PythonTest {
		public static void main(String[] args) throws IOException, InterruptedException {
			String pythonHome=System.getenv("PYTHON_HOME");//python环境变量
			//String pyPath = FileUtils.readFileToString(new File("D:\\media\\merge\\py\\test_psd.py"),"UTF-8");
			String pyPath ="C:\\Users\\admin\\Desktop\\psd\\psd.py";
			String psdPath = "C:\\Users\\admin\\Desktop\\psd\\demo2\\tp.psd";
			String pngPath = "C:\\Users\\admin\\Desktop\\psd\\demo2\\images";
			String preName = "PN000001";
			long start = System.currentTimeMillis();
			System.out.println("返回数据：" +PsdUtils.execute(pythonHome,pyPath, psdPath,pngPath,preName,"6"));
			System.out.println("耗时："+(System.currentTimeMillis() - start) +"ms");
	}
}

	