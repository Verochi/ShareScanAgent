package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class do1 implements com.google.android.exoplayer2.extractor.ExtractorsFactory {
    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public final com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
        com.google.android.exoplayer2.extractor.Extractor[] j;
        j = com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.j();
        return j;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] createExtractors(android.net.Uri uri, java.util.Map map) {
        return defpackage.ra0.a(this, uri, map);
    }
}
