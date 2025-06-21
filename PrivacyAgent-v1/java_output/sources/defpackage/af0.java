package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class af0 implements com.google.android.exoplayer2.trackselection.TrackSelectionUtil.AdaptiveTrackSelectionFactory {
    public final /* synthetic */ com.google.android.exoplayer2.trackselection.FixedTrackSelection.Factory a;

    public /* synthetic */ af0(com.google.android.exoplayer2.trackselection.FixedTrackSelection.Factory factory) {
        this.a = factory;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelectionUtil.AdaptiveTrackSelectionFactory
    public final com.google.android.exoplayer2.trackselection.TrackSelection createAdaptiveTrackSelection(com.google.android.exoplayer2.trackselection.TrackSelection.Definition definition) {
        com.google.android.exoplayer2.trackselection.TrackSelection b;
        b = this.a.b(definition);
        return b;
    }
}
