package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class je {
    private static final java.util.Set<java.lang.String> e = java.util.Collections.synchronizedSet(new java.util.HashSet());
    private android.content.Context a;
    private java.nio.channels.FileLock b;
    private java.lang.String c;
    private java.io.RandomAccessFile d;

    private je(android.content.Context context) {
        this.a = context;
    }

    public static com.xiaomi.push.je a(android.content.Context context, java.io.File file) {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        java.lang.String str = file.getAbsolutePath() + ".LOCK";
        java.io.File file2 = new java.io.File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        java.util.Set<java.lang.String> set = e;
        if (!set.add(str)) {
            throw new java.io.IOException("abtain lock failure");
        }
        com.xiaomi.push.je jeVar = new com.xiaomi.push.je(context);
        jeVar.c = str;
        try {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file2, "rw");
            jeVar.d = randomAccessFile;
            jeVar.b = randomAccessFile.getChannel().lock();
            com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + jeVar.b);
            if (jeVar.b == null) {
                java.io.RandomAccessFile randomAccessFile2 = jeVar.d;
                if (randomAccessFile2 != null) {
                    com.xiaomi.push.c.a(randomAccessFile2);
                }
                set.remove(jeVar.c);
            }
            return jeVar;
        } catch (java.lang.Throwable th) {
            if (jeVar.b == null) {
                java.io.RandomAccessFile randomAccessFile3 = jeVar.d;
                if (randomAccessFile3 != null) {
                    com.xiaomi.push.c.a(randomAccessFile3);
                }
                e.remove(jeVar.c);
            }
            throw th;
        }
    }

    public final void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.b);
        java.nio.channels.FileLock fileLock = this.b;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.b.release();
            } catch (java.io.IOException unused) {
            }
            this.b = null;
        }
        java.io.RandomAccessFile randomAccessFile = this.d;
        if (randomAccessFile != null) {
            com.xiaomi.push.c.a(randomAccessFile);
        }
        e.remove(this.c);
    }
}
