package com.tencent.mm.opensdk.utils;

/* loaded from: classes19.dex */
public final class b {
    public static android.content.Context a;
    private static final int b;
    private static final int c;
    private static final int d;
    public static java.util.concurrent.ThreadPoolExecutor e;

    static {
        int availableProcessors = java.lang.Runtime.getRuntime().availableProcessors();
        b = availableProcessors;
        int i = availableProcessors + 1;
        c = i;
        int i2 = (availableProcessors * 2) + 1;
        d = i2;
        e = new java.util.concurrent.ThreadPoolExecutor(i, i2, 1L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingDeque());
    }

    public static int a(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        com.tencent.mm.opensdk.utils.Log.i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver == null || uri == null) {
            com.tencent.mm.opensdk.utils.Log.w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
            return 0;
        }
        java.io.InputStream inputStream = null;
        try {
            try {
                java.io.InputStream openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (java.io.IOException unused) {
                        }
                    }
                    return 0;
                }
                int available = openInputStream.available();
                try {
                    openInputStream.close();
                } catch (java.io.IOException unused2) {
                }
                return available;
            } catch (java.lang.Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e2) {
            com.tencent.mm.opensdk.utils.Log.w("MicroMsg.SDK.Util", "getFileSize fail, " + e2.getMessage());
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (java.io.IOException unused4) {
                }
            }
            return 0;
        }
    }

    public static int a(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        if (a != null && str.startsWith("content")) {
            try {
                return a(a.getContentResolver(), android.net.Uri.parse(str));
            } catch (java.lang.Exception unused) {
            }
        }
        return 0;
    }

    public static int a(java.lang.String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return str.length() <= 0 ? i : java.lang.Integer.parseInt(str);
        } catch (java.lang.Exception unused) {
            return i;
        }
    }

    public static boolean a(int i) {
        return i == 36 || i == 46;
    }

    public static boolean b(java.lang.String str) {
        return str == null || str.length() <= 0;
    }
}
