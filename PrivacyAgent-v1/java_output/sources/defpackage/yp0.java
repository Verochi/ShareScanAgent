package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class yp0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.appmarket.HuaWeiAppMarketDialogHelper n;
    public final /* synthetic */ android.content.Context t;
    public final /* synthetic */ com.moji.dialog.MJDialog u;

    public /* synthetic */ yp0(com.moji.mjweather.appmarket.HuaWeiAppMarketDialogHelper huaWeiAppMarketDialogHelper, android.content.Context context, com.moji.dialog.MJDialog mJDialog) {
        this.n = huaWeiAppMarketDialogHelper;
        this.t = context;
        this.u = mJDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.appmarket.HuaWeiAppMarketDialogHelper.e(this.n, this.t, this.u, view);
    }
}
