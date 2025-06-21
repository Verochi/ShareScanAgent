package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class gl2 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.ski.SkiActivity a;
    public final /* synthetic */ android.graphics.Bitmap b;
    public final /* synthetic */ java.util.ArrayList c;

    public /* synthetic */ gl2(com.moji.ski.SkiActivity skiActivity, android.graphics.Bitmap bitmap, java.util.ArrayList arrayList) {
        this.a = skiActivity;
        this.b = bitmap;
        this.c = arrayList;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.ski.SkiActivity.f(this.a, this.b, this.c, observableEmitter);
    }
}
