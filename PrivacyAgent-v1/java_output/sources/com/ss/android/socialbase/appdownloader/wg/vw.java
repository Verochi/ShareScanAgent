package com.ss.android.socialbase.appdownloader.wg;

/* loaded from: classes19.dex */
public class vw {
    public static final java.lang.String vw;

    static {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str = android.os.Build.VERSION.RELEASE;
        boolean z = !android.text.TextUtils.isEmpty(str);
        boolean z2 = !android.text.TextUtils.isEmpty(android.os.Build.ID);
        boolean z3 = "REL".equals(android.os.Build.VERSION.CODENAME) && !android.text.TextUtils.isEmpty(android.os.Build.MODEL);
        sb.append("AppDownloader");
        if (z) {
            sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            sb.append(str);
        }
        sb.append(" (Linux; U; Android");
        if (z) {
            sb.append(" ");
            sb.append(str);
        }
        if (z3 || z2) {
            sb.append(com.alipay.sdk.m.u.i.b);
            if (z3) {
                sb.append(" ");
                sb.append(android.os.Build.MODEL);
            }
            if (z2) {
                sb.append(" Build/");
                sb.append(android.os.Build.ID);
            }
        }
        sb.append(")");
        vw = sb.toString();
    }
}
