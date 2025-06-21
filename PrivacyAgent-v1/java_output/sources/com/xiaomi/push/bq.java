package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class bq {
    int a;
    long b;
    long c;
    java.lang.String d;
    long e;

    public bq() {
        this(0, 0L, 0L, null);
    }

    public bq(int i, long j, long j2, java.lang.Exception exc) {
        this.a = i;
        this.b = j;
        this.e = j2;
        this.c = java.lang.System.currentTimeMillis();
        if (exc != null) {
            this.d = exc.getClass().getSimpleName();
        }
    }
}
