package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class s42 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.user.homepage.adapter.PraiseVideoListAdapter n;
    public final /* synthetic */ com.moji.user.databinding.ItemPraiseVideoBinding t;
    public final /* synthetic */ com.moji.http.feedvideo.entity.HomeFeed u;

    public /* synthetic */ s42(com.moji.user.homepage.adapter.PraiseVideoListAdapter praiseVideoListAdapter, com.moji.user.databinding.ItemPraiseVideoBinding itemPraiseVideoBinding, com.moji.http.feedvideo.entity.HomeFeed homeFeed) {
        this.n = praiseVideoListAdapter;
        this.t = itemPraiseVideoBinding;
        this.u = homeFeed;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.user.homepage.adapter.PraiseVideoListAdapter.VideoItemVideoHolder.b(this.n, this.t, this.u, view);
    }
}
