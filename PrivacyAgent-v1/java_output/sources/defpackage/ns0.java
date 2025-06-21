package defpackage;

/* loaded from: classes20.dex */
public final /* synthetic */ class ns0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ moji.com.mjwallet.InputSmsCodeFragment n;

    public /* synthetic */ ns0(moji.com.mjwallet.InputSmsCodeFragment inputSmsCodeFragment) {
        this.n = inputSmsCodeFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        moji.com.mjwallet.InputSmsCodeFragment.g(this.n, (moji.com.mjwallet.CheckCodeResult) obj);
    }
}
