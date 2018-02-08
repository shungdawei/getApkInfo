package com.github.apkinfo.test;

import java.io.File;

import com.github.apkinfo.ApkInfo;
import com.github.apkinfo.ApkUtil;

public class ConsoleTest {
	public static void main(String[] args) {

		String filePath = "D:\\Users\\Desktop\\com.yqwireless1.apk";
		File apkFile = new File(filePath);
		if (apkFile.exists()) {
			ApkInfo apkInfo = ApkUtil.getApkInfo(apkFile);
			apkInfo.setApkName(apkFile.getName());
			String apkInfoStr = apkInfo.toString();

			System.out.println(apkInfoStr);
		}
	}
}
