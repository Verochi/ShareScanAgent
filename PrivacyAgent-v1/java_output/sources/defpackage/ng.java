package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ng implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.setting.fragment.BaseAccountFragment n;
    public final /* synthetic */ android.widget.TextView t;
    public final /* synthetic */ com.moji.dialog.MJDialog u;
    public final /* synthetic */ android.widget.TextView v;

    public /* synthetic */ ng(com.moji.mjweather.setting.fragment.BaseAccountFragment baseAccountFragment, android.widget.TextView textView, com.moji.dialog.MJDialog mJDialog, android.widget.TextView textView2) {
        this.n = baseAccountFragment;
        this.t = textView;
        this.u = mJDialog;
        this.v = textView2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.setting.fragment.BaseAccountFragment.e(this.n, this.t, this.u, this.v, view);
    }
}
