package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class qu0 implements android.view.View.OnClickListener {
    public final /* synthetic */ cn.jzvd.JzvdStd n;
    public final /* synthetic */ android.widget.LinearLayout t;

    public /* synthetic */ qu0(cn.jzvd.JzvdStd jzvdStd, android.widget.LinearLayout linearLayout) {
        this.n = jzvdStd;
        this.t = linearLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        this.n.e(this.t, view);
    }
}
