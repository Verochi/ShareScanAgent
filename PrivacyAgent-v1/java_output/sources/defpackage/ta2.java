package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class ta2 implements android.content.DialogInterface.OnCancelListener {
    public final /* synthetic */ com.moji.shorttime.ui.record.RecordVideoShareDialog n;

    public /* synthetic */ ta2(com.moji.shorttime.ui.record.RecordVideoShareDialog recordVideoShareDialog) {
        this.n = recordVideoShareDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(android.content.DialogInterface dialogInterface) {
        com.moji.shorttime.ui.record.RecordVideoShareDialog.c(this.n, dialogInterface);
    }
}
