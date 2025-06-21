package com.alimm.tanx.core.web.cache.utils;

/* loaded from: classes.dex */
public class OKHttpFile {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_METADATA = 0;

    public static java.io.InputStream getCacheFile(java.io.File file, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.lang.String hex = okio.ByteString.encodeUtf8(str.toString()).md5().hex();
        java.lang.String absolutePath = file.getAbsolutePath();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(hex);
        sb.append(".");
        boolean z = false;
        sb.append(0);
        java.io.File file2 = new java.io.File(absolutePath, sb.toString());
        java.io.File file3 = new java.io.File(file.getAbsolutePath(), hex + ".1");
        if (file2.exists() && file3.exists()) {
            try {
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader(file2), 1024);
                while (true) {
                    java.lang.String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (readLine.contains("Content-Encoding") && readLine.contains("gzip")) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                return !z ? new java.io.FileInputStream(file3) : okio.Okio.buffer(new okio.GzipSource(okio.Okio.source(file3))).inputStream();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
