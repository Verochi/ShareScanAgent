package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class z7 implements com.google.android.exoplayer2.extractor.ExtractorsFactory {
    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public final com.google.android.exoplayer2.extractor.Extractor[] createExtractors() {
        com.google.android.exoplayer2.extractor.Extractor[] e;
        e = com.google.android.exoplayer2.extractor.ts.AdtsExtractor.e();
        return e;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] createExtractors(android.net.Uri uri, java.util.Map map) {
        return defpackage.ra0.a(this, uri, map);
    }
}
