package com.google.android.exoplayer2.extractor.mkv;

/* loaded from: classes22.dex */
interface EbmlReader {
    void a(com.google.android.exoplayer2.extractor.mkv.EbmlProcessor ebmlProcessor);

    boolean read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException;

    void reset();
}
