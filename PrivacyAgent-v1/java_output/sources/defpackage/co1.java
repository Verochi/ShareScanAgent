package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class co1 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.share.fragment.MottoShareFragment n;

    public /* synthetic */ co1(com.moji.share.fragment.MottoShareFragment mottoShareFragment) {
        this.n = mottoShareFragment;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.share.fragment.MottoShareFragment.f(this.n, (com.moji.share.fragment.ShareBaseFragment.ShareImg) obj);
    }
}
