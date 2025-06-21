package com.google.android.exoplayer2.mediacodec;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes22.dex */
final class MediaCodecAsyncCallback extends android.media.MediaCodec.Callback {
    public final com.google.android.exoplayer2.util.IntArrayQueue a = new com.google.android.exoplayer2.util.IntArrayQueue();
    public final com.google.android.exoplayer2.util.IntArrayQueue b = new com.google.android.exoplayer2.util.IntArrayQueue();
    public final java.util.ArrayDeque<android.media.MediaCodec.BufferInfo> c = new java.util.ArrayDeque<>();
    public final java.util.ArrayDeque<android.media.MediaFormat> d = new java.util.ArrayDeque<>();

    @androidx.annotation.Nullable
    public android.media.MediaFormat e;

    @androidx.annotation.Nullable
    public android.media.MediaFormat f;

    @androidx.annotation.Nullable
    public java.lang.IllegalStateException g;

    public final void a(android.media.MediaFormat mediaFormat) {
        this.b.add(-2);
        this.d.add(mediaFormat);
    }

    public int b() {
        if (this.a.isEmpty()) {
            return -1;
        }
        return this.a.remove();
    }

    public int c(android.media.MediaCodec.BufferInfo bufferInfo) {
        if (this.b.isEmpty()) {
            return -1;
        }
        int remove = this.b.remove();
        if (remove >= 0) {
            android.media.MediaCodec.BufferInfo remove2 = this.c.remove();
            bufferInfo.set(remove2.offset, remove2.size, remove2.presentationTimeUs, remove2.flags);
        } else if (remove == -2) {
            this.e = this.d.remove();
        }
        return remove;
    }

    public void d() {
        this.f = this.d.isEmpty() ? null : this.d.getLast();
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.g = null;
    }

    public android.media.MediaFormat e() throws java.lang.IllegalStateException {
        android.media.MediaFormat mediaFormat = this.e;
        if (mediaFormat != null) {
            return mediaFormat;
        }
        throw new java.lang.IllegalStateException();
    }

    public void f() throws java.lang.IllegalStateException {
        java.lang.IllegalStateException illegalStateException = this.g;
        this.g = null;
        if (illegalStateException != null) {
            throw illegalStateException;
        }
    }

    @androidx.annotation.VisibleForTesting
    public void g(java.lang.IllegalStateException illegalStateException) {
        this.g = illegalStateException;
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(android.media.MediaCodec mediaCodec, android.media.MediaCodec.CodecException codecException) {
        g(codecException);
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(android.media.MediaCodec mediaCodec, int i) {
        this.a.add(i);
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(android.media.MediaCodec mediaCodec, int i, android.media.MediaCodec.BufferInfo bufferInfo) {
        android.media.MediaFormat mediaFormat = this.f;
        if (mediaFormat != null) {
            a(mediaFormat);
            this.f = null;
        }
        this.b.add(i);
        this.c.add(bufferInfo);
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(android.media.MediaCodec mediaCodec, android.media.MediaFormat mediaFormat) {
        a(mediaFormat);
        this.f = null;
    }
}
