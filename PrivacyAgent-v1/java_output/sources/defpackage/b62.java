package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class b62 implements com.google.android.exoplayer2.upstream.cache.CacheWriter.ProgressListener {
    public final /* synthetic */ com.google.android.exoplayer2.offline.ProgressiveDownloader a;

    public /* synthetic */ b62(com.google.android.exoplayer2.offline.ProgressiveDownloader progressiveDownloader) {
        this.a = progressiveDownloader;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheWriter.ProgressListener
    public final void onProgress(long j, long j2, long j3) {
        this.a.b(j, j2, j3);
    }
}
