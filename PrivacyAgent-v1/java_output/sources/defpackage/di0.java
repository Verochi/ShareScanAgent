package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class di0 implements com.google.common.base.Function {
    public final /* synthetic */ com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor n;

    public /* synthetic */ di0(com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor fragmentedMp4Extractor) {
        this.n = fragmentedMp4Extractor;
    }

    @Override // com.google.common.base.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        return this.n.modifyTrack((com.google.android.exoplayer2.extractor.mp4.Track) obj);
    }
}
