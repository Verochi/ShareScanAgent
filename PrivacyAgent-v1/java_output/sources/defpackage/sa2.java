package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class sa2 implements android.media.MediaScannerConnection.OnScanCompletedListener {
    public final /* synthetic */ com.moji.shorttime.ui.record.RecordVideoShareDialog a;
    public final /* synthetic */ android.content.Context b;
    public final /* synthetic */ java.lang.String c;
    public final /* synthetic */ io.reactivex.ObservableEmitter d;

    public /* synthetic */ sa2(com.moji.shorttime.ui.record.RecordVideoShareDialog recordVideoShareDialog, android.content.Context context, java.lang.String str, io.reactivex.ObservableEmitter observableEmitter) {
        this.a = recordVideoShareDialog;
        this.b = context;
        this.c = str;
        this.d = observableEmitter;
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public final void onScanCompleted(java.lang.String str, android.net.Uri uri) {
        com.moji.shorttime.ui.record.RecordVideoShareDialog.f(this.a, this.b, this.c, this.d, str, uri);
    }
}
