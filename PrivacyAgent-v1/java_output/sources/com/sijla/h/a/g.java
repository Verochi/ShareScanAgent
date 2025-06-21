package com.sijla.h.a;

/* loaded from: classes19.dex */
public final class g {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};

    public static java.lang.String a(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? "" : a(str.trim().getBytes());
    }

    public static java.lang.String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(digest.length << 1);
            for (byte b : digest) {
                char[] cArr = a;
                sb.append(cArr[(b & 240) >>> 4]);
                sb.append(cArr[b & 15]);
            }
            return sb.toString();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
