package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class hb0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.user.homepage.adapter.FeedCollectAdapter.FeedItemViewHolder n;
    public final /* synthetic */ com.moji.user.homepage.adapter.FeedCollectAdapter t;

    public /* synthetic */ hb0(com.moji.user.homepage.adapter.FeedCollectAdapter.FeedItemViewHolder feedItemViewHolder, com.moji.user.homepage.adapter.FeedCollectAdapter feedCollectAdapter) {
        this.n = feedItemViewHolder;
        this.t = feedCollectAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.user.homepage.adapter.FeedCollectAdapter.FeedItemViewHolder.a(this.n, this.t, view);
    }
}
