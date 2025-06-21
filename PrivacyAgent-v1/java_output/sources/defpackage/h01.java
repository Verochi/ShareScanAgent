package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class h01 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ java.util.ArrayList a;
    public final /* synthetic */ com.moji.share.activity.LongImageActivity b;
    public final /* synthetic */ com.moji.share.entity.ShareContentConfig c;

    public /* synthetic */ h01(java.util.ArrayList arrayList, com.moji.share.activity.LongImageActivity longImageActivity, com.moji.share.entity.ShareContentConfig shareContentConfig) {
        this.a = arrayList;
        this.b = longImageActivity;
        this.c = shareContentConfig;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.share.activity.LongImageActivity.initData.2.b(this.a, this.b, this.c, observableEmitter);
    }
}
