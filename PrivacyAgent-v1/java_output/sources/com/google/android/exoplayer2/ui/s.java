package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public final /* synthetic */ class s implements android.view.View.OnLayoutChangeListener {
    public final /* synthetic */ com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager n;

    public /* synthetic */ s(com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        this.n = styledPlayerControlViewLayoutManager;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.n.P(view, i, i2, i3, i4, i5, i6, i7, i8);
    }
}
