package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class fa2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.snow.adapter.RankMoreHolder n;
    public final /* synthetic */ java.lang.String t;

    public /* synthetic */ fa2(com.moji.snow.adapter.RankMoreHolder rankMoreHolder, java.lang.String str) {
        this.n = rankMoreHolder;
        this.t = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.snow.adapter.RankMoreHolder.a(this.n, this.t, view);
    }
}
