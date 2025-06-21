package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public class l {
    protected static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
    protected static java.security.MessageDigest b = null;
    private static java.lang.String c = "SameFileMD5";

    static {
        b = null;
        try {
            b = java.security.MessageDigest.getInstance("MD5");
        } catch (java.security.NoSuchAlgorithmException e) {
            java.lang.System.err.println(com.anythink.expressad.foundation.h.l.class.getName() + "Init fail,MessageDigest not support MD5Util.");
            e.printStackTrace();
        }
    }

    public static java.lang.String a(java.io.File file) {
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new java.io.FileInputStream(file);
        } catch (java.lang.Exception unused) {
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            b.update(fileInputStream.getChannel().map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0L, file.length()));
            byte[] digest = b.digest();
            java.lang.String a2 = a(digest, digest.length);
            fileInputStream.close();
            return a2;
        } catch (java.lang.Exception unused2) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 == null) {
                return "";
            }
            fileInputStream2.close();
            return "";
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    private static java.lang.String a(java.lang.String str) {
        return a(new java.io.File(str));
    }

    private static java.lang.String a(byte[] bArr) {
        return a(bArr, bArr.length);
    }

    private static java.lang.String a(byte[] bArr, int i) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(i * 2);
        int i2 = i + 0;
        for (int i3 = 0; i3 < i2; i3++) {
            a(bArr[i3], stringBuffer);
        }
        return stringBuffer.toString();
    }

    private static void a(byte b2, java.lang.StringBuffer stringBuffer) {
        char[] cArr = a;
        char c2 = cArr[(b2 & 240) >> 4];
        char c3 = cArr[b2 & 15];
        stringBuffer.append(c2);
        stringBuffer.append(c3);
    }
}
