package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes22.dex */
interface OggSeeker {
    @androidx.annotation.Nullable
    com.google.android.exoplayer2.extractor.SeekMap a();

    void b(long j);

    long read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException;
}
