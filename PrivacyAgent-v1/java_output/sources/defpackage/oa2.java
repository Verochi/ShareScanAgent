package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class oa2 implements android.content.DialogInterface.OnCancelListener {
    public final /* synthetic */ com.moji.shorttime.ui.record.RecordVideoLoadingDialog n;

    public /* synthetic */ oa2(com.moji.shorttime.ui.record.RecordVideoLoadingDialog recordVideoLoadingDialog) {
        this.n = recordVideoLoadingDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(android.content.DialogInterface dialogInterface) {
        com.moji.shorttime.ui.record.RecordVideoLoadingDialog.c(this.n, dialogInterface);
    }
}
