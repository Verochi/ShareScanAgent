package com.aliyun.svideo.common;

/* loaded from: classes.dex */
public class CertUtils {
    public static final java.lang.String CERT_NAME = "cert";
    private static java.lang.String SD_DIR = null;
    private static java.lang.String TAG = "CertUtils";

    public static java.lang.String copyCert(android.content.Context context) {
        SD_DIR = getExtFileDir(context);
        copySelf(context, CERT_NAME);
        return SD_DIR + CERT_NAME + java.io.File.separator + "AliVideoCert.crt";
    }

    private static void copySelf(android.content.Context context, java.lang.String str) {
        try {
            java.lang.String[] list = context.getAssets().list(str);
            if (list.length <= 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("copy....");
                sb.append(SD_DIR);
                sb.append(str);
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(SD_DIR + str);
                java.io.InputStream open = context.getAssets().open(str);
                byte[] bArr = new byte[8192];
                for (int read = open.read(bArr); read > 0; read = open.read(bArr)) {
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                open.close();
                fileOutputStream.close();
                return;
            }
            java.io.File file = new java.io.File(SD_DIR + str);
            if (!file.exists()) {
                file.mkdirs();
            }
            for (java.lang.String str2 : list) {
                if (!new java.io.File(SD_DIR + str + java.io.File.separator + str2).exists()) {
                    copySelf(context, str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str2);
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private static java.lang.String getExtFileDir(android.content.Context context) {
        return context.getExternalFilesDir("") + java.io.File.separator;
    }
}
