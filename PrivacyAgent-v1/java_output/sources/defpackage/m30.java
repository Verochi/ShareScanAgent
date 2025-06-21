package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class m30 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.textview.MJTextView n;
    public final /* synthetic */ com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter t;

    public /* synthetic */ m30(com.moji.textview.MJTextView mJTextView, com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter discoverFeedListAdapter) {
        this.n = mJTextView;
        this.t = discoverFeedListAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview_finalversion.ui.discover.DiscoverFeedListAdapter.HeaderViewHolder.a(this.n, this.t, view);
    }
}
