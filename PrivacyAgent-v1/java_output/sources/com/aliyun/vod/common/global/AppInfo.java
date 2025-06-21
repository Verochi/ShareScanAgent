package com.aliyun.vod.common.global;

/* loaded from: classes12.dex */
public class AppInfo {
    private static final java.lang.String TAG = "com.aliyun.vod.common.global.AppInfo";
    private java.lang.String mSignature;

    public static class AppInfoHolder {
        private static com.aliyun.vod.common.global.AppInfo sAppInfoInstance = new com.aliyun.vod.common.global.AppInfo(null);

        private AppInfoHolder() {
        }
    }

    private AppInfo() {
    }

    public /* synthetic */ AppInfo(com.aliyun.vod.common.global.AppInfo.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.aliyun.vod.common.global.AppInfo getInstance() {
        return com.aliyun.vod.common.global.AppInfo.AppInfoHolder.sAppInfoInstance;
    }

    public java.lang.String obtainAppSignature(android.content.Context context) {
        java.lang.String str = this.mSignature;
        if (str == null || "".equals(str)) {
            this.mSignature = com.aliyun.vod.common.utils.SignatureUtils.getSingInfo(context);
        }
        return this.mSignature;
    }
}
