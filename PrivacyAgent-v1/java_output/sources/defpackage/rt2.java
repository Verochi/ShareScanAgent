package defpackage;

/* loaded from: classes16.dex */
public final /* synthetic */ class rt2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.sunglow.SunglowMainActivity n;
    public final /* synthetic */ com.moji.dialog.MJDialog t;

    public /* synthetic */ rt2(com.moji.sunglow.SunglowMainActivity sunglowMainActivity, com.moji.dialog.MJDialog mJDialog) {
        this.n = sunglowMainActivity;
        this.t = mJDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.sunglow.SunglowMainActivity.b(this.n, this.t, view);
    }
}
