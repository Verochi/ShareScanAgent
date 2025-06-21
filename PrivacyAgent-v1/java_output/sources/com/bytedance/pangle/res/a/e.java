package com.bytedance.pangle.res.a;

/* loaded from: classes.dex */
public final class e extends com.bytedance.pangle.res.a.j {
    private long a;

    public e(java.io.InputStream inputStream) {
        super(inputStream);
    }

    public final int a() {
        long b = b();
        if (b <= 2147483647L) {
            return (int) b;
        }
        throw new java.lang.ArithmeticException("The byte count " + b + " is too large to be converted to an int");
    }

    @Override // com.bytedance.pangle.res.a.j
    public final synchronized void a(int i) {
        if (i != -1) {
            this.a += i;
        }
    }

    public final synchronized long b() {
        return this.a;
    }

    @Override // com.bytedance.pangle.res.a.j, java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j) {
        long skip;
        skip = super.skip(j);
        this.a += skip;
        return skip;
    }
}
