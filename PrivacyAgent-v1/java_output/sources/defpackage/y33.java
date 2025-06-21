package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class y33 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.mjweather.share.TravelTipsShareActivity a;

    public /* synthetic */ y33(com.moji.mjweather.share.TravelTipsShareActivity travelTipsShareActivity) {
        this.a = travelTipsShareActivity;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.mjweather.share.TravelTipsShareActivity.onCreate.2.a(this.a, observableEmitter);
    }
}
