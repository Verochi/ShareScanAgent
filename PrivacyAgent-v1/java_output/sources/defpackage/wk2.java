package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class wk2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.earlywarning.SingleWarningFragment n;

    public /* synthetic */ wk2(com.moji.earlywarning.SingleWarningFragment singleWarningFragment) {
        this.n = singleWarningFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.earlywarning.SingleWarningFragment.c(this.n, (java.lang.String) obj);
    }
}
