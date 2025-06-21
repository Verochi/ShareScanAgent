package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class wl2 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.http.pb.SkiMapRequest a;

    public /* synthetic */ wl2(com.moji.http.pb.SkiMapRequest skiMapRequest) {
        this.a = skiMapRequest;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.ski.viewmodel.SkiViewModel.b(this.a, observableEmitter);
    }
}
