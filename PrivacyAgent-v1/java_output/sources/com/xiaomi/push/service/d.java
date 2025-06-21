package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public class d {
    private static volatile com.xiaomi.push.service.d j;
    volatile java.lang.String b;
    android.content.Context c;
    private volatile java.lang.String i;
    final java.lang.Object a = new java.lang.Object();
    private final java.lang.Object d = new java.lang.Object();
    private final java.lang.String e = "mipush_region";
    private final java.lang.String f = "mipush_country_code";
    private final java.lang.String g = "mipush_region.lock";
    private final java.lang.String h = "mipush_country_code.lock";

    private d(android.content.Context context) {
        this.c = context;
    }

    public static com.xiaomi.push.service.d a(android.content.Context context) {
        if (j == null) {
            synchronized (com.xiaomi.push.service.d.class) {
                if (j == null) {
                    j = new com.xiaomi.push.service.d(context);
                }
            }
        }
        return j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.Closeable, java.io.RandomAccessFile] */
    private static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        java.nio.channels.FileLock fileLock;
        java.io.File file = new java.io.File(context.getFilesDir(), str);
        ?? r2 = 0;
        r2 = 0;
        if (!file.exists()) {
            com.xiaomi.channel.commonutils.logger.b.a("No ready file to get data from ".concat(java.lang.String.valueOf(str)));
            return null;
        }
        synchronized (obj) {
            try {
                try {
                    java.io.File file2 = new java.io.File(context.getFilesDir(), str2);
                    com.xiaomi.push.c.b(file2);
                    context = new java.io.RandomAccessFile(file2, "rw");
                } catch (java.lang.Throwable th) {
                    th = th;
                    r2 = str;
                }
            } catch (java.lang.Exception e) {
                e = e;
                context = 0;
                fileLock = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                context = 0;
            }
            try {
                fileLock = context.getChannel().lock();
                try {
                    java.lang.String a = com.xiaomi.push.c.a(file);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (java.io.IOException e2) {
                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                        }
                    }
                    com.xiaomi.push.c.a((java.io.Closeable) context);
                    return a;
                } catch (java.lang.Exception e3) {
                    e = e3;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (java.io.IOException e4) {
                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                        }
                    }
                    com.xiaomi.push.c.a((java.io.Closeable) context);
                    return null;
                }
            } catch (java.lang.Exception e5) {
                e = e5;
                fileLock = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                if (r2 != 0 && r2.isValid()) {
                    try {
                        r2.release();
                    } catch (java.io.IOException e6) {
                        com.xiaomi.channel.commonutils.logger.b.a(e6);
                    }
                }
                com.xiaomi.push.c.a((java.io.Closeable) context);
                throw th;
            }
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.Object obj) {
        java.io.RandomAccessFile randomAccessFile;
        synchronized (obj) {
            java.nio.channels.FileLock fileLock = null;
            try {
                java.io.File file = new java.io.File(context.getFilesDir(), str3);
                com.xiaomi.push.c.b(file);
                randomAccessFile = new java.io.RandomAccessFile(file, "rw");
                try {
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        com.xiaomi.push.c.a(new java.io.File(context.getFilesDir(), str2), str);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (java.io.IOException e) {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                            }
                        }
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (java.io.IOException e3) {
                                com.xiaomi.channel.commonutils.logger.b.a(e3);
                            }
                        }
                        com.xiaomi.push.c.a(randomAccessFile);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (java.io.IOException e4) {
                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                        }
                    }
                    com.xiaomi.push.c.a(randomAccessFile);
                    throw th;
                }
            } catch (java.lang.Exception e5) {
                e = e5;
                randomAccessFile = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                randomAccessFile = null;
                if (fileLock != null) {
                    fileLock.release();
                }
                com.xiaomi.push.c.a(randomAccessFile);
                throw th;
            }
            com.xiaomi.push.c.a(randomAccessFile);
        }
    }

    public final java.lang.String a() {
        if (android.text.TextUtils.isEmpty(this.b)) {
            this.b = a(this.c, "mipush_region", "mipush_region.lock", this.a);
        }
        return this.b;
    }

    public final void a(java.lang.String str) {
        if (android.text.TextUtils.equals(str, this.i)) {
            return;
        }
        this.i = str;
        a(this.c, this.i, "mipush_country_code", "mipush_country_code.lock", this.d);
    }

    public final java.lang.String b() {
        if (android.text.TextUtils.isEmpty(this.i)) {
            this.i = a(this.c, "mipush_country_code", "mipush_country_code.lock", this.d);
        }
        return this.i;
    }
}
