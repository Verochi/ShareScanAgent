package com.igexin.push.core.d;

/* loaded from: classes31.dex */
public final class c {
    public static final java.lang.String a = "guard.me";
    public static final java.lang.String b = "guard.others";
    private static final java.lang.String c = "GuardConfig";
    private static final com.igexin.push.core.d.c d = new com.igexin.push.core.d.c();
    private long e;
    private final java.util.Map<java.lang.String, java.lang.String> f = new java.util.HashMap();

    /* renamed from: com.igexin.push.core.d.c$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass1 extends com.igexin.push.core.g.a<java.io.RandomAccessFile> {
        public AnonymousClass1() {
        }

        private void a() {
            com.igexin.push.core.d.c.this.b();
        }

        @Override // com.igexin.push.core.g.a
        public final /* bridge */ /* synthetic */ void a(java.io.RandomAccessFile randomAccessFile) {
            com.igexin.push.core.d.c.this.b();
        }
    }

    /* renamed from: com.igexin.push.core.d.c$2, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass2 extends com.igexin.push.core.g.a<java.io.RandomAccessFile> {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.Object b;

        public AnonymousClass2(java.lang.String str, java.lang.Object obj) {
            this.a = str;
            this.b = obj;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(java.io.RandomAccessFile randomAccessFile) {
            if (com.igexin.push.core.d.c.this.b()) {
                com.igexin.push.core.d.c.this.a(randomAccessFile);
            }
            com.igexin.push.core.d.c.this.f.put(this.a, java.lang.String.valueOf(this.b));
            try {
                randomAccessFile.setLength(0L);
                for (java.util.Map.Entry entry : com.igexin.push.core.d.c.this.f.entrySet()) {
                    randomAccessFile.writeBytes(((java.lang.String) entry.getKey()) + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + ((java.lang.String) entry.getValue()));
                    randomAccessFile.writeBytes("\n");
                }
            } catch (java.io.IOException e) {
                com.igexin.c.a.c.a.a(e);
            }
        }

        @Override // com.igexin.push.core.g.a
        public final /* synthetic */ void a(java.io.RandomAccessFile randomAccessFile) {
            java.io.RandomAccessFile randomAccessFile2 = randomAccessFile;
            if (com.igexin.push.core.d.c.this.b()) {
                com.igexin.push.core.d.c.this.a(randomAccessFile2);
            }
            com.igexin.push.core.d.c.this.f.put(this.a, java.lang.String.valueOf(this.b));
            try {
                randomAccessFile2.setLength(0L);
                for (java.util.Map.Entry entry : com.igexin.push.core.d.c.this.f.entrySet()) {
                    randomAccessFile2.writeBytes(((java.lang.String) entry.getKey()) + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + ((java.lang.String) entry.getValue()));
                    randomAccessFile2.writeBytes("\n");
                }
            } catch (java.io.IOException e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    /* renamed from: com.igexin.push.core.d.c$3, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass3 extends com.igexin.push.core.g.a<java.io.RandomAccessFile> {
        public AnonymousClass3() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(java.io.RandomAccessFile randomAccessFile) {
            com.igexin.push.core.d.c.this.a(randomAccessFile);
        }

        @Override // com.igexin.push.core.g.a
        public final /* bridge */ /* synthetic */ void a(java.io.RandomAccessFile randomAccessFile) {
            com.igexin.push.core.d.c.this.a(randomAccessFile);
        }
    }

    private c() {
        try {
            if (android.text.TextUtils.isEmpty(com.igexin.push.h.j.g)) {
                com.igexin.push.h.j.a();
            }
            java.io.File file = new java.io.File(com.igexin.push.h.j.g);
            if (file.exists()) {
                return;
            }
            file.createNewFile();
        } catch (java.io.IOException e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private int a(java.lang.String str, int... iArr) {
        try {
            return java.lang.Integer.parseInt(b(str));
        } catch (java.lang.NumberFormatException e) {
            com.igexin.c.a.c.a.a(e);
            if (iArr == null || iArr.length != 1) {
                return -1;
            }
            return iArr[0];
        }
    }

    private long a(java.lang.String str, long... jArr) {
        try {
            return java.lang.Long.parseLong(b(str));
        } catch (java.lang.NumberFormatException e) {
            com.igexin.c.a.c.a.a(e);
            if (jArr == null || jArr.length != 1) {
                return 0L;
            }
            return jArr[0];
        }
    }

    public static com.igexin.push.core.d.c a() {
        return d;
    }

    private static void a(com.igexin.push.core.g.a<java.io.RandomAccessFile> aVar) {
        java.io.RandomAccessFile randomAccessFile;
        java.nio.channels.FileLock fileLock = null;
        try {
            randomAccessFile = new java.io.RandomAccessFile(new java.io.File(com.igexin.push.h.j.g), "rw");
            try {
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    if (fileLock.isValid()) {
                        aVar.a((com.igexin.push.core.g.a<java.io.RandomAccessFile>) randomAccessFile);
                    }
                    if (fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (java.io.IOException unused) {
                        }
                    }
                    com.getui.gtc.base.util.io.IOUtils.safeClose(randomAccessFile);
                } catch (java.lang.Exception e) {
                    e = e;
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("GuardConfig| getProcessLock err：" + e.toString(), new java.lang.Object[0]);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    com.getui.gtc.base.util.io.IOUtils.safeClose(randomAccessFile);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (java.io.IOException unused3) {
                    }
                }
                com.getui.gtc.base.util.io.IOUtils.safeClose(randomAccessFile);
                throw th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            randomAccessFile = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (fileLock != null) {
                fileLock.release();
            }
            com.getui.gtc.base.util.io.IOUtils.safeClose(randomAccessFile);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(java.io.RandomAccessFile randomAccessFile) {
        int i;
        try {
            this.f.clear();
            while (true) {
                java.lang.String readLine = randomAccessFile.readLine();
                if (readLine == null) {
                    return true;
                }
                int indexOf = readLine.indexOf(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                if (indexOf >= 0 && (i = indexOf + 1) != readLine.length()) {
                    this.f.put(readLine.substring(0, indexOf), readLine.substring(i));
                }
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return false;
        }
    }

    private java.lang.String b(java.lang.String str) {
        if (b()) {
            a(new com.igexin.push.core.d.c.AnonymousClass3());
        }
        return this.f.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        long lastModified = new java.io.File(com.igexin.push.h.j.g).lastModified();
        boolean z = this.e != lastModified;
        this.e = lastModified;
        return z;
    }

    private static java.lang.Boolean c(java.lang.String str) {
        if (str == null) {
            return null;
        }
        if (str.equalsIgnoreCase(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE)) {
            return java.lang.Boolean.TRUE;
        }
        if (str.equalsIgnoreCase(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
            return java.lang.Boolean.FALSE;
        }
        return null;
    }

    public final java.lang.Boolean a(java.lang.String str) {
        java.lang.String b2 = b(str);
        if (b2 == null) {
            return null;
        }
        return c(b2);
    }

    public final void a(java.lang.String str, java.lang.Object obj) {
        a(new com.igexin.push.core.d.c.AnonymousClass2(str, obj).a((com.igexin.push.core.g.a) new com.igexin.push.core.d.c.AnonymousClass1()));
    }
}
