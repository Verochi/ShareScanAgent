package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public final /* synthetic */ class c implements android.view.View.OnClickListener {
    public final /* synthetic */ com.google.android.exoplayer2.ui.StyledPlayerControlView.AudioTrackSelectionAdapter n;

    public /* synthetic */ c(com.google.android.exoplayer2.ui.StyledPlayerControlView.AudioTrackSelectionAdapter audioTrackSelectionAdapter) {
        this.n = audioTrackSelectionAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        this.n.i(view);
    }
}
