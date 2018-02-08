package com.github.apkinfo;

import java.util.List;

public class ApkInfo {

	private String versionCode;
	private String versionName;
	private String apkPackage;
	private String minSdkVersion;
	private String apkName;
	private List<String> usesPermission;
	private long apkSize;

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getApkPackage() {
		return apkPackage;
	}

	public void setApkPackage(String apkPackage) {
		this.apkPackage = apkPackage;
	}

	public String getMinSdkVersion() {
		return minSdkVersion;
	}

	public void setMinSdkVersion(String minSdkVersion) {
		this.minSdkVersion = minSdkVersion;
	}

	public String getApkName() {
		return apkName;
	}

	public void setApkName(String apkName) {
		this.apkName = apkName;
	}

	public List<String> getUsesPermission() {
		return usesPermission;
	}

	public void setUsesPermission(List<String> usesPermission) {
		this.usesPermission = usesPermission;
	}

	public long getApkSize() {
		return apkSize;
	}

	public void setApkSize(long apkSize) {
		this.apkSize = apkSize;
	}

	@Override
	public String toString() {
		return "ApkInfo \n[" + "\n apkSize=" + apkSize + "\n versionCode=" + versionCode + ",\n versionName="
				+ versionName + ",\n apkPackage=" + apkPackage + ",\n minSdkVersion=" + minSdkVersion + ",\n apkName="
				+ apkName + ",\n usesPermission=" + usesPermission + "\n]";
	}
}
