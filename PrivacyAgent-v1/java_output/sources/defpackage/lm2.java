package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class lm2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.http.skywatchers.entity.SkyWatchersHomeResult n;
    public final /* synthetic */ com.moji.skywatchers.home.ui.SkyWatchersHomeHeaderPresenter t;

    public /* synthetic */ lm2(com.moji.http.skywatchers.entity.SkyWatchersHomeResult skyWatchersHomeResult, com.moji.skywatchers.home.ui.SkyWatchersHomeHeaderPresenter skyWatchersHomeHeaderPresenter) {
        this.n = skyWatchersHomeResult;
        this.t = skyWatchersHomeHeaderPresenter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.skywatchers.home.ui.SkyWatchersHomeHeaderPresenter.b(this.n, this.t, view);
    }
}
