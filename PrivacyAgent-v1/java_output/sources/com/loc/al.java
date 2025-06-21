package com.loc;

/* loaded from: classes23.dex */
public final class al {
    public static final java.lang.String a = com.loc.y.c("SYmFja3Vwcw");
    public static final java.lang.String b = com.loc.y.c("SLmFkaXU");
    public static final java.lang.String c = com.loc.y.c("JIw");

    private static java.lang.String a(android.content.Context context) {
        try {
            java.io.File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = context.getCacheDir();
            }
            if (externalCacheDir != null) {
                return externalCacheDir.getAbsolutePath();
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static synchronized void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.nio.channels.FileChannel fileChannel;
        java.io.RandomAccessFile randomAccessFile;
        synchronized (com.loc.al.class) {
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
                    try {
                        fileLock = fileChannel.tryLock();
                        if (fileLock != null) {
                            fileChannel.write(java.nio.ByteBuffer.wrap(str3.getBytes("UTF-8")));
                        }
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (java.io.IOException unused) {
                            }
                        }
                        try {
                            fileChannel.close();
                        } catch (java.io.IOException unused2) {
                        }
                        a(randomAccessFile);
                    } catch (java.lang.Throwable unused3) {
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (java.io.IOException unused4) {
                            }
                        }
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (java.io.IOException unused5) {
                            }
                        }
                        a(randomAccessFile);
                    }
                } catch (java.lang.Throwable unused6) {
                    fileChannel = null;
                }
            } catch (java.lang.Throwable unused7) {
                fileChannel = null;
                randomAccessFile = null;
            }
        }
    }

    private static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.Throwable unused) {
            }
        }
    }
}
