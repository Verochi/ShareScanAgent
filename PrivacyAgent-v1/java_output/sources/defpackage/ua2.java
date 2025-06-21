package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class ua2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.shorttime.ui.record.RecordVideoShareDialog n;
    public final /* synthetic */ android.content.Context t;
    public final /* synthetic */ java.lang.String u;

    public /* synthetic */ ua2(com.moji.shorttime.ui.record.RecordVideoShareDialog recordVideoShareDialog, android.content.Context context, java.lang.String str) {
        this.n = recordVideoShareDialog;
        this.t = context;
        this.u = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.record.RecordVideoShareDialog.a(this.n, this.t, this.u, view);
    }
}
