package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class fn {
    public static final java.lang.String a = com.amap.api.mapcore.util.fi.c("SYmFja3Vwcw");
    public static final java.lang.String b = com.amap.api.mapcore.util.fi.c("SLmFkaXU");
    public static final java.lang.String c = com.amap.api.mapcore.util.fi.c("JIw");

    private static java.lang.String a(android.content.Context context) {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 31 || (context.getApplicationInfo().targetSdkVersion >= 30 && i >= 30)) {
            return context.getApplicationContext().getExternalFilesDir("").getAbsolutePath();
        }
        android.os.storage.StorageManager storageManager = (android.os.storage.StorageManager) context.getSystemService("storage");
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(com.amap.api.mapcore.util.fi.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            java.lang.reflect.Method method = storageManager.getClass().getMethod(com.amap.api.mapcore.util.fi.c("FZ2V0Vm9sdW1lTGlzdA"), new java.lang.Class[0]);
            java.lang.reflect.Method method2 = cls.getMethod(com.amap.api.mapcore.util.fi.c("ZZ2V0UGF0aA"), new java.lang.Class[0]);
            java.lang.reflect.Method method3 = cls.getMethod(com.amap.api.mapcore.util.fi.c("AaXNSZW1vdmFibGUK"), new java.lang.Class[0]);
            java.lang.Object invoke = method.invoke(storageManager, new java.lang.Object[0]);
            int length = java.lang.reflect.Array.getLength(invoke);
            for (int i2 = 0; i2 < length; i2++) {
                java.lang.Object obj = java.lang.reflect.Array.get(invoke, i2);
                java.lang.String str = (java.lang.String) method2.invoke(obj, new java.lang.Object[0]);
                if (!((java.lang.Boolean) method3.invoke(obj, new java.lang.Object[0])).booleanValue()) {
                    return str;
                }
            }
            return null;
        } catch (java.lang.Throwable unused) {
            return android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        }
    }

    public static synchronized void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.nio.channels.FileChannel fileChannel;
        java.io.RandomAccessFile randomAccessFile;
        synchronized (com.amap.api.mapcore.util.fn.class) {
            java.lang.String a2 = a(context);
            if (android.text.TextUtils.isEmpty(a2)) {
                return;
            }
            java.lang.String str3 = str + c + str2;
            java.io.File file = new java.io.File(a2 + java.io.File.separator + a);
            java.io.File file2 = new java.io.File(file, b);
            java.nio.channels.FileLock fileLock = null;
            try {
                if (!file.exists() || file.isDirectory()) {
                    file.mkdirs();
                }
                file2.createNewFile();
                randomAccessFile = new java.io.RandomAccessFile(file2, "rws");
                try {
                    fileChannel = randomAccessFile.getChannel();
                } catch (java.lang.Throwable unused) {
                    fileChannel = null;
                }
            } catch (java.lang.Throwable unused2) {
                fileChannel = null;
                randomAccessFile = null;
            }
            try {
                fileLock = fileChannel.tryLock();
                if (fileLock != null) {
                    fileChannel.write(java.nio.ByteBuffer.wrap(str3.getBytes("UTF-8")));
                }
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (java.io.IOException unused3) {
                    }
                }
                try {
                    fileChannel.close();
                } catch (java.io.IOException unused4) {
                }
                try {
                    randomAccessFile.close();
                } catch (java.lang.Throwable unused5) {
                }
            } catch (java.lang.Throwable unused6) {
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (java.io.IOException unused7) {
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (java.io.IOException unused8) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (java.lang.Throwable unused9) {
                    }
                }
            }
        }
    }
}
