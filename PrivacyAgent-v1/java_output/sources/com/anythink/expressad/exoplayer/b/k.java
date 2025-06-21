package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
final class k implements com.anythink.expressad.exoplayer.b.f {
    private int b;
    private int c;

    @androidx.annotation.Nullable
    private int[] d;
    private boolean e;

    @androidx.annotation.Nullable
    private int[] f;
    private java.nio.ByteBuffer g;
    private java.nio.ByteBuffer h;
    private boolean i;

    public k() {
        java.nio.ByteBuffer byteBuffer = com.anythink.expressad.exoplayer.b.f.a;
        this.g = byteBuffer;
        this.h = byteBuffer;
        this.b = -1;
        this.c = -1;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void a(java.nio.ByteBuffer byteBuffer) {
        com.anythink.expressad.exoplayer.k.a.b(this.f != null);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.b * 2)) * this.f.length * 2;
        if (this.g.capacity() < length) {
            this.g = java.nio.ByteBuffer.allocateDirect(length).order(java.nio.ByteOrder.nativeOrder());
        } else {
            this.g.clear();
        }
        while (position < limit) {
            for (int i : this.f) {
                this.g.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.b * 2;
        }
        byteBuffer.position(limit);
        this.g.flip();
        this.h = this.g;
    }

    public final void a(@androidx.annotation.Nullable int[] iArr) {
        this.d = iArr;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a() {
        return this.e;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a(int i, int i2, int i3) {
        boolean z = !java.util.Arrays.equals(this.d, this.f);
        int[] iArr = this.d;
        this.f = iArr;
        if (iArr == null) {
            this.e = false;
            return z;
        }
        if (i3 != 2) {
            throw new com.anythink.expressad.exoplayer.b.f.a(i, i2, i3);
        }
        if (!z && this.c == i && this.b == i2) {
            return false;
        }
        this.c = i;
        this.b = i2;
        this.e = i2 != iArr.length;
        int i4 = 0;
        while (true) {
            int[] iArr2 = this.f;
            if (i4 >= iArr2.length) {
                return true;
            }
            int i5 = iArr2[i4];
            if (i5 >= i2) {
                throw new com.anythink.expressad.exoplayer.b.f.a(i, i2, i3);
            }
            this.e = (i5 != i4) | this.e;
            i4++;
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int b() {
        int[] iArr = this.f;
        return iArr == null ? this.b : iArr.length;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int c() {
        return 2;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int d() {
        return this.c;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void e() {
        this.i = true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final java.nio.ByteBuffer f() {
        java.nio.ByteBuffer byteBuffer = this.h;
        this.h = com.anythink.expressad.exoplayer.b.f.a;
        return byteBuffer;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean g() {
        return this.i && this.h == com.anythink.expressad.exoplayer.b.f.a;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void h() {
        this.h = com.anythink.expressad.exoplayer.b.f.a;
        this.i = false;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void i() {
        h();
        this.g = com.anythink.expressad.exoplayer.b.f.a;
        this.b = -1;
        this.c = -1;
        this.f = null;
        this.d = null;
        this.e = false;
    }
}
