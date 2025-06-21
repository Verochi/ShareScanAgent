package com.sina.weibo.sdk.net;

/* loaded from: classes19.dex */
public class HttpManager {
    static {
        java.lang.System.loadLibrary("weibosdkcore");
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!android.text.TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (!android.text.TextUtils.isEmpty(str3)) {
            sb.append(str3);
        }
        return calcOauthSignNative(context, sb.toString(), str4);
    }

    private static native java.lang.String calcOauthSignNative(android.content.Context context, java.lang.String str, java.lang.String str2);
}
