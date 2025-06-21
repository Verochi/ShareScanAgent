package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class sn2 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ android.graphics.Bitmap a;
    public final /* synthetic */ java.util.List b;
    public final /* synthetic */ com.moji.snow.SnowRecordActivity c;

    public /* synthetic */ sn2(android.graphics.Bitmap bitmap, java.util.List list, com.moji.snow.SnowRecordActivity snowRecordActivity) {
        this.a = bitmap;
        this.b = list;
        this.c = snowRecordActivity;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.snow.SnowRecordActivity.c(this.a, this.b, this.c, observableEmitter);
    }
}
