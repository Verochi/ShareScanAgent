package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class uk2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.earlywarning.SingleWarningFragment n;

    public /* synthetic */ uk2(com.moji.earlywarning.SingleWarningFragment singleWarningFragment) {
        this.n = singleWarningFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.earlywarning.SingleWarningFragment.r(this.n, (com.moji.earlywarning.WarningViewModel.PicturePostingListWrapper) obj);
    }
}
