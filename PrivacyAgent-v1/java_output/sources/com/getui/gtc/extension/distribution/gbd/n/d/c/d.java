package com.getui.gtc.extension.distribution.gbd.n.d.c;

/* loaded from: classes22.dex */
public final class d {
    private int a;
    private java.lang.String b;

    public d(int i, java.lang.String str) {
        this.a = i;
        this.b = str;
    }

    public d(int i, java.lang.String str, java.lang.Object... objArr) {
        this.b = java.lang.String.format(str, objArr);
        this.a = i;
    }

    private java.lang.String a() {
        return this.b;
    }

    private int b() {
        return this.a;
    }

    public final java.lang.String toString() {
        return this.a + ": " + this.b;
    }
}
