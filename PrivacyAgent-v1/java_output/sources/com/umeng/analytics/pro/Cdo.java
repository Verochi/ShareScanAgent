package com.umeng.analytics.pro;

/* renamed from: com.umeng.analytics.pro.do, reason: invalid class name */
/* loaded from: classes19.dex */
public final class Cdo extends com.umeng.analytics.pro.dp {
    private byte[] a;
    private int b;
    private int c;

    public Cdo() {
    }

    public Cdo(byte[] bArr) {
        a(bArr);
    }

    public Cdo(byte[] bArr, int i, int i2) {
        c(bArr, i, i2);
    }

    @Override // com.umeng.analytics.pro.dp
    public int a(byte[] bArr, int i, int i2) throws com.umeng.analytics.pro.dq {
        int h = h();
        if (i2 > h) {
            i2 = h;
        }
        if (i2 > 0) {
            java.lang.System.arraycopy(this.a, this.b, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.umeng.analytics.pro.dp
    public void a(int i) {
        this.b += i;
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.dp
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.dp
    public void b() throws com.umeng.analytics.pro.dq {
    }

    @Override // com.umeng.analytics.pro.dp
    public void b(byte[] bArr, int i, int i2) throws com.umeng.analytics.pro.dq {
        throw new java.lang.UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.dp
    public void c() {
    }

    public void c(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i + i2;
    }

    public void e() {
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.dp
    public byte[] f() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.dp
    public int g() {
        return this.b;
    }

    @Override // com.umeng.analytics.pro.dp
    public int h() {
        return this.c - this.b;
    }
}
