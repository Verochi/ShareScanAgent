package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class dc0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.feed.subject.items.FeedItem n;
    public final /* synthetic */ com.moji.mjweather.feed.databinding.FeedSubjectItemFeedBinding t;

    public /* synthetic */ dc0(com.moji.mjweather.feed.subject.items.FeedItem feedItem, com.moji.mjweather.feed.databinding.FeedSubjectItemFeedBinding feedSubjectItemFeedBinding) {
        this.n = feedItem;
        this.t = feedSubjectItemFeedBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.feed.subject.items.FeedItem.b(this.n, this.t, view);
    }
}
