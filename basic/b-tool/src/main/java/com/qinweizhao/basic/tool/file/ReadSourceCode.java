package com.qinweizhao.basic.tool.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.StringUtils;

public class ReadSourceCode {

	public static void main(String[] args) throws IOException {
		List<String> targetDirs = new ArrayList<>();
		targetDirs.add("/Users/weizhao/Code/yet/ocr/ocr-openapi");

		List<String> targetFiles = new ArrayList<>();
		for (String targetDir : targetDirs) {
			File targetFile = new File(targetDir);
			IOFileFilter javaSuffixFilter = FileFilterUtils.suffixFileFilter(".java");// 创建.java过滤器
			Collection<File> fileCollection = FileUtils.listFiles(targetFile, javaSuffixFilter,TrueFileFilter.INSTANCE);
			for (File file : fileCollection) {
				System.out.println(">>> " + file.getPath());
				List<String> listStr = FileUtils.readLines(file, Charset.forName("UTF-8"));
				for (String string : listStr) {
					if(StringUtils.isNoneBlank(string)) {
						System.out.println(string.trim());
						targetFiles.add(string);
					}
				}
			}
		}
		//写入文件
		FileUtils.writeLines(new File("/Users/weizhao/Code/yet/target11.txt"), targetFiles,false);
		System.out.println(targetFiles.size());
	}

}
