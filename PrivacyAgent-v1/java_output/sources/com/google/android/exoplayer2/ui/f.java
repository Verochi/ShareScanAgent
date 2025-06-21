package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public final /* synthetic */ class f implements android.view.View.OnClickListener {
    public final /* synthetic */ com.google.android.exoplayer2.ui.StyledPlayerControlView.TextTrackSelectionAdapter n;

    public /* synthetic */ f(com.google.android.exoplayer2.ui.StyledPlayerControlView.TextTrackSelectionAdapter textTrackSelectionAdapter) {
        this.n = textTrackSelectionAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        this.n.i(view);
    }
}
