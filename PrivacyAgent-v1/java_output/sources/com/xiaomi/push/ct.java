package com.xiaomi.push;

/* loaded from: classes19.dex */
public abstract class ct extends com.xiaomi.push.m.a {
    protected int a;
    protected android.content.Context b;

    public ct(android.content.Context context, int i) {
        this.a = i;
        this.b = context;
    }

    public static void a(android.content.Context context, com.xiaomi.push.gs gsVar) {
        com.xiaomi.push.cn cnVar = com.xiaomi.push.co.a().a;
        java.lang.String a = cnVar == null ? "" : cnVar.a();
        if (android.text.TextUtils.isEmpty(a) || android.text.TextUtils.isEmpty(gsVar.c)) {
            return;
        }
        a(context, gsVar, a);
    }

    private static void a(android.content.Context context, com.xiaomi.push.gs gsVar, java.lang.String str) {
        java.io.BufferedOutputStream bufferedOutputStream;
        java.io.RandomAccessFile randomAccessFile;
        java.nio.channels.FileLock lock;
        java.io.File file;
        byte[] b = com.xiaomi.push.cp.b(str, com.xiaomi.push.hv.a(gsVar));
        if (b == null || b.length == 0) {
            return;
        }
        synchronized (com.xiaomi.push.cq.a) {
            java.nio.channels.FileLock fileLock = null;
            try {
                java.io.File file2 = new java.io.File(context.getExternalFilesDir(null), "push_cdata.lock");
                com.xiaomi.push.c.b(file2);
                randomAccessFile = new java.io.RandomAccessFile(file2, "rw");
                try {
                    lock = randomAccessFile.getChannel().lock();
                    try {
                        file = new java.io.File(context.getExternalFilesDir(null), "push_cdata.data");
                        bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file, true));
                    } catch (java.io.IOException e) {
                        e = e;
                        bufferedOutputStream = null;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedOutputStream = null;
                    }
                } catch (java.io.IOException e2) {
                    e = e2;
                    bufferedOutputStream = null;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                }
                try {
                    bufferedOutputStream.write(com.xiaomi.push.g.a(b.length));
                    bufferedOutputStream.write(b);
                    bufferedOutputStream.flush();
                    file.setLastModified(0L);
                    if (lock != null && lock.isValid()) {
                        try {
                            lock.release();
                        } catch (java.io.IOException unused) {
                        }
                    }
                    com.xiaomi.push.c.a(bufferedOutputStream);
                } catch (java.io.IOException e3) {
                    e = e3;
                    fileLock = lock;
                    try {
                        e.printStackTrace();
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (java.io.IOException unused2) {
                            }
                        }
                        com.xiaomi.push.c.a(bufferedOutputStream);
                        com.xiaomi.push.c.a(randomAccessFile);
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (java.io.IOException unused3) {
                            }
                        }
                        com.xiaomi.push.c.a(bufferedOutputStream);
                        com.xiaomi.push.c.a(randomAccessFile);
                        throw th;
                    }
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    fileLock = lock;
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    com.xiaomi.push.c.a(bufferedOutputStream);
                    com.xiaomi.push.c.a(randomAccessFile);
                    throw th;
                }
            } catch (java.io.IOException e4) {
                e = e4;
                bufferedOutputStream = null;
                randomAccessFile = null;
            } catch (java.lang.Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
                randomAccessFile = null;
            }
            com.xiaomi.push.c.a(randomAccessFile);
        }
    }

    public abstract java.lang.String b();

    public abstract com.xiaomi.push.gm c();

    @Override // java.lang.Runnable
    public void run() {
        java.lang.String b = b();
        if (android.text.TextUtils.isEmpty(b)) {
            return;
        }
        android.content.Context context = this.b;
        java.lang.String valueOf = java.lang.String.valueOf(a());
        long j = this.a;
        boolean z = false;
        if (com.xiaomi.push.service.ad.a(context).a(com.xiaomi.push.gp.DCJobMutualSwitch.bw, false) && ((android.os.Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !com.xiaomi.push.k.a(context, valueOf, j))) {
            z = true;
        }
        if (z) {
            com.xiaomi.channel.commonutils.logger.b.a("DC run job mutual: " + a());
            return;
        }
        com.xiaomi.push.cn cnVar = com.xiaomi.push.co.a().a;
        java.lang.String a = cnVar == null ? "" : cnVar.a();
        if (android.text.TextUtils.isEmpty(a)) {
            return;
        }
        com.xiaomi.push.gs gsVar = new com.xiaomi.push.gs();
        gsVar.c = b;
        gsVar.a(java.lang.System.currentTimeMillis());
        gsVar.b = c();
        a(this.b, gsVar, a);
    }
}
