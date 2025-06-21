package com.getui.gtc.h.a;

/* loaded from: classes22.dex */
public class a {
    static final /* synthetic */ boolean a = true;

    public static java.lang.String a(java.lang.String str) {
        byte[] bytes = str.getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
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
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static void a(java.io.File file, java.io.File file2, java.lang.String str) {
        java.io.FileOutputStream fileOutputStream;
        java.io.BufferedOutputStream bufferedOutputStream;
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new java.io.FileInputStream(file);
            try {
                fileOutputStream = new java.io.FileOutputStream(file2);
                try {
                    bufferedOutputStream = new java.io.BufferedOutputStream(fileOutputStream);
                } catch (java.lang.Exception e) {
                    e = e;
                    bufferedOutputStream = null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedOutputStream = null;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                fileOutputStream = null;
                bufferedOutputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream = null;
                bufferedOutputStream = null;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            fileOutputStream = null;
            bufferedOutputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = null;
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byte[] bArr2 = new byte[read];
                java.lang.System.arraycopy(bArr, 0, bArr2, 0, read);
                bufferedOutputStream.write(com.getui.gtc.h.a.b.a(bArr2, str));
            }
            bufferedOutputStream.flush();
            com.getui.gtc.base.util.io.IOUtils.safeClose(fileInputStream);
        } catch (java.lang.Exception e4) {
            e = e4;
            fileInputStream2 = fileInputStream;
            try {
                com.getui.gtc.h.c.a.c(e);
                com.getui.gtc.h.b.a.a(file2);
                com.getui.gtc.base.util.io.IOUtils.safeClose(fileInputStream2);
                com.getui.gtc.base.util.io.IOUtils.safeClose(bufferedOutputStream);
                com.getui.gtc.base.util.io.IOUtils.safeClose(fileOutputStream);
            } catch (java.lang.Throwable th4) {
                th = th4;
                com.getui.gtc.base.util.io.IOUtils.safeClose(fileInputStream2);
                com.getui.gtc.base.util.io.IOUtils.safeClose(bufferedOutputStream);
                com.getui.gtc.base.util.io.IOUtils.safeClose(fileOutputStream);
                throw th;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            fileInputStream2 = fileInputStream;
            com.getui.gtc.base.util.io.IOUtils.safeClose(fileInputStream2);
            com.getui.gtc.base.util.io.IOUtils.safeClose(bufferedOutputStream);
            com.getui.gtc.base.util.io.IOUtils.safeClose(fileOutputStream);
            throw th;
        }
        com.getui.gtc.base.util.io.IOUtils.safeClose(bufferedOutputStream);
        com.getui.gtc.base.util.io.IOUtils.safeClose(fileOutputStream);
    }
}
