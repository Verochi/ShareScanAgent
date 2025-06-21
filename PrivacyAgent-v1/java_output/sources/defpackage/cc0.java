package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class cc0 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.feed.databinding.FeedSubjectItemFeedBinding n;

    public /* synthetic */ cc0(com.moji.mjweather.feed.databinding.FeedSubjectItemFeedBinding feedSubjectItemFeedBinding) {
        this.n = feedSubjectItemFeedBinding;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.feed.subject.items.FeedItem.a(this.n);
    }
}
