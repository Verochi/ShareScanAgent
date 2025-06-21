package com.tencent.open.log;

/* loaded from: classes19.dex */
public class b {
    private static java.text.SimpleDateFormat a = com.tencent.open.log.d.C0503d.a("yy.MM.dd.HH");
    private java.io.File g;
    private java.lang.String b = "Tracer.File";
    private int c = Integer.MAX_VALUE;
    private int d = Integer.MAX_VALUE;
    private int e = 4096;
    private long f = 10000;
    private int h = 10;
    private java.lang.String i = com.anythink.china.common.a.a.f;
    private long j = Long.MAX_VALUE;

    public b(java.io.File file, int i, int i2, int i3, java.lang.String str, long j, int i4, java.lang.String str2, long j2) {
        a(file);
        b(i);
        a(i2);
        c(i3);
        a(str);
        a(j);
        d(i4);
        b(str2);
        b(j2);
    }

    private java.lang.String c(java.lang.String str) {
        return "com.tencent.mobileqq_connectSdk." + str + com.anythink.china.common.a.a.f;
    }

    private java.io.File[] c(long j) {
        java.io.File file;
        java.io.File b = b();
        java.lang.String c = c(d(j));
        try {
            b = new java.io.File(b, c);
        } catch (java.lang.Throwable th) {
            com.tencent.open.log.SLog.e(com.tencent.open.log.SLog.TAG, "getWorkFile,get old sdcard file exception:", th);
        }
        java.lang.String b2 = com.tencent.open.utils.l.b();
        if (!android.text.TextUtils.isEmpty(b2) || b2 != null) {
            try {
                java.io.File file2 = new java.io.File(b2, com.tencent.open.log.c.o);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new java.io.File(file2, c);
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.e(com.tencent.open.log.SLog.TAG, "getWorkFile,get app specific file exception:", e);
            }
            return new java.io.File[]{b, file};
        }
        file = null;
        return new java.io.File[]{b, file};
    }

    private java.lang.String d(long j) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return new java.text.SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(java.io.File file) {
        this.g = file;
    }

    public void a(java.lang.String str) {
        this.b = str;
    }

    public java.io.File[] a() {
        return c(java.lang.System.currentTimeMillis());
    }

    public java.io.File b() {
        java.io.File e = e();
        if (e != null) {
            e.mkdirs();
        }
        return e;
    }

    public void b(int i) {
        this.d = i;
    }

    public void b(long j) {
        this.j = j;
    }

    public void b(java.lang.String str) {
        this.i = str;
    }

    public java.lang.String c() {
        return this.b;
    }

    public void c(int i) {
        this.e = i;
    }

    public int d() {
        return this.e;
    }

    public void d(int i) {
        this.h = i;
    }

    public java.io.File e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }
}
