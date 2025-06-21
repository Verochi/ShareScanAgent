package com.anythink.expressad.exoplayer.d;

/* loaded from: classes12.dex */
public final class o extends java.lang.Exception {
    public static final int a = 1;
    public static final int b = 2;
    public final int c;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface a {
    }

    private o(int i) {
        this.c = i;
    }

    public o(java.lang.Exception exc) {
        super(exc);
        this.c = 2;
    }
}
