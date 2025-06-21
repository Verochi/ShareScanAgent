package com.otaliastudios.cameraview.video.encoding;

/* loaded from: classes19.dex */
class AudioNoise {
    public static final java.util.Random b = new java.util.Random();
    public final java.nio.ByteBuffer a;

    public AudioNoise(@androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.AudioConfig audioConfig) {
        audioConfig.getClass();
        this.a = java.nio.ByteBuffer.allocateDirect(audioConfig.f() * 1).order(java.nio.ByteOrder.nativeOrder());
        double f = 3.141592653589793d / (audioConfig.f() / 2.0d);
        double d = 0.0d;
        while (this.a.hasRemaining()) {
            d += 1.0d;
            short sin = (short) (java.lang.Math.sin(d * f) * 10.0d);
            this.a.put((byte) sin);
            this.a.put((byte) (sin >> 8));
        }
        this.a.rewind();
    }

    public void a(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer) {
        this.a.clear();
        if (this.a.capacity() == byteBuffer.remaining()) {
            this.a.position(0);
        } else {
            java.nio.ByteBuffer byteBuffer2 = this.a;
            byteBuffer2.position(b.nextInt(byteBuffer2.capacity() - byteBuffer.remaining()));
        }
        java.nio.ByteBuffer byteBuffer3 = this.a;
        byteBuffer3.limit(byteBuffer3.position() + byteBuffer.remaining());
        byteBuffer.put(this.a);
    }
}
