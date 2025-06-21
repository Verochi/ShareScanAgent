package com.google.android.exoplayer2.extractor.flv;

/* loaded from: classes22.dex */
abstract class TagPayloadReader {
    public final com.google.android.exoplayer2.extractor.TrackOutput a;

    public static final class UnsupportedFormatException extends com.google.android.exoplayer2.ParserException {
        public UnsupportedFormatException(java.lang.String str) {
            super(str);
        }
    }

    public TagPayloadReader(com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
        this.a = trackOutput;
    }

    public final boolean a(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j) throws com.google.android.exoplayer2.ParserException {
        return b(parsableByteArray) && c(parsableByteArray, j);
    }

    public abstract boolean b(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException;

    public abstract boolean c(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j) throws com.google.android.exoplayer2.ParserException;
}
