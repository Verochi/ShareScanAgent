package com.otaliastudios.cameraview.video.encoding;

/* loaded from: classes19.dex */
class InputBufferPool extends com.otaliastudios.cameraview.internal.Pool<com.otaliastudios.cameraview.video.encoding.InputBuffer> {

    /* renamed from: com.otaliastudios.cameraview.video.encoding.InputBufferPool$1, reason: invalid class name */
    public class AnonymousClass1 implements com.otaliastudios.cameraview.internal.Pool.Factory<com.otaliastudios.cameraview.video.encoding.InputBuffer> {
        @Override // com.otaliastudios.cameraview.internal.Pool.Factory
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.otaliastudios.cameraview.video.encoding.InputBuffer create() {
            return new com.otaliastudios.cameraview.video.encoding.InputBuffer();
        }
    }

    public InputBufferPool() {
        super(Integer.MAX_VALUE, new com.otaliastudios.cameraview.video.encoding.InputBufferPool.AnonymousClass1());
    }
}
