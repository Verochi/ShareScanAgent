package com.tencent.open.utils;

/* loaded from: classes19.dex */
public final class m implements java.lang.Cloneable {
    private long a;

    public m(long j) {
        this.a = j;
    }

    public byte[] a() {
        long j = this.a;
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
    }

    public long b() {
        return this.a;
    }

    public boolean equals(java.lang.Object obj) {
        return obj != null && (obj instanceof com.tencent.open.utils.m) && this.a == ((com.tencent.open.utils.m) obj).b();
    }

    public int hashCode() {
        return (int) this.a;
    }
}
