package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class dq extends com.umeng.analytics.pro.ci {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    private static final long g = 1;
    protected int f;

    public dq() {
        this.f = 0;
    }

    public dq(int i) {
        this.f = i;
    }

    public dq(int i, java.lang.String str) {
        super(str);
        this.f = i;
    }

    public dq(int i, java.lang.String str, java.lang.Throwable th) {
        super(str, th);
        this.f = i;
    }

    public dq(int i, java.lang.Throwable th) {
        super(th);
        this.f = i;
    }

    public dq(java.lang.String str) {
        super(str);
        this.f = 0;
    }

    public dq(java.lang.String str, java.lang.Throwable th) {
        super(str, th);
        this.f = 0;
    }

    public dq(java.lang.Throwable th) {
        super(th);
        this.f = 0;
    }

    public int a() {
        return this.f;
    }
}
