package com.xiaomi.push;

/* loaded from: classes19.dex */
public abstract class da {
    public abstract int a();

    public abstract void a(com.xiaomi.push.az azVar);

    public final void a(byte[] bArr, int i, int i2) {
        try {
            com.xiaomi.push.az a = com.xiaomi.push.az.a(bArr, i, i2);
            a(a);
            a.b();
        } catch (java.io.IOException unused) {
            throw new java.lang.RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    public abstract int b();

    public abstract com.xiaomi.push.da b(com.xiaomi.push.z zVar);

    public final com.xiaomi.push.da b(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public final com.xiaomi.push.da b(byte[] bArr, int i, int i2) {
        try {
            com.xiaomi.push.z zVar = new com.xiaomi.push.z(bArr, i, i2);
            b(zVar);
            zVar.a(0);
            return this;
        } catch (com.xiaomi.push.ca e) {
            throw e;
        } catch (java.io.IOException unused) {
            throw new java.lang.RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public final byte[] c() {
        int b = b();
        byte[] bArr = new byte[b];
        a(bArr, 0, b);
        return bArr;
    }
}
