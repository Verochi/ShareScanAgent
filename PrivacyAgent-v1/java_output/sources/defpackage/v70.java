package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class v70 implements android.content.DialogInterface.OnDismissListener {
    public final /* synthetic */ com.moji.earthquake.ui.EarthquakeDemonstrationActivity n;

    public /* synthetic */ v70(com.moji.earthquake.ui.EarthquakeDemonstrationActivity earthquakeDemonstrationActivity) {
        this.n = earthquakeDemonstrationActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(android.content.DialogInterface dialogInterface) {
        com.moji.earthquake.ui.EarthquakeDemonstrationActivity.c(this.n, dialogInterface);
    }
}
