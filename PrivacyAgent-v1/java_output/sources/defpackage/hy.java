package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class hy implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.share.fragment.DaysShareFragment a;

    public /* synthetic */ hy(com.moji.share.fragment.DaysShareFragment daysShareFragment) {
        this.a = daysShareFragment;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.share.fragment.DaysShareFragment.f(this.a, observableEmitter);
    }
}
