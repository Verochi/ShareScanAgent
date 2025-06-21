package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class bh implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ moji.com.mjweatherservicebase.BaseHomePageActivity a;
    public final /* synthetic */ android.graphics.Bitmap b;
    public final /* synthetic */ java.util.ArrayList c;

    public /* synthetic */ bh(moji.com.mjweatherservicebase.BaseHomePageActivity baseHomePageActivity, android.graphics.Bitmap bitmap, java.util.ArrayList arrayList) {
        this.a = baseHomePageActivity;
        this.b = bitmap;
        this.c = arrayList;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        moji.com.mjweatherservicebase.BaseHomePageActivity.l(this.a, this.b, this.c, observableEmitter);
    }
}
