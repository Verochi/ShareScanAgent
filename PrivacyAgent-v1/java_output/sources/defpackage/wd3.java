package defpackage;

/* loaded from: classes20.dex */
public final /* synthetic */ class wd3 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ moji.com.mjwallet.WalletAccountManageActivity a;
    public final /* synthetic */ moji.com.mjwallet.WalletAccountViewModel b;
    public final /* synthetic */ com.moji.http.pcd.AccountInfo c;

    public /* synthetic */ wd3(moji.com.mjwallet.WalletAccountManageActivity walletAccountManageActivity, moji.com.mjwallet.WalletAccountViewModel walletAccountViewModel, com.moji.http.pcd.AccountInfo accountInfo) {
        this.a = walletAccountManageActivity;
        this.b = walletAccountViewModel;
        this.c = accountInfo;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        moji.com.mjwallet.WalletAccountManageActivity.h(this.a, this.b, this.c, mJDialog, eTypeAction);
    }
}
