package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public final class DummyTrackOutput implements com.google.android.exoplayer2.extractor.TrackOutput {
    public final byte[] a = new byte[4096];

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void format(com.google.android.exoplayer2.Format format) {
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public /* synthetic */ int sampleData(com.google.android.exoplayer2.upstream.DataReader dataReader, int i, boolean z) {
        return defpackage.p33.a(this, dataReader, i, z);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public int sampleData(com.google.android.exoplayer2.upstream.DataReader dataReader, int i, boolean z, int i2) throws java.io.IOException {
        int read = dataReader.read(this.a, 0, java.lang.Math.min(this.a.length, i));
        if (read != -1) {
            return read;
        }
        if (z) {
            return -1;
        }
        throw new java.io.EOFException();
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public /* synthetic */ void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        defpackage.p33.b(this, parsableByteArray, i);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2) {
        parsableByteArray.skipBytes(i);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long j, int i, int i2, int i3, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData) {
    }
}
