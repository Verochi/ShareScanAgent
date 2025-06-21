package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class p {
    public static java.lang.String a(java.lang.String str) {
        java.security.MessageDigest messageDigest;
        byte[] bytes = str.getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
        try {
            messageDigest = java.security.MessageDigest.getInstance("MD5");
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            messageDigest = null;
        }
        if (messageDigest == null) {
            return null;
        }
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        char[] cArr2 = new char[32];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = digest[i2];
            int i3 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i3 + 1;
            cArr2[i3] = cArr[b & 15];
        }
        return new java.lang.String(cArr2);
    }

    public static byte[] a(byte[] bArr) {
        java.security.MessageDigest messageDigest;
        try {
            messageDigest = java.security.MessageDigest.getInstance("MD5");
        } catch (java.security.NoSuchAlgorithmException e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            messageDigest = null;
        }
        if (messageDigest == null) {
            return null;
        }
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static byte[] b(byte[] bArr) {
        try {
            return java.security.MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            return null;
        }
    }
}
