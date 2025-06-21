package com.otaliastudios.cameraview.video.encoding;

/* loaded from: classes19.dex */
class ByteBufferPool extends com.otaliastudios.cameraview.internal.Pool<java.nio.ByteBuffer> {

    /* renamed from: com.otaliastudios.cameraview.video.encoding.ByteBufferPool$1, reason: invalid class name */
    public class AnonymousClass1 implements com.otaliastudios.cameraview.internal.Pool.Factory<java.nio.ByteBuffer> {
        public final /* synthetic */ int a;

        public AnonymousClass1(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.internal.Pool.Factory
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.nio.ByteBuffer create() {
            return java.nio.ByteBuffer.allocateDirect(this.a);
        }
    }

    public ByteBufferPool(int i, int i2) {
        super(i2, new com.otaliastudios.cameraview.video.encoding.ByteBufferPool.AnonymousClass1(i));
    }
}
