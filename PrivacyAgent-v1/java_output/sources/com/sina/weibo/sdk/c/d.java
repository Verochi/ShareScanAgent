package com.sina.weibo.sdk.c;

/* loaded from: classes19.dex */
public final class d {
    private static final char[] ao = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};

    public static java.lang.String a(byte[] bArr) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[32];
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                byte b = digest[i2];
                int i3 = i + 1;
                char[] cArr2 = ao;
                cArr[i] = cArr2[(b >>> 4) & 15];
                i = i3 + 1;
                cArr[i3] = cArr2[b & 15];
            }
            return new java.lang.String(cArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String f(java.lang.String str) {
        try {
            return a(str.getBytes());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
