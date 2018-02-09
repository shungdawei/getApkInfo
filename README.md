# getApkInfo
获取apk版本号等相关信息
 
代码CSDN上下载的，做了部分修改。
http://download.csdn.net/download/chillax_li/8246041
     
``` java
String filePath = "D:\\Users\\Desktop\\com.yqwireless1.apk";
File apkFile = new File(filePath);
// 指定文件不存在、不是.apk结尾、解析失败时返回 null
ApkInfo apkInfo = ApkUtil.getApkInfo(apkFile);
if (apkInfo != null) {
	apkInfo.setApkName(apkFile.getName());
	String apkInfoStr = apkInfo.toString()
	System.out.println(apkInfoStr);
} else {
	// 调试观察
	System.out.println("apkInfo is null");
}
```
``` txt
ApkInfo 
[
 apkSize=40499
 versionCode=1,
 versionName=1.0,
 apkPackage=com.yqwireless,
 minSdkVersion=7,
 apkName=com.yqwireless1.apk,
 usesPermission=[android.permission.INTERNET, android.permission.ACCESS_NETWORK_STATE]
]
```
