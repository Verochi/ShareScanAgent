package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class z91 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ java.util.ArrayList a;
    public final /* synthetic */ com.moji.share.activity.MainShareActivity b;
    public final /* synthetic */ com.moji.share.entity.ShareContentConfig c;

    public /* synthetic */ z91(java.util.ArrayList arrayList, com.moji.share.activity.MainShareActivity mainShareActivity, com.moji.share.entity.ShareContentConfig shareContentConfig) {
        this.a = arrayList;
        this.b = mainShareActivity;
        this.c = shareContentConfig;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.share.activity.MainShareActivity.initData.1.b(this.a, this.b, this.c, observableEmitter);
    }
}
