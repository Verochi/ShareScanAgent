package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class xa3 implements android.content.DialogInterface.OnDismissListener {
    public final /* synthetic */ com.moji.shorttime.utils.AutoSwitchTo48HourUtil n;
    public final /* synthetic */ com.moji.shorttime.ui.player.MapRadarPlayBar t;

    public /* synthetic */ xa3(com.moji.shorttime.utils.AutoSwitchTo48HourUtil autoSwitchTo48HourUtil, com.moji.shorttime.ui.player.MapRadarPlayBar mapRadarPlayBar) {
        this.n = autoSwitchTo48HourUtil;
        this.t = mapRadarPlayBar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(android.content.DialogInterface dialogInterface) {
        com.moji.shorttime.utils.VideoRecordUtil.c(this.n, this.t, dialogInterface);
    }
}
