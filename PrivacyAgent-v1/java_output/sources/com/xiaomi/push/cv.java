package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class cv extends com.xiaomi.push.m.a {
    private android.content.Context a;
    private android.content.SharedPreferences b;
    private com.xiaomi.push.service.ad c;

    public cv(android.content.Context context) {
        this.a = context;
        this.b = context.getSharedPreferences("mipush_extra", 0);
        this.c = com.xiaomi.push.service.ad.a(context);
    }

    private java.util.List<com.xiaomi.push.gs> a(java.io.File file) {
        java.io.RandomAccessFile randomAccessFile;
        java.io.FileInputStream fileInputStream;
        com.xiaomi.push.cn cnVar = com.xiaomi.push.co.a().a;
        java.lang.String a = cnVar == null ? "" : cnVar.a();
        java.nio.channels.FileLock fileLock = null;
        if (android.text.TextUtils.isEmpty(a)) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        byte[] bArr = new byte[4];
        synchronized (com.xiaomi.push.cq.a) {
            try {
                java.io.File file2 = new java.io.File(this.a.getExternalFilesDir(null), "push_cdata.lock");
                com.xiaomi.push.c.b(file2);
                randomAccessFile = new java.io.RandomAccessFile(file2, "rw");
                try {
                    java.nio.channels.FileLock lock = randomAccessFile.getChannel().lock();
                    try {
                        fileInputStream = new java.io.FileInputStream(file);
                        while (fileInputStream.read(bArr) == 4) {
                            try {
                                int a2 = com.xiaomi.push.g.a(bArr);
                                byte[] bArr2 = new byte[a2];
                                if (fileInputStream.read(bArr2) != a2) {
                                    break;
                                }
                                byte[] a3 = com.xiaomi.push.cp.a(a, bArr2);
                                if (a3 != null && a3.length != 0) {
                                    com.xiaomi.push.gs gsVar = new com.xiaomi.push.gs();
                                    com.xiaomi.push.hv.a(gsVar, a3);
                                    arrayList.add(gsVar);
                                    if (gsVar.b == com.xiaomi.push.gm.AppInstallList && !gsVar.c.startsWith("same_")) {
                                        android.content.SharedPreferences.Editor edit = this.b.edit();
                                        edit.putLong("dc_job_result_time_4", gsVar.a);
                                        edit.putString("dc_job_result_4", com.xiaomi.push.ao.a(gsVar.c));
                                        edit.commit();
                                    }
                                }
                            } catch (java.lang.Exception unused) {
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (java.io.IOException unused2) {
                                    }
                                }
                                com.xiaomi.push.c.a(fileInputStream);
                                com.xiaomi.push.c.a(randomAccessFile);
                                return arrayList;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (java.io.IOException unused3) {
                                    }
                                }
                                com.xiaomi.push.c.a(fileInputStream);
                                com.xiaomi.push.c.a(randomAccessFile);
                                throw th;
                            }
                        }
                        if (lock != null && lock.isValid()) {
                            try {
                                lock.release();
                            } catch (java.io.IOException unused4) {
                            }
                        }
                        com.xiaomi.push.c.a(fileInputStream);
                    } catch (java.lang.Exception unused5) {
                        fileInputStream = null;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                    }
                } catch (java.lang.Exception unused6) {
                    fileInputStream = null;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
            } catch (java.lang.Exception unused7) {
                randomAccessFile = null;
                fileInputStream = null;
            } catch (java.lang.Throwable th4) {
                th = th4;
                randomAccessFile = null;
                fileInputStream = null;
            }
            com.xiaomi.push.c.a(randomAccessFile);
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.m.a
    public final java.lang.String a() {
        return "1";
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bd, code lost:
    
        if (r1 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c6, code lost:
    
        if (com.xiaomi.push.ai.h(r15.a) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x007d, code lost:
    
        if (r1 != false) goto L22;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z;
        java.io.File file = new java.io.File(this.a.getExternalFilesDir(null), "push_cdata.data");
        if (!com.xiaomi.push.ai.c(this.a)) {
            if (file.length() > 1863680) {
                file.delete();
                return;
            }
            return;
        }
        if (!com.xiaomi.push.ai.d(this.a)) {
            z = true;
            if (com.xiaomi.push.ai.f(this.a) || com.xiaomi.push.ai.e(this.a)) {
                if (this.c.a(com.xiaomi.push.gp.Upload4GSwitch.bw, true)) {
                    boolean z2 = java.lang.Math.abs((java.lang.System.currentTimeMillis() / 1000) - this.b.getLong("last_upload_data_timestamp", -1L)) > ((long) java.lang.Math.max(86400, this.c.a(com.xiaomi.push.gp.Upload4GFrequency.bw, com.anythink.expressad.d.a.b.bx)));
                }
            }
            if (com.xiaomi.push.ai.g(this.a)) {
                if (this.c.a(com.xiaomi.push.gp.Upload3GSwitch.bw, true)) {
                    boolean z3 = java.lang.Math.abs((java.lang.System.currentTimeMillis() / 1000) - this.b.getLong("last_upload_data_timestamp", -1L)) > ((long) java.lang.Math.max(86400, this.c.a(com.xiaomi.push.gp.Upload3GFrequency.bw, 432000)));
                }
            }
        }
        z = false;
        if (!z && file.exists()) {
            java.util.List<com.xiaomi.push.gs> a = a(file);
            if (!com.xiaomi.push.h.a(a)) {
                int size = a.size();
                if (size > 4000) {
                    a = a.subList(size - 4000, size);
                }
                com.xiaomi.push.he heVar = new com.xiaomi.push.he();
                heVar.a = a;
                byte[] a2 = com.xiaomi.push.c.a(com.xiaomi.push.hv.a(heVar));
                com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk("-1", false);
                hkVar.e = com.xiaomi.push.gu.DataCollection.ah;
                hkVar.a(a2);
                com.xiaomi.push.cn cnVar = com.xiaomi.push.co.a().a;
                if (cnVar != null) {
                    cnVar.a(hkVar, com.xiaomi.push.gk.Notification, null);
                }
                android.content.SharedPreferences.Editor edit = this.b.edit();
                edit.putLong("last_upload_data_timestamp", java.lang.System.currentTimeMillis() / 1000);
                edit.commit();
            }
            file.delete();
        }
    }
}
