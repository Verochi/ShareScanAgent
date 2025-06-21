package com.aliyun.common.global;

/* loaded from: classes.dex */
public class AppInfo {
    private static final java.lang.String TAG = "com.aliyun.common.global.AppInfo";
    private java.lang.String mSignature;

    public static class AppInfoHolder {
        private static com.aliyun.common.global.AppInfo sAppInfoInstance = new com.aliyun.common.global.AppInfo(null);

        private AppInfoHolder() {
        }
    }

    private AppInfo() {
    }

    public /* synthetic */ AppInfo(com.aliyun.common.global.AppInfo.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.aliyun.common.global.AppInfo getInstance() {
        return com.aliyun.common.global.AppInfo.AppInfoHolder.sAppInfoInstance;
    }

    public java.lang.String obtainAppSignature(android.content.Context context) {
        java.lang.String str = this.mSignature;
        if (str == null || "".equals(str)) {
            this.mSignature = com.aliyun.common.utils.SignatureUtils.getSingInfo(context);
        }
        return this.mSignature;
    }
}
