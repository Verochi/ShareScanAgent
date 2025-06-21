package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class kx2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.dialog.MJDialog n;
    public final /* synthetic */ com.moji.mjweather.TabNewLiveViewFragment t;

    public /* synthetic */ kx2(com.moji.dialog.MJDialog mJDialog, com.moji.mjweather.TabNewLiveViewFragment tabNewLiveViewFragment) {
        this.n = mJDialog;
        this.t = tabNewLiveViewFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.TabNewLiveViewFragment.e(this.n, this.t, view);
    }
}
