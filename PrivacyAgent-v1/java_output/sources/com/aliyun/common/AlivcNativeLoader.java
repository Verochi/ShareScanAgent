package com.aliyun.common;

/* loaded from: classes.dex */
public class AlivcNativeLoader {
    private static java.lang.String a = null;
    private static final java.lang.String b = "AlivcNativeLoader";
    private static final java.util.List<java.lang.String> c = new java.util.ArrayList();
    private static final byte[] d = new byte[0];
    private static com.aliyun.common.AlivcNativeLoader.LoadLibraryCallback e = null;

    @com.aliyun.aio.keep.API
    public interface LoadLibraryCallback {
        void loadResult(java.lang.String str, boolean z, com.aliyun.common.AlivcNativeLoader.LoaderMessage loaderMessage);
    }

    @com.aliyun.aio.keep.API
    public static class LoaderMessage {
        public java.lang.String fileMd5;
        public int type = 0;
        public java.lang.String loadPath = "system";

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("type:");
            sb.append(this.type == 0 ? "system" : "custom");
            sb.append(" loadPath:");
            sb.append(this.loadPath);
            sb.append(" fileMd5:");
            sb.append(this.fileMd5);
            return sb.toString();
        }
    }

    public static class a {
        static boolean a;

        public static void a(java.lang.String str) {
            if (a) {
                java.lang.String unused = com.aliyun.common.AlivcNativeLoader.b;
            }
        }

        public static void a(java.lang.String str, java.lang.Throwable th) {
            if (a) {
                java.lang.String unused = com.aliyun.common.AlivcNativeLoader.b;
            }
        }

        public static void b(java.lang.String str) {
            if (a) {
                java.lang.String unused = com.aliyun.common.AlivcNativeLoader.b;
            }
        }
    }

    public static java.lang.String a(java.io.File file) {
        int i;
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                } finally {
                    fileInputStream.close();
                }
            }
            byte[] digest = messageDigest.digest();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b2 : digest) {
                java.lang.String hexString = java.lang.Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static void a(java.lang.String str) {
        com.aliyun.common.AlivcNativeLoader.LoaderMessage loaderMessage = new com.aliyun.common.AlivcNativeLoader.LoaderMessage();
        com.aliyun.common.AlivcNativeLoader.a.b("onLoadSuccess soName:" + str + " message: " + loaderMessage);
        com.aliyun.common.AlivcNativeLoader.LoadLibraryCallback loadLibraryCallback = e;
        if (loadLibraryCallback != null) {
            loadLibraryCallback.loadResult(str, true, loaderMessage);
        }
    }

    private static void a(java.lang.String str, com.aliyun.common.AlivcNativeLoader.LoaderMessage loaderMessage) {
        com.aliyun.common.AlivcNativeLoader.a.a("onLoadFailed soName:" + str + " message: " + loaderMessage);
        com.aliyun.common.AlivcNativeLoader.LoadLibraryCallback loadLibraryCallback = e;
        if (loadLibraryCallback != null) {
            loadLibraryCallback.loadResult(str, false, loaderMessage);
        }
    }

    private static void b() {
        b(com.aliyun.svideosdk.nativeload.AbstractNativeLoader.SHARED_LIBRARY_FFMPEG_NAME);
        b("all_in_one");
    }

    private static boolean b(java.lang.String str) {
        boolean z;
        java.lang.String str2 = a + "/lib" + str + ".so";
        try {
            java.lang.System.load(str2);
            z = true;
        } catch (java.lang.Throwable th) {
            com.aliyun.common.AlivcNativeLoader.a.a("failed to System.load lib" + str + ".so", th);
            z = false;
        }
        if (z) {
            synchronized (d) {
                java.util.List<java.lang.String> list = c;
                if (!list.contains(str)) {
                    list.add(str);
                }
            }
            a(str);
        } else {
            com.aliyun.common.AlivcNativeLoader.LoaderMessage loaderMessage = new com.aliyun.common.AlivcNativeLoader.LoaderMessage();
            loaderMessage.type = 1;
            loaderMessage.loadPath = str2;
            loaderMessage.fileMd5 = a(new java.io.File(str2));
            a(str, loaderMessage);
        }
        return z;
    }

    private static boolean c(java.lang.String str) {
        boolean z;
        try {
            java.lang.System.loadLibrary(str);
            z = true;
        } catch (java.lang.Throwable th) {
            com.aliyun.common.AlivcNativeLoader.a.a("failed to System.loadLibrary lib" + str + ".so", th);
            z = false;
        }
        if (z) {
            synchronized (d) {
                java.util.List<java.lang.String> list = c;
                if (!list.contains(str)) {
                    list.add(str);
                }
            }
            a(str);
        } else {
            a(str, new com.aliyun.common.AlivcNativeLoader.LoaderMessage());
        }
        return z;
    }

    @com.aliyun.aio.keep.API
    public static java.lang.String getNativePath() {
        return a;
    }

    @com.aliyun.aio.keep.API
    public static boolean loadLibrary(java.lang.String str) {
        synchronized (d) {
            if (c.contains(str)) {
                return true;
            }
            if (!android.text.TextUtils.isEmpty(a) && new java.io.File(a).exists()) {
                boolean b2 = b(str);
                if (!b2) {
                    com.aliyun.common.AlivcNativeLoader.a.a("load " + str + " from custom error, try to load from system");
                    b2 = c(str);
                    if (!b2) {
                        com.aliyun.common.AlivcNativeLoader.a.a("load " + str + " from system error");
                    }
                }
                return b2;
            }
            return c(str);
        }
    }

    @com.aliyun.aio.keep.API
    public static boolean setNativePath(java.lang.String str) {
        if (!new java.io.File(str).exists()) {
            return false;
        }
        a = str;
        b();
        com.aliyun.common.AlivcNativeLoader.a.a = true;
        return true;
    }

    @com.aliyun.aio.keep.API
    public static boolean setNativePath(java.lang.String str, com.aliyun.common.AlivcNativeLoader.LoadLibraryCallback loadLibraryCallback) {
        if (!new java.io.File(str).exists()) {
            return false;
        }
        a = str;
        b();
        e = loadLibraryCallback;
        com.aliyun.common.AlivcNativeLoader.a.a = true;
        return true;
    }
}
