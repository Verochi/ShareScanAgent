package defpackage;

/* loaded from: classes20.dex */
public final /* synthetic */ class yd3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ moji.com.mjwallet.main.WalletMainActivity n;

    public /* synthetic */ yd3(moji.com.mjwallet.main.WalletMainActivity walletMainActivity) {
        this.n = walletMainActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        moji.com.mjwallet.main.WalletMainActivity.j(this.n, (java.util.List) obj);
    }
}
