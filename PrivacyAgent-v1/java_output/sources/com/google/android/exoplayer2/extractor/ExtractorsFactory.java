package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public interface ExtractorsFactory {
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory EMPTY = new defpackage.qa0();

    com.google.android.exoplayer2.extractor.Extractor[] createExtractors();

    com.google.android.exoplayer2.extractor.Extractor[] createExtractors(android.net.Uri uri, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map);
}
