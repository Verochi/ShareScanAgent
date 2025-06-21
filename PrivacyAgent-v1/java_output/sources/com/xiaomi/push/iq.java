package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class iq extends com.xiaomi.push.ir {
    private byte[] a;
    private int b;
    private int c;

    @Override // com.xiaomi.push.ir
    public final int a(byte[] bArr, int i, int i2) {
        int c = c();
        if (i2 > c) {
            i2 = c;
        }
        if (i2 > 0) {
            java.lang.System.arraycopy(this.a, this.b, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.xiaomi.push.ir
    public final void a(int i) {
        this.b += i;
    }

    public final void a(byte[] bArr, int i) {
        this.a = bArr;
        this.b = 0;
        this.c = i + 0;
    }

    @Override // com.xiaomi.push.ir
    public final byte[] a() {
        return this.a;
    }

    @Override // com.xiaomi.push.ir
    public final int b() {
        return this.b;
    }

    @Override // com.xiaomi.push.ir
    public final void b(byte[] bArr, int i, int i2) {
        throw new java.lang.UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.ir
    public final int c() {
        return this.c - this.b;
    }
}
