package com.bytedance.pangle.g;

/* loaded from: classes12.dex */
final class h implements com.bytedance.pangle.g.k {
    private final java.nio.ByteBuffer a;

    public h(java.nio.ByteBuffer byteBuffer) {
        this.a = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.a.capacity();
    }

    @Override // com.bytedance.pangle.g.k
    public final void a(com.bytedance.pangle.g.j jVar, long j, int i) {
        java.nio.ByteBuffer slice;
        synchronized (this.a) {
            this.a.position(0);
            int i2 = (int) j;
            this.a.limit(i + i2);
            this.a.position(i2);
            slice = this.a.slice();
        }
        jVar.a(slice);
    }
}
