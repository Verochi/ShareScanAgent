package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class nn2 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.http.pb.SnowMapRequest a;

    public /* synthetic */ nn2(com.moji.http.pb.SnowMapRequest snowMapRequest) {
        this.a = snowMapRequest;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.snow.viewmodel.SnowPageViewModel.a(this.a, observableEmitter);
    }
}
