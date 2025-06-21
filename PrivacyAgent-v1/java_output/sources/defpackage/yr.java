package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class yr implements com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller {
    public final /* synthetic */ com.google.android.exoplayer2.source.CompositeMediaSource n;
    public final /* synthetic */ java.lang.Object t;

    public /* synthetic */ yr(com.google.android.exoplayer2.source.CompositeMediaSource compositeMediaSource, java.lang.Object obj) {
        this.n = compositeMediaSource;
        this.t = obj;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
    public final void onSourceInfoRefreshed(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline) {
        this.n.b(this.t, mediaSource, timeline);
    }
}
