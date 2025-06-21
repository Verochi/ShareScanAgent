package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes22.dex */
public interface MediaChunkIterator {
    public static final com.google.android.exoplayer2.source.chunk.MediaChunkIterator EMPTY = new com.google.android.exoplayer2.source.chunk.MediaChunkIterator.AnonymousClass1();

    /* renamed from: com.google.android.exoplayer2.source.chunk.MediaChunkIterator$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.android.exoplayer2.source.chunk.MediaChunkIterator {
        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            throw new java.util.NoSuchElementException();
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            throw new java.util.NoSuchElementException();
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public com.google.android.exoplayer2.upstream.DataSpec getDataSpec() {
            throw new java.util.NoSuchElementException();
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public boolean isEnded() {
            return true;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public boolean next() {
            return false;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public void reset() {
        }
    }

    long getChunkEndTimeUs();

    long getChunkStartTimeUs();

    com.google.android.exoplayer2.upstream.DataSpec getDataSpec();

    boolean isEnded();

    boolean next();

    void reset();
}
