package com.github.apkinfo.test;

import java.io.File;

import com.github.apkinfo.ApkInfo;
import com.github.apkinfo.ApkUtil;

public class ConsoleTest {
	public static void main(String[] args) {

		String filePath = null;
		for (int i = 0; i < args.length; i++) {
			// System.out.println("args[" + i + "]=" + args[i]);
			if ((args[i]).startsWith("-file=")) {
				filePath = args[i].substring("file=".length());
				// System.out.println("filePath=" + filePath);
			}
		}

		if (filePath == null) {
			System.out.println("file param can not be null");
			return;
		}

		// String filePath =
		// "E:\\codesvn\\Pos\\branch\\4.x\\SpmsPos\\app\\NewSpmsPos_standard_v4.0.2.apk";
		// String filePath =
		// "D:\\Users\\Desktop\\NewSpmsPos3_v3.1.1.15_WH_parkLot_Liandi_sign.uns";//
		// com.yqwireless1.apk
		File apkFile = new File(filePath);
		// 指定文件不存在、不是.apk结尾、解析失败时返回 null
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
