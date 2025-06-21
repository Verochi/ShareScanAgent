package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class ce extends java.io.ByteArrayOutputStream {
    public ce() {
    }

    public ce(int i) {
        super(i);
    }

    public byte[] a() {
        return ((java.io.ByteArrayOutputStream) this).buf;
    }

    public int b() {
        return ((java.io.ByteArrayOutputStream) this).count;
    }
}
