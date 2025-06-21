package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class xl0 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.share.fragment.GraphShareFragment a;

    public /* synthetic */ xl0(com.moji.share.fragment.GraphShareFragment graphShareFragment) {
        this.a = graphShareFragment;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.share.fragment.GraphShareFragment.e(this.a, observableEmitter);
    }
}
