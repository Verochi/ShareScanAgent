package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class wa3 implements android.content.DialogInterface.OnDismissListener {
    public final /* synthetic */ com.moji.shorttime.utils.AutoSwitchTo48HourUtil n;

    public /* synthetic */ wa3(com.moji.shorttime.utils.AutoSwitchTo48HourUtil autoSwitchTo48HourUtil) {
        this.n = autoSwitchTo48HourUtil;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(android.content.DialogInterface dialogInterface) {
        com.moji.shorttime.utils.VideoRecordUtil.a(this.n, dialogInterface);
    }
}
