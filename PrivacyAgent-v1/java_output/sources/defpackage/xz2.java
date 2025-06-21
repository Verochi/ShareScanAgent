package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class xz2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.TableScreenFragment n;
    public final /* synthetic */ com.moji.dialog.MJDialog t;

    public /* synthetic */ xz2(com.moji.mjweather.TableScreenFragment tableScreenFragment, com.moji.dialog.MJDialog mJDialog) {
        this.n = tableScreenFragment;
        this.t = mJDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.TableScreenFragment.f(this.n, this.t, view);
    }
}
