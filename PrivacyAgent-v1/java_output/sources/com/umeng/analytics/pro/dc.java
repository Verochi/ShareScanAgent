package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class dc extends com.umeng.analytics.pro.ci {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    private static final long h = 1;
    protected int g;

    public dc() {
        this.g = 0;
    }

    public dc(int i) {
        this.g = i;
    }

    public dc(int i, java.lang.String str) {
        super(str);
        this.g = i;
    }

    public dc(int i, java.lang.String str, java.lang.Throwable th) {
        super(str, th);
        this.g = i;
    }

    public dc(int i, java.lang.Throwable th) {
        super(th);
        this.g = i;
    }

    public dc(java.lang.String str) {
        super(str);
        this.g = 0;
    }

    public dc(java.lang.String str, java.lang.Throwable th) {
        super(str, th);
        this.g = 0;
    }

    public dc(java.lang.Throwable th) {
        super(th);
        this.g = 0;
    }

    public int a() {
        return this.g;
    }
}
