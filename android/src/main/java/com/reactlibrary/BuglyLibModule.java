package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;

public class BuglyLibModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public BuglyLibModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "BuglyLib";
    }

    @ReactMethod
    public void setUserIdentifier(String userID) {
        CrashReport.setUserId(userID);
    }

    @ReactMethod
    public void updateAppVersion(String version) {
        CrashReport.setAppVersion(this.getReactApplicationContext(), version);
    }

    @ReactMethod
    public void testJavaCrash() {
        CrashReport.testJavaCrash();
    }

    @ReactMethod
    public void error(String message) {
        Throwable thr = new Throwable(message);
        CrashReport.postCatchedException(thr);
    }

    @ReactMethod
    public void checkUpgrade() {
        Beta.checkUpgrade();
    }

    @ReactMethod
    public String getUpgradeInfo() {
        UpgradeInfo upgradeInfo = Beta.getUpgradeInfo();
        if (upgradeInfo == null) {
            return "";
        }
        StringBuilder info = new StringBuilder();
        info.append("id: ").append(upgradeInfo.id).append("\n");
        info.append("标题: ").append(upgradeInfo.title).append("\n");
        info.append("升级说明: ").append(upgradeInfo.newFeature).append("\n");
        info.append("versionCode: ").append(upgradeInfo.versionCode).append("\n");
        info.append("versionName: ").append(upgradeInfo.versionName).append("\n");
        info.append("发布时间: ").append(upgradeInfo.publishTime).append("\n");
        info.append("安装包Md5: ").append(upgradeInfo.apkMd5).append("\n");
        info.append("安装包下载地址: ").append(upgradeInfo.apkUrl).append("\n");
        info.append("安装包大小: ").append(upgradeInfo.fileSize).append("\n");
        info.append("弹窗间隔（ms）: ").append(upgradeInfo.popInterval).append("\n");
        info.append("弹窗次数: ").append(upgradeInfo.popTimes).append("\n");
        info.append("发布类型（0:测试 1:正式）: ").append(upgradeInfo.publishType).append("\n");
        info.append("弹窗类型（1:建议 2:强制 3:手工）: ").append(upgradeInfo.upgradeType).append("\n");
        info.append("图片地址：").append(upgradeInfo.imageUrl);

        return info.toString();
    }

}
