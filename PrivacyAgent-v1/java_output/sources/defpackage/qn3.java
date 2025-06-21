package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class qn3 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.zodiac.fragment.ZodiacBaseFragment n;
    public final /* synthetic */ int t;
    public final /* synthetic */ int u;

    public /* synthetic */ qn3(com.moji.zodiac.fragment.ZodiacBaseFragment zodiacBaseFragment, int i, int i2) {
        this.n = zodiacBaseFragment;
        this.t = i;
        this.u = i2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.zodiac.fragment.ZodiacBaseFragment.a(this.n, this.t, this.u, view);
    }
}
