package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class rm2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.skywatchers.rank.SkyWatchersRankActivity n;

    public /* synthetic */ rm2(com.moji.skywatchers.rank.SkyWatchersRankActivity skyWatchersRankActivity) {
        this.n = skyWatchersRankActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.skywatchers.rank.SkyWatchersRankActivity.c(this.n, (com.moji.http.skywatchers.entity.SkyWatchersRankListResult) obj);
    }
}
