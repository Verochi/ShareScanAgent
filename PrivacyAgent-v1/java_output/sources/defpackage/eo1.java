package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class eo1 implements com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate {
    @Override // com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate
    public final boolean evaluate(int i, int i2, int i3, int i4, int i5) {
        boolean k;
        k = com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.k(i, i2, i3, i4, i5);
        return k;
    }
}
