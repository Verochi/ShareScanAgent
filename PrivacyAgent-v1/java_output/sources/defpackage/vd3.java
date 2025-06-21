package defpackage;

/* loaded from: classes20.dex */
public final /* synthetic */ class vd3 implements android.view.View.OnClickListener {
    public final /* synthetic */ moji.com.mjwallet.WalletAccountManageActivity n;
    public final /* synthetic */ moji.com.mjwallet.WalletAccountViewModel t;
    public final /* synthetic */ com.moji.http.pcd.AccountInfo u;

    public /* synthetic */ vd3(moji.com.mjwallet.WalletAccountManageActivity walletAccountManageActivity, moji.com.mjwallet.WalletAccountViewModel walletAccountViewModel, com.moji.http.pcd.AccountInfo accountInfo) {
        this.n = walletAccountManageActivity;
        this.t = walletAccountViewModel;
        this.u = accountInfo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        moji.com.mjwallet.WalletAccountManageActivity.e(this.n, this.t, this.u, view);
    }
}
