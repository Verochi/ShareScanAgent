package com.huawei.hms.base.log;

/* loaded from: classes22.dex */
public class c {
    public java.lang.String b;
    public java.lang.String c;
    public int d;
    public java.lang.String g;
    public int h;
    public int i;
    public int j;
    public final java.lang.StringBuilder a = new java.lang.StringBuilder();
    public long e = 0;
    public long f = 0;

    public c(int i, java.lang.String str, int i2, java.lang.String str2) {
        this.c = "HMS";
        this.j = i;
        this.b = str;
        this.d = i2;
        if (str2 != null) {
            this.c = str2;
        }
        b();
    }

    public static java.lang.String a(int i) {
        return i != 3 ? i != 4 ? i != 5 ? i != 6 ? java.lang.String.valueOf(i) : androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST : androidx.exifinterface.media.ExifInterface.LONGITUDE_WEST : "I" : "D";
    }

    public <T> com.huawei.hms.base.log.c a(T t) {
        this.a.append(t);
        return this;
    }

    public com.huawei.hms.base.log.c a(java.lang.Throwable th) {
        a((com.huawei.hms.base.log.c) '\n').a((com.huawei.hms.base.log.c) android.util.Log.getStackTraceString(th));
        return this;
    }

    public java.lang.String a() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        a(sb);
        return sb.toString();
    }

    public final java.lang.StringBuilder a(java.lang.StringBuilder sb) {
        sb.append(' ');
        sb.append(this.a.toString());
        return sb;
    }

    public final com.huawei.hms.base.log.c b() {
        this.e = java.lang.System.currentTimeMillis();
        java.lang.Thread currentThread = java.lang.Thread.currentThread();
        this.f = currentThread.getId();
        this.h = android.os.Process.myPid();
        java.lang.StackTraceElement[] stackTrace = currentThread.getStackTrace();
        int length = stackTrace.length;
        int i = this.j;
        if (length > i) {
            java.lang.StackTraceElement stackTraceElement = stackTrace[i];
            this.g = stackTraceElement.getFileName();
            this.i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    public final java.lang.StringBuilder b(java.lang.StringBuilder sb) {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", java.util.Locale.getDefault());
        sb.append('[');
        sb.append(simpleDateFormat.format(java.lang.Long.valueOf(this.e)));
        java.lang.String a = a(this.d);
        sb.append(' ');
        sb.append(a);
        sb.append('/');
        sb.append(this.c);
        sb.append('/');
        sb.append(this.b);
        sb.append(' ');
        sb.append(this.h);
        sb.append(':');
        sb.append(this.f);
        sb.append(' ');
        sb.append(this.g);
        sb.append(':');
        sb.append(this.i);
        sb.append(']');
        return sb;
    }

    public java.lang.String c() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        b(sb);
        return sb.toString();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        b(sb);
        a(sb);
        return sb.toString();
    }
}
