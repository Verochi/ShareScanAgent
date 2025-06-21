package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public abstract class dp {
    public abstract int a(byte[] bArr, int i, int i2) throws com.umeng.analytics.pro.dq;

    public void a(int i) {
    }

    public abstract boolean a();

    public abstract void b() throws com.umeng.analytics.pro.dq;

    public void b(byte[] bArr) throws com.umeng.analytics.pro.dq {
        b(bArr, 0, bArr.length);
    }

    public abstract void b(byte[] bArr, int i, int i2) throws com.umeng.analytics.pro.dq;

    public abstract void c();

    public int d(byte[] bArr, int i, int i2) throws com.umeng.analytics.pro.dq {
        int i3 = 0;
        while (i3 < i2) {
            int a = a(bArr, i + i3, i2 - i3);
            if (a <= 0) {
                throw new com.umeng.analytics.pro.dq("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i3 += a;
        }
        return i3;
    }

    public void d() throws com.umeng.analytics.pro.dq {
    }

    public byte[] f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return -1;
    }

    public boolean i() {
        return a();
    }
}
