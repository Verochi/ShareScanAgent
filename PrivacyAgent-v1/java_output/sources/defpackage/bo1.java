package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class bo1 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.share.fragment.MottoShareFragment a;

    public /* synthetic */ bo1(com.moji.share.fragment.MottoShareFragment mottoShareFragment) {
        this.a = mottoShareFragment;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.share.fragment.MottoShareFragment.d(this.a, observableEmitter);
    }
}
