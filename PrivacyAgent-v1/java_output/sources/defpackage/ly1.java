package defpackage;

/* loaded from: classes10.dex */
public final /* synthetic */ class ly1 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.http.pb.PeachFlowersMapRequest a;

    public /* synthetic */ ly1(com.moji.http.pb.PeachFlowersMapRequest peachFlowersMapRequest) {
        this.a = peachFlowersMapRequest;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.peachflowers.PeachFlowersViewModel.a(this.a, observableEmitter);
    }
}
