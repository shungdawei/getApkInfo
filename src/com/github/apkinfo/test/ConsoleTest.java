package com.github.apkinfo.test;

import java.io.File;

import com.github.apkinfo.ApkInfo;
import com.github.apkinfo.ApkUtil;

public class ConsoleTest {
	public static void main(String[] args) {

		String fileParam = "-file=";
		String filePath = null;
		for (int i = 0; i < args.length; i++) {
			// System.out.println("args[" + i + "]=" + args[i]);
			if ((args[i]).startsWith(fileParam)) {
				filePath = args[i].substring(fileParam.length());
				System.out.println("filePath=" + filePath);
			}
		}

		if (filePath == null) {
			System.out.println("file param can not be null");
			return;
		}

		// String filePath = "D:\\Users\\Desktop\\com.yqwireless1.apk
		File apkFile = new File(filePath);
		// 指定文件不存在或解析失败时返回 null
		ApkInfo apkInfo = ApkUtil.getApkInfo(apkFile);
		if (apkInfo != null) {
			apkInfo.setApkName(apkFile.getName());
			String apkInfoStr = apkInfo.toString();

			System.out.println(apkInfoStr);
		} else {
			// 调试观察
			System.out.println("read apkInfo is null");
		}
	}
}
