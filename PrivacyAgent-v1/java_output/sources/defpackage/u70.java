package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class u70 implements android.content.DialogInterface.OnKeyListener {
    public final /* synthetic */ com.moji.earthquake.ui.EarthquakeDemonstrationActivity n;

    public /* synthetic */ u70(com.moji.earthquake.ui.EarthquakeDemonstrationActivity earthquakeDemonstrationActivity) {
        this.n = earthquakeDemonstrationActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
        return com.moji.earthquake.ui.EarthquakeDemonstrationActivity.b(this.n, dialogInterface, i, keyEvent);
    }
}
