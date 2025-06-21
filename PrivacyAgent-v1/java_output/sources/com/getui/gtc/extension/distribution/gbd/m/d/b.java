package com.getui.gtc.extension.distribution.gbd.m.d;

/* loaded from: classes22.dex */
public abstract class b<T> {
    private T a;

    public enum a {
        HOST("HOST"),
        MAN("MAN"),
        MX("MX"),
        ST("ST");

        final java.lang.String e;

        a(java.lang.String str) {
            this.e = str;
        }

        private java.lang.String a() {
            return this.e;
        }
    }

    private void a(T t) {
        this.a = t;
    }

    private T b() {
        return this.a;
    }

    private static void c() {
    }

    public abstract java.lang.String a();

    public java.lang.String toString() {
        return "(" + getClass().getSimpleName() + ") '" + this.a + "'";
    }
}
