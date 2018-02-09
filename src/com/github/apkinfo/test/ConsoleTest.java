package com.github.apkinfo.test;

import java.io.File;

import com.github.apkinfo.ApkInfo;
import com.github.apkinfo.ApkUtil;

public class ConsoleTest {
	public static void main(String[] args) {

		String filePath = "D:\\Users\\Desktop\\apkutil.jar";// com.yqwireless1.apk
		File apkFile = new File(filePath);
		// 指定文件不存在、不是.apk结尾、解析失败时返回 null
		ApkInfo apkInfo = ApkUtil.getApkInfo(apkFile);
		if (apkInfo != null) {
			apkInfo.setApkName(apkFile.getName());
			String apkInfoStr = apkInfo.toString();

			System.out.println(apkInfoStr);
		} else {
			// 调试观察
			System.out.println("apkInfo is null");
		}
	}
}
