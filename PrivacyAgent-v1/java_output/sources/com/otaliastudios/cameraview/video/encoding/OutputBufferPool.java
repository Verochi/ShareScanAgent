package com.otaliastudios.cameraview.video.encoding;

@androidx.annotation.RequiresApi(18)
/* loaded from: classes19.dex */
class OutputBufferPool extends com.otaliastudios.cameraview.internal.Pool<com.otaliastudios.cameraview.video.encoding.OutputBuffer> {

    /* renamed from: com.otaliastudios.cameraview.video.encoding.OutputBufferPool$1, reason: invalid class name */
    public class AnonymousClass1 implements com.otaliastudios.cameraview.internal.Pool.Factory<com.otaliastudios.cameraview.video.encoding.OutputBuffer> {
        public final /* synthetic */ int a;

        public AnonymousClass1(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.internal.Pool.Factory
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.otaliastudios.cameraview.video.encoding.OutputBuffer create() {
            com.otaliastudios.cameraview.video.encoding.OutputBuffer outputBuffer = new com.otaliastudios.cameraview.video.encoding.OutputBuffer();
            outputBuffer.trackIndex = this.a;
            outputBuffer.info = new android.media.MediaCodec.BufferInfo();
            return outputBuffer;
        }
    }

    public OutputBufferPool(int i) {
        super(Integer.MAX_VALUE, new com.otaliastudios.cameraview.video.encoding.OutputBufferPool.AnonymousClass1(i));
    }
}
