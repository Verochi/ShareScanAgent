package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public abstract class a implements com.alipay.android.phone.mrpc.core.v {
    public java.lang.reflect.Method a;
    public byte[] b;
    public java.lang.String c;
    public int d;
    public java.lang.String e;
    public boolean f;

    public a(java.lang.reflect.Method method, int i, java.lang.String str, byte[] bArr, java.lang.String str2, boolean z) {
        this.a = method;
        this.d = i;
        this.c = str;
        this.b = bArr;
        this.e = str2;
        this.f = z;
    }
}
