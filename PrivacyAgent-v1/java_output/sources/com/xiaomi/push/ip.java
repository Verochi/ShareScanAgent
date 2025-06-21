package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ip extends com.xiaomi.push.ir {
    com.xiaomi.push.hy a;
    private int b;

    public ip(int i) {
        this.a = new com.xiaomi.push.hy(i);
    }

    @Override // com.xiaomi.push.ir
    public final int a(byte[] bArr, int i, int i2) {
        byte[] a = this.a.a();
        if (i2 > this.a.b() - this.b) {
            i2 = this.a.b() - this.b;
        }
        if (i2 > 0) {
            java.lang.System.arraycopy(a, this.b, bArr, i, i2);
            this.b += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.ir
    public final void b(byte[] bArr, int i, int i2) {
        this.a.write(bArr, i, i2);
    }
}
