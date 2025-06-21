package com.tencent.open.utils;

/* loaded from: classes19.dex */
public final class n implements java.lang.Cloneable {
    private int a;

    public n(int i) {
        this.a = i;
    }

    public n(byte[] bArr) {
        this(bArr, 0);
    }

    public n(byte[] bArr, int i) {
        this.a = ((bArr[i + 1] << 8) & androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr[i] & 255);
    }

    public byte[] a() {
        int i = this.a;
        return new byte[]{(byte) (i & 255), (byte) ((i & androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    public int b() {
        return this.a;
    }

    public boolean equals(java.lang.Object obj) {
        return obj != null && (obj instanceof com.tencent.open.utils.n) && this.a == ((com.tencent.open.utils.n) obj).b();
    }

    public int hashCode() {
        return this.a;
    }
}
