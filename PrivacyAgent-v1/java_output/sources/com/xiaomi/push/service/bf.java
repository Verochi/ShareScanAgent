package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class bf implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;
    final /* synthetic */ com.xiaomi.push.go b;

    public bf(android.content.Context context, com.xiaomi.push.go goVar) {
        this.a = context;
        this.b = goVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.io.RandomAccessFile randomAccessFile;
        synchronized (com.xiaomi.push.service.be.a) {
            java.nio.channels.FileLock fileLock = null;
            try {
                java.io.File file = new java.io.File(this.a.getFilesDir(), "tiny_data.lock");
                com.xiaomi.push.c.b(file);
                randomAccessFile = new java.io.RandomAccessFile(file, "rw");
                try {
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        com.xiaomi.push.service.be.b(this.a, this.b);
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
}
