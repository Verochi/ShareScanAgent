package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class a {
    public static final com.xiaomi.push.a b = new com.xiaomi.push.a(new byte[0]);
    final byte[] a;
    private volatile int c = 0;

    private a(byte[] bArr) {
        this.a = bArr;
    }

    public static com.xiaomi.push.a a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static com.xiaomi.push.a a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        java.lang.System.arraycopy(bArr, i, bArr2, 0, i2);
        return new com.xiaomi.push.a(bArr2);
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.xiaomi.push.a)) {
            return false;
        }
        byte[] bArr = this.a;
        int length = bArr.length;
        byte[] bArr2 = ((com.xiaomi.push.a) obj).a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = this.c;
        if (i == 0) {
            byte[] bArr = this.a;
            int length = bArr.length;
            for (byte b2 : bArr) {
                length = (length * 31) + b2;
            }
            i = length == 0 ? 1 : length;
            this.c = i;
        }
        return i;
    }
}
