package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class bc0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newliveview.detail.FeedInfoAdapter n;
    public final /* synthetic */ com.moji.newliveview.detail.data.FeedInfoEntity t;

    public /* synthetic */ bc0(com.moji.newliveview.detail.FeedInfoAdapter feedInfoAdapter, com.moji.newliveview.detail.data.FeedInfoEntity feedInfoEntity) {
        this.n = feedInfoAdapter;
        this.t = feedInfoEntity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newliveview.detail.FeedInfoAdapter.m(this.n, this.t, view);
    }
}
