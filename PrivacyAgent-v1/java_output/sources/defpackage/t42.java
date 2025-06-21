package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class t42 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.user.homepage.adapter.PraiseVideoListAdapter n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.http.feedvideo.entity.HomeFeed u;

    public /* synthetic */ t42(com.moji.user.homepage.adapter.PraiseVideoListAdapter praiseVideoListAdapter, int i, com.moji.http.feedvideo.entity.HomeFeed homeFeed) {
        this.n = praiseVideoListAdapter;
        this.t = i;
        this.u = homeFeed;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.user.homepage.adapter.PraiseVideoListAdapter.VideoItemVideoHolder.a(this.n, this.t, this.u, view);
    }
}
