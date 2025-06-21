package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class xa2 implements android.content.DialogInterface.OnDismissListener {
    public final /* synthetic */ com.moji.shorttime.ui.record.RecordVideoShareDialog n;

    public /* synthetic */ xa2(com.moji.shorttime.ui.record.RecordVideoShareDialog recordVideoShareDialog) {
        this.n = recordVideoShareDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(android.content.DialogInterface dialogInterface) {
        com.moji.shorttime.ui.record.RecordVideoShareDialog.k(this.n, dialogInterface);
    }
}
