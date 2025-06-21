package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class r33 implements android.content.DialogInterface.OnClickListener {
    public final /* synthetic */ com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder n;
    public final /* synthetic */ com.google.android.exoplayer2.ui.TrackSelectionView t;

    public /* synthetic */ r33(com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder trackSelectionDialogBuilder, com.google.android.exoplayer2.ui.TrackSelectionView trackSelectionView) {
        this.n = trackSelectionDialogBuilder;
        this.t = trackSelectionView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.n.f(this.t, dialogInterface, i);
    }
}
