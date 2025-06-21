package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class bf0 implements com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter {
    public final /* synthetic */ com.google.android.exoplayer2.extractor.FlacStreamMetadata a;

    public /* synthetic */ bf0(com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata) {
        this.a = flacStreamMetadata;
    }

    @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter
    public final long timeUsToTargetTime(long j) {
        return this.a.getSampleNumber(j);
    }
}
