package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class dw2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.tabmember.TabMemberFragment n;
    public final /* synthetic */ com.moji.popupwindow.CustomPopWindow t;

    public /* synthetic */ dw2(com.moji.mjweather.tabmember.TabMemberFragment tabMemberFragment, com.moji.popupwindow.CustomPopWindow customPopWindow) {
        this.n = tabMemberFragment;
        this.t = customPopWindow;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.tabmember.TabMemberFragment.e(this.n, this.t, view);
    }
}
