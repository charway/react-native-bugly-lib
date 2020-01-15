package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.tencent.bugly.crashreport.CrashReport;

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
}
