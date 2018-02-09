package com.github.apkinfo;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;

public class ApkUtil {

	private static final Namespace NS = Namespace.getNamespace("http://schemas.android.com/apk/res/android");

	public static ApkInfo getApkInfo(File apkFile) {

		try {
			
			if (!apkFile.getName().endsWith(".apk")) {
				System.out.println("file name [" + apkFile.getPath() + "] not end with .apk!");
				return null;
			}
			
			if (!apkFile.exists()) {
				System.out.println("file " + apkFile.getPath() + " not exists!!!");
				return null;
			}

			ApkInfo apkInfo = new ApkInfo();
			SAXBuilder builder = new SAXBuilder();
			String apkPath = apkFile.getAbsolutePath();
			Document document = null;

			apkInfo.setApkSize(apkFile.length());

			document = builder.build(getXmlInputStream(apkPath));

			Element root = document.getRootElement();// 跟节点-->manifest
			apkInfo.setVersionCode(root.getAttributeValue("versionCode", NS));
			apkInfo.setVersionName(root.getAttributeValue("versionName", NS));
			apkInfo.setApkPackage(root.getAttributeValue("package", ""));// package不是以android:开头
			Element elemUseSdk = root.getChild("uses-sdk");// 子节点-->uses-sdk
			apkInfo.setMinSdkVersion(elemUseSdk.getAttributeValue("minSdkVersion", NS));
			List<?> listPermission = root.getChildren("uses-permission");// 子节点是个集合
			List<String> permissions = new ArrayList<>();
			for (Object object : listPermission) {
				String permission = ((Element) object).getAttributeValue("name", NS);
				permissions.add(permission);
			}
			apkInfo.setUsesPermission(permissions);

			return apkInfo;
		} catch (Exception e) {
			System.out.println("parse apk error.");
			e.printStackTrace();
			return null;
		}
	}

	private static InputStream getXmlInputStream(String apkPath) {
		InputStream inputStream = null;
		InputStream xmlInputStream = null;
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(apkPath);
			ZipEntry zipEntry = new ZipEntry("AndroidManifest.xml");
			inputStream = zipFile.getInputStream(zipEntry);
			AXMLPrinter xmlPrinter = new AXMLPrinter();
			xmlPrinter.startPrinf(inputStream);
			xmlInputStream = new ByteArrayInputStream(xmlPrinter.getBuf().toString().getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
			try {
				inputStream.close();
				zipFile.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return xmlInputStream;
	}

}
