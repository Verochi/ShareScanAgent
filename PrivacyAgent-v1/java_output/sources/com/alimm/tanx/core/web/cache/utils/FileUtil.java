package com.alimm.tanx.core.web.cache.utils;

/* loaded from: classes.dex */
public class FileUtil {
    public static void copy(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        byte[] bArr = new byte[512];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                inputStream.close();
                outputStream.close();
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void deleteDirs(java.lang.String str, boolean z) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            for (java.io.File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    deleteDirs(file2.getAbsolutePath(), z);
                } else {
                    file2.delete();
                }
            }
            if (z) {
                file.delete();
            }
        }
    }
}
