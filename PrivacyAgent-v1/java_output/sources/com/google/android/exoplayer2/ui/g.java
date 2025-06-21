package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public final /* synthetic */ class g implements android.view.View.OnClickListener {
    public final /* synthetic */ com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter n;
    public final /* synthetic */ com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackInfo t;

    public /* synthetic */ g(com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter trackSelectionAdapter, com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackInfo trackInfo) {
        this.n = trackSelectionAdapter;
        this.t = trackInfo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        this.n.c(this.t, view);
    }
}
