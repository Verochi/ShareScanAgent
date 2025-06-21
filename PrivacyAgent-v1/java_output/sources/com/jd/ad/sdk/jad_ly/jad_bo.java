package com.jd.ad.sdk.jad_ly;

/* loaded from: classes23.dex */
public class jad_bo {
    public com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper jad_an = null;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
    
        if (android.text.TextUtils.isEmpty(r7) == false) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x00b1 -> B:40:0x00ce). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String jad_an(com.jd.ad.sdk.jad_ly.jad_bo jad_boVar, android.content.Context context, java.io.InputStream inputStream, java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.io.File externalFilesDir;
        java.io.IOException e;
        ?? fileOutputStream;
        jad_boVar.getClass();
        str2 = "";
        try {
        } catch (java.lang.Exception e2) {
            e = e2;
            str3 = "";
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf(47);
            int lastIndexOf2 = str.lastIndexOf(46);
            if (lastIndexOf != -1 && lastIndexOf2 != -1 && lastIndexOf2 > lastIndexOf) {
                str4 = str.substring(lastIndexOf + 1, lastIndexOf2);
                if (!android.text.TextUtils.isEmpty(str4)) {
                    str3 = android.text.TextUtils.isEmpty(str4) ? "" : android.util.Base64.encodeToString(str4.getBytes(), 10);
                    try {
                        if (android.text.TextUtils.isEmpty(str3)) {
                        }
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        str4 = str3;
                        ?? r1 = 0;
                        r1 = 0;
                        r1 = 0;
                        externalFilesDir = context.getExternalFilesDir(null);
                        if (!externalFilesDir.exists()) {
                        }
                    }
                    str4 = str3;
                    ?? r12 = 0;
                    r12 = 0;
                    r12 = 0;
                    externalFilesDir = context.getExternalFilesDir(null);
                    if (!externalFilesDir.exists()) {
                        return "";
                    }
                    java.io.File file = new java.io.File(externalFilesDir, str4);
                    try {
                        try {
                        } catch (java.lang.Throwable th) {
                            th = th;
                        }
                    } catch (java.io.IOException e4) {
                        e4.printStackTrace();
                    }
                    if (file.exists()) {
                        return file.getPath();
                    }
                    try {
                        fileOutputStream = new java.io.FileOutputStream(file);
                    } catch (java.io.IOException e5) {
                        e = e5;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            r12 = inputStream.read(bArr);
                            if (r12 == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, r12);
                        }
                        str2 = file.exists() ? file.getPath() : "";
                        try {
                            inputStream.close();
                            inputStream = inputStream;
                        } catch (java.io.IOException e6) {
                            e6.printStackTrace();
                            inputStream = e6;
                        }
                        fileOutputStream.close();
                    } catch (java.io.IOException e7) {
                        e = e7;
                        r12 = fileOutputStream;
                        e.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.io.IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (r12 != 0) {
                            r12.close();
                        }
                        return str2;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        r12 = fileOutputStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.io.IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        if (r12 == 0) {
                            throw th;
                        }
                        try {
                            r12.close();
                            throw th;
                        } catch (java.io.IOException e10) {
                            e10.printStackTrace();
                            throw th;
                        }
                    }
                    return str2;
                }
            }
        }
        str4 = "";
        ?? r122 = 0;
        r122 = 0;
        r122 = 0;
        externalFilesDir = context.getExternalFilesDir(null);
        if (!externalFilesDir.exists()) {
        }
    }

    public final void jad_an(com.jd.ad.sdk.bl.video.listener.VideoLoadListener videoLoadListener, int i, java.lang.String str) {
        if (videoLoadListener == null) {
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str = com.jd.ad.sdk.dl.error.JADError.DEFAULT_ERROR.getMessage(new java.lang.String[0]);
        }
        videoLoadListener.onLoadFailure(i, str);
    }
}
