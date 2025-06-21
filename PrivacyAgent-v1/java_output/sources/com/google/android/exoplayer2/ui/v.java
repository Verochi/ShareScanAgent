package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public final /* synthetic */ class v implements java.util.Comparator {
    public final /* synthetic */ java.util.Comparator n;

    public /* synthetic */ v(java.util.Comparator comparator) {
        this.n = comparator;
    }

    @Override // java.util.Comparator
    public final int compare(java.lang.Object obj, java.lang.Object obj2) {
        int e;
        e = com.google.android.exoplayer2.ui.TrackSelectionView.e(this.n, (com.google.android.exoplayer2.ui.TrackSelectionView.TrackInfo) obj, (com.google.android.exoplayer2.ui.TrackSelectionView.TrackInfo) obj2);
        return e;
    }
}
