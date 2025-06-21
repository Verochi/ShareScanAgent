package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
final class bc {
    java.io.RandomAccessFile a;

    public bc() throws java.io.IOException {
        this("", 0L);
    }

    public bc(java.lang.String str, long j) throws java.io.IOException {
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (java.io.IOException e) {
                com.amap.api.mapcore.util.gd.c(e, "FileAccessI", "create");
                e.printStackTrace();
            }
        }
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(str, "rw");
        this.a = randomAccessFile;
        randomAccessFile.seek(j);
    }

    public final synchronized int a(byte[] bArr) throws java.io.IOException {
        this.a.write(bArr);
        return bArr.length;
    }

    public final void a() {
        java.io.RandomAccessFile randomAccessFile = this.a;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            this.a = null;
        }
    }
}
