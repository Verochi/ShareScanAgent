package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class bz0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.dialog.MJDialog n;
    public final /* synthetic */ android.widget.TextView t;
    public final /* synthetic */ android.view.View u;
    public final /* synthetic */ com.moji.mjtravel.local.LocalTripFragment v;

    public /* synthetic */ bz0(com.moji.dialog.MJDialog mJDialog, android.widget.TextView textView, android.view.View view, com.moji.mjtravel.local.LocalTripFragment localTripFragment) {
        this.n = mJDialog;
        this.t = textView;
        this.u = view;
        this.v = localTripFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjtravel.local.LocalTripFragment.a(this.n, this.t, this.u, this.v, view);
    }
}
