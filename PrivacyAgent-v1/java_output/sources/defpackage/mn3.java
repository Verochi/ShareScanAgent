package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class mn3 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.zodiac.ZodiacActivity n;
    public final /* synthetic */ int t;
    public final /* synthetic */ int u;

    public /* synthetic */ mn3(com.moji.zodiac.ZodiacActivity zodiacActivity, int i, int i2) {
        this.n = zodiacActivity;
        this.t = i;
        this.u = i2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.zodiac.ZodiacActivity.l(this.n, this.t, this.u, view);
    }
}
