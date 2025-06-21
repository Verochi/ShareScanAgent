package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class qa2 implements io.reactivex.ObservableOnSubscribe {
    public final /* synthetic */ com.moji.shorttime.ui.record.RecordVideoShareDialog a;
    public final /* synthetic */ android.content.Context b;
    public final /* synthetic */ java.lang.String c;

    public /* synthetic */ qa2(com.moji.shorttime.ui.record.RecordVideoShareDialog recordVideoShareDialog, android.content.Context context, java.lang.String str) {
        this.a = recordVideoShareDialog;
        this.b = context;
        this.c = str;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(io.reactivex.ObservableEmitter observableEmitter) {
        com.moji.shorttime.ui.record.RecordVideoShareDialog.l(this.a, this.b, this.c, observableEmitter);
    }
}
