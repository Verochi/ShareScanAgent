package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes22.dex */
public final class ChunkHolder {

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.chunk.Chunk chunk;
    public boolean endOfStream;

    public void clear() {
        this.chunk = null;
        this.endOfStream = false;
    }
}
