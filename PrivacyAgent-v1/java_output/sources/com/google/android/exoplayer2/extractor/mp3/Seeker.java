package com.google.android.exoplayer2.extractor.mp3;

/* loaded from: classes22.dex */
interface Seeker extends com.google.android.exoplayer2.extractor.SeekMap {

    public static class UnseekableSeeker extends com.google.android.exoplayer2.extractor.SeekMap.Unseekable implements com.google.android.exoplayer2.extractor.mp3.Seeker {
        public UnseekableSeeker() {
            super(-9223372036854775807L);
        }

        @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
        public long getDataEndPosition() {
            return -1L;
        }

        @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
        public long getTimeUs(long j) {
            return 0L;
        }
    }

    long getDataEndPosition();

    long getTimeUs(long j);
}
