package com.bytedance.sdk.openadsdk.api.plugin;

/* loaded from: classes22.dex */
public class wg {
    private static final java.lang.StringBuffer vw = new java.lang.StringBuffer();

    public static java.lang.String vw() {
        return vw.toString();
    }

    public static void vw(java.lang.String str, java.lang.String str2) {
        java.lang.StringBuffer stringBuffer = vw;
        stringBuffer.append(java.lang.System.currentTimeMillis());
        stringBuffer.append(';');
        stringBuffer.append(str);
        stringBuffer.append(';');
        stringBuffer.append(str2);
        stringBuffer.append('\n');
    }
}
