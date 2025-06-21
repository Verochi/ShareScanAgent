package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class in2 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.snow.SnowMoreActivity a;
    public final /* synthetic */ android.graphics.Bitmap b;
    public final /* synthetic */ android.graphics.Bitmap c;

    public /* synthetic */ in2(com.moji.snow.SnowMoreActivity snowMoreActivity, android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2) {
        this.a = snowMoreActivity;
        this.b = bitmap;
        this.c = bitmap2;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.snow.SnowMoreActivity.c(this.a, this.b, this.c, observableEmitter);
    }
}
