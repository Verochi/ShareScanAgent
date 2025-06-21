package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class cw {
    public final java.lang.String a;
    public final byte b;
    public final short c;

    public cw() {
        this("", (byte) 0, (short) 0);
    }

    public cw(java.lang.String str, byte b, short s2) {
        this.a = str;
        this.b = b;
        this.c = s2;
    }

    public boolean a(com.umeng.analytics.pro.cw cwVar) {
        return this.b == cwVar.b && this.c == cwVar.c;
    }

    public java.lang.String toString() {
        return "<TField name:'" + this.a + "' type:" + ((int) this.b) + " field-id:" + ((int) this.c) + ">";
    }
}
