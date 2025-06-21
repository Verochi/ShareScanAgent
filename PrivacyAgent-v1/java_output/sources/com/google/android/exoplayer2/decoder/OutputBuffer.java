package com.google.android.exoplayer2.decoder;

/* loaded from: classes22.dex */
public abstract class OutputBuffer extends com.google.android.exoplayer2.decoder.Buffer {
    public int skippedOutputBufferCount;
    public long timeUs;

    public interface Owner<S extends com.google.android.exoplayer2.decoder.OutputBuffer> {
        void releaseOutputBuffer(S s2);
    }

    public abstract void release();
}
