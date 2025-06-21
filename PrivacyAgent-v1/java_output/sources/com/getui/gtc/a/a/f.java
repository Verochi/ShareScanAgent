package com.getui.gtc.a.a;

/* loaded from: classes22.dex */
public final class f {
    private static final char[] a = {'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT, 'm', 'n', 'o', 'p', 'q', com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT, 's', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static java.lang.String a(java.lang.String str) {
        java.security.MessageDigest messageDigest;
        byte[] bytes = str.getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
        try {
            messageDigest = java.security.MessageDigest.getInstance("MD5");
        } catch (java.lang.Exception e) {
            com.getui.gtc.h.c.a.c(e);
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
        byte[] a2;
        if (bArr == null || (a2 = com.getui.gtc.a.a.e.a(bArr)) == null) {
            return null;
        }
        java.lang.String a3 = a(java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        int length = a2.length;
        byte[] bArr2 = new byte[length + 16];
        byte[] bytes = a3.substring(0, 8).getBytes();
        byte[] bytes2 = a3.substring(24, 32).getBytes();
        java.lang.System.arraycopy(bytes, 0, bArr2, 0, 8);
        java.lang.System.arraycopy(a2, 0, bArr2, 8, length);
        java.lang.System.arraycopy(bytes2, 0, bArr2, length + 8, 8);
        return bArr2;
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length - 16];
        java.lang.System.arraycopy(bArr, 8, bArr2, 0, bArr.length - 16);
        return com.getui.gtc.a.a.e.b(bArr2);
    }
}
