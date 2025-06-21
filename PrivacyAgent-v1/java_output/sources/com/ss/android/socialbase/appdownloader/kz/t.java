package com.ss.android.socialbase.appdownloader.kz;

/* loaded from: classes19.dex */
public class t {
    public static java.lang.String vw(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return new java.lang.String(android.util.Base64.decode(com.ss.android.socialbase.downloader.utils.DownloadUtils.hexToString(str), 0));
    }

    public static java.lang.String vw(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] decode = android.util.Base64.decode(com.ss.android.socialbase.downloader.utils.DownloadUtils.hexToString(str), 0);
        int length = str2.length();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 0;
        for (byte b : decode) {
            if (i >= length) {
                i %= length;
            }
            sb.append((char) (b ^ str2.charAt(i)));
            i++;
        }
        return sb.toString();
    }
}
