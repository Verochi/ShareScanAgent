package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class az0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.dialog.MJDialog n;
    public final /* synthetic */ com.moji.mjtravel.local.LocalTripFragment t;

    public /* synthetic */ az0(com.moji.dialog.MJDialog mJDialog, com.moji.mjtravel.local.LocalTripFragment localTripFragment) {
        this.n = mJDialog;
        this.t = localTripFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjtravel.local.LocalTripFragment.d(this.n, this.t, view);
    }
}
