package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class gf {
    private static boolean a;

    public static class a implements java.lang.Runnable {
        private android.content.Context a;
        private com.xiaomi.push.gi b;

        public a(android.content.Context context, com.xiaomi.push.gi giVar) {
            this.b = giVar;
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.xiaomi.push.gf.b(this.a, this.b);
        }
    }

    public static void a(android.content.Context context, com.xiaomi.push.gi giVar) {
        com.xiaomi.push.m.a(context).a(new com.xiaomi.push.gf.a(context, giVar), 0);
    }

    private static void a(android.content.Context context, com.xiaomi.push.gi giVar, java.io.File file, byte[] bArr) {
        java.lang.String concat;
        int a2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 4;
        byte[] bArr2 = new byte[4];
        java.io.BufferedInputStream bufferedInputStream = null;
        try {
            try {
                java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    try {
                        int read = bufferedInputStream2.read(bArr2);
                        if (read != -1) {
                            if (read == i) {
                                a2 = com.xiaomi.push.g.a(bArr2);
                                if (a2 <= 0 || a2 > 10240) {
                                    break;
                                }
                                byte[] bArr3 = new byte[a2];
                                int read2 = bufferedInputStream2.read(bArr3);
                                if (read2 != a2) {
                                    concat = "TinyData read from cache file failed cause buffer size not equal length. size:" + read2 + "__length:" + a2;
                                    break;
                                }
                                byte[] a3 = com.xiaomi.push.hb.a(bArr, bArr3);
                                if (a3 != null && a3.length != 0) {
                                    com.xiaomi.push.go goVar = new com.xiaomi.push.go();
                                    com.xiaomi.push.hv.a(goVar, a3);
                                    java.lang.String valueOf = java.lang.String.valueOf(a3.length);
                                    if (goVar.j == null) {
                                        goVar.j = new java.util.HashMap();
                                    }
                                    goVar.j.put("item_size", valueOf);
                                    arrayList.add(goVar);
                                    i2++;
                                    i3 += a3.length;
                                    if (i2 >= 8 || i3 >= 10240) {
                                        com.xiaomi.push.gg.a(context, giVar, arrayList);
                                        arrayList.clear();
                                        i2 = 0;
                                        i3 = 0;
                                    }
                                    i = 4;
                                }
                                com.xiaomi.channel.commonutils.logger.b.d("TinyData read from cache file failed cause decrypt fail");
                                i = 4;
                            } else {
                                concat = "TinyData read from cache file failed cause lengthBuffer error. size:".concat(java.lang.String.valueOf(read));
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        bufferedInputStream = bufferedInputStream2;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        com.xiaomi.push.c.a(bufferedInputStream);
                        return;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        com.xiaomi.push.c.a(bufferedInputStream);
                        throw th;
                    }
                }
                concat = "TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:".concat(java.lang.String.valueOf(a2));
                com.xiaomi.channel.commonutils.logger.b.d(concat);
                com.xiaomi.push.gg.a(context, giVar, arrayList);
                if (file.exists() && !file.delete()) {
                    com.xiaomi.channel.commonutils.logger.b.a("TinyData delete reading temp file failed");
                }
                com.xiaomi.push.c.a(bufferedInputStream2);
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void b(android.content.Context context, com.xiaomi.push.gi giVar) {
        java.io.RandomAccessFile randomAccessFile;
        java.io.File file;
        if (a) {
            com.xiaomi.channel.commonutils.logger.b.a("TinyData extractTinyData is running");
            return;
        }
        a = true;
        java.io.File file2 = new java.io.File(context.getFilesDir(), "tiny_data.data");
        if (!file2.exists()) {
            com.xiaomi.channel.commonutils.logger.b.a("TinyData no ready file to get data.");
            return;
        }
        java.io.File file3 = new java.io.File(context.getFilesDir() + "/tdReadTemp");
        if (!file3.exists()) {
            file3.mkdirs();
        }
        byte[] a2 = com.xiaomi.push.service.be.a(context);
        java.nio.channels.FileLock fileLock = null;
        try {
            try {
                java.io.File file4 = new java.io.File(context.getFilesDir(), "tiny_data.lock");
                com.xiaomi.push.c.b(file4);
                randomAccessFile = new java.io.RandomAccessFile(file4, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    file2.renameTo(new java.io.File(context.getFilesDir() + "/tdReadTemp/tiny_data.data"));
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (java.io.IOException e) {
                            e = e;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            com.xiaomi.push.c.a(randomAccessFile);
                            file = new java.io.File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                            if (file.exists()) {
                            }
                        }
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (java.io.IOException e3) {
                            e = e3;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            com.xiaomi.push.c.a(randomAccessFile);
                            file = new java.io.File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                            if (file.exists()) {
                            }
                        }
                    }
                    com.xiaomi.push.c.a(randomAccessFile);
                    file = new java.io.File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
                    if (file.exists()) {
                    }
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
        file = new java.io.File(context.getFilesDir() + "/tdReadTemp/tiny_data.data");
        if (file.exists()) {
            com.xiaomi.channel.commonutils.logger.b.a("TinyData no ready file to get data.");
            return;
        }
        a(context, giVar, file, a2);
        com.xiaomi.push.ge.b();
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 4).edit();
        edit.putLong("last_tiny_data_upload_timestamp", java.lang.System.currentTimeMillis() / 1000);
        edit.commit();
        a = false;
    }
}
