package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class k81 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.sakura.main.data.MainDataRepository a;

    public /* synthetic */ k81(com.moji.sakura.main.data.MainDataRepository mainDataRepository) {
        this.a = mainDataRepository;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.sakura.main.data.MainDataRepository.a(this.a, observableEmitter);
    }
}
