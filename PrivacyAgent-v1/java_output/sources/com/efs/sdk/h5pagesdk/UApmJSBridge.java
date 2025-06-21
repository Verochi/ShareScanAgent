package com.efs.sdk.h5pagesdk;

/* loaded from: classes22.dex */
public class UApmJSBridge {
    @android.webkit.JavascriptInterface
    public java.lang.String getLaunchOptionsSync() {
        if (com.efs.sdk.h5pagesdk.H5Manager.getH5ConfigMananger() == null) {
            java.lang.String str = com.efs.sdk.h5pagesdk.H5Manager.TAG;
            return "";
        }
        java.lang.String generateLaunchOptions = com.efs.sdk.h5pagesdk.H5Manager.getH5ConfigMananger().generateLaunchOptions();
        java.lang.String str2 = com.efs.sdk.h5pagesdk.H5Manager.TAG;
        return generateLaunchOptions;
    }

    @android.webkit.JavascriptInterface
    public void sendData(java.lang.String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    boolean z = com.efs.sdk.h5pagesdk.H5Manager.isDebug;
                    if (com.efs.sdk.h5pagesdk.H5Manager.getH5ConfigMananger() != null) {
                        com.efs.sdk.h5pagesdk.H5Manager.getH5ConfigMananger().sendData(str);
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }
}
