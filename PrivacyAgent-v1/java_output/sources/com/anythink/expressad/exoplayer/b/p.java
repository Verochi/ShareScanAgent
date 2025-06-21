package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
final class p implements com.anythink.expressad.exoplayer.b.f {
    private int b = -1;
    private int c = -1;
    private int d = 0;
    private java.nio.ByteBuffer e;
    private java.nio.ByteBuffer f;
    private boolean g;

    public p() {
        java.nio.ByteBuffer byteBuffer = com.anythink.expressad.exoplayer.b.f.a;
        this.e = byteBuffer;
        this.f = byteBuffer;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0081 A[ADDED_TO_REGION, LOOP:2: B:24:0x0081->B:25:0x0083, LOOP_START, PHI: r0
  0x0081: PHI (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:10:0x0041, B:25:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // com.anythink.expressad.exoplayer.b.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(java.nio.ByteBuffer byteBuffer) {
        int i;
        int i2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i3 = limit - position;
        int i4 = this.d;
        if (i4 == Integer.MIN_VALUE) {
            i3 /= 3;
        } else if (i4 != 3) {
            if (i4 != 1073741824) {
                throw new java.lang.IllegalStateException();
            }
            i = i3 / 2;
            if (this.e.capacity() >= i) {
                this.e = java.nio.ByteBuffer.allocateDirect(i).order(java.nio.ByteOrder.nativeOrder());
            } else {
                this.e.clear();
            }
            i2 = this.d;
            if (i2 != Integer.MIN_VALUE) {
                while (position < limit) {
                    this.e.put(byteBuffer.get(position + 1));
                    this.e.put(byteBuffer.get(position + 2));
                    position += 3;
                }
            } else if (i2 == 3) {
                while (position < limit) {
                    this.e.put((byte) 0);
                    this.e.put((byte) ((byteBuffer.get(position) & 255) + com.alipay.sdk.m.n.a.g));
                    position++;
                }
            } else {
                if (i2 != 1073741824) {
                    throw new java.lang.IllegalStateException();
                }
                while (position < limit) {
                    this.e.put(byteBuffer.get(position + 2));
                    this.e.put(byteBuffer.get(position + 3));
                    position += 4;
                }
            }
            byteBuffer.position(byteBuffer.limit());
            this.e.flip();
            this.f = this.e;
        }
        i = i3 * 2;
        if (this.e.capacity() >= i) {
        }
        i2 = this.d;
        if (i2 != Integer.MIN_VALUE) {
        }
        byteBuffer.position(byteBuffer.limit());
        this.e.flip();
        this.f = this.e;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a() {
        int i = this.d;
        return (i == 0 || i == 2) ? false : true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a(int i, int i2, int i3) {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new com.anythink.expressad.exoplayer.b.f.a(i, i2, i3);
        }
        if (this.b == i && this.c == i2 && this.d == i3) {
            return false;
        }
        this.b = i;
        this.c = i2;
        this.d = i3;
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int b() {
        return this.c;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int c() {
        return 2;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int d() {
        return this.b;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void e() {
        this.g = true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final java.nio.ByteBuffer f() {
        java.nio.ByteBuffer byteBuffer = this.f;
        this.f = com.anythink.expressad.exoplayer.b.f.a;
        return byteBuffer;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean g() {
        return this.g && this.f == com.anythink.expressad.exoplayer.b.f.a;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void h() {
        this.f = com.anythink.expressad.exoplayer.b.f.a;
        this.g = false;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void i() {
        h();
        this.b = -1;
        this.c = -1;
        this.d = 0;
        this.e = com.anythink.expressad.exoplayer.b.f.a;
    }
}
