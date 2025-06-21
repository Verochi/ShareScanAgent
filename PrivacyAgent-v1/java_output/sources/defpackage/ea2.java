package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class ea2 implements com.google.android.exoplayer2.trackselection.TrackSelectionUtil.AdaptiveTrackSelectionFactory {
    public final /* synthetic */ com.google.android.exoplayer2.trackselection.RandomTrackSelection.Factory a;

    public /* synthetic */ ea2(com.google.android.exoplayer2.trackselection.RandomTrackSelection.Factory factory) {
        this.a = factory;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelectionUtil.AdaptiveTrackSelectionFactory
    public final com.google.android.exoplayer2.trackselection.TrackSelection createAdaptiveTrackSelection(com.google.android.exoplayer2.trackselection.TrackSelection.Definition definition) {
        com.google.android.exoplayer2.trackselection.TrackSelection b;
        b = this.a.b(definition);
        return b;
    }
}
