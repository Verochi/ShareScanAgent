package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class z40 implements com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener {
    @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public final void onTrackSelectionsInvalidated() {
        com.google.android.exoplayer2.offline.DownloadHelper.n();
    }
}
