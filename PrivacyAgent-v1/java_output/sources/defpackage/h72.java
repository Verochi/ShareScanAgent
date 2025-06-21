package defpackage;

/* loaded from: classes13.dex */
public final /* synthetic */ class h72 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.http.pb.RapeFlowersMapRequest a;

    public /* synthetic */ h72(com.moji.http.pb.RapeFlowersMapRequest rapeFlowersMapRequest) {
        this.a = rapeFlowersMapRequest;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.rapeflowers.RFlowersViewModel.c(this.a, observableEmitter);
    }
}
