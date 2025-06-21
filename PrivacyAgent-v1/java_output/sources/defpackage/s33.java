package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class s33 implements com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder.DialogCallback {
    public final /* synthetic */ com.google.android.exoplayer2.trackselection.DefaultTrackSelector a;
    public final /* synthetic */ com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters b;
    public final /* synthetic */ int c;
    public final /* synthetic */ com.google.android.exoplayer2.source.TrackGroupArray d;

    public /* synthetic */ s33(com.google.android.exoplayer2.trackselection.DefaultTrackSelector defaultTrackSelector, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, int i, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray) {
        this.a = defaultTrackSelector;
        this.b = parameters;
        this.c = i;
        this.d = trackGroupArray;
    }

    @Override // com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder.DialogCallback
    public final void onTracksSelected(boolean z, java.util.List list) {
        com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder.e(this.a, this.b, this.c, this.d, z, list);
    }
}
