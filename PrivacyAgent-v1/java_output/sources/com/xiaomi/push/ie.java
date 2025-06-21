package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ie {
    public final java.lang.String a;
    public final byte b;
    public final short c;

    public ie() {
        this("", (byte) 0, (short) 0);
    }

    public ie(java.lang.String str, byte b, short s2) {
        this.a = str;
        this.b = b;
        this.c = s2;
    }

    public final java.lang.String toString() {
        return "<TField name:'" + this.a + "' type:" + ((int) this.b) + " field-id:" + ((int) this.c) + ">";
    }
}
