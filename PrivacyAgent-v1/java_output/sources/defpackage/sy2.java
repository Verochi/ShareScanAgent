package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class sy2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.feed.event.FeedTitleIconVisibleEvent n;

    public /* synthetic */ sy2(com.moji.mjweather.feed.event.FeedTitleIconVisibleEvent feedTitleIconVisibleEvent) {
        this.n = feedTitleIconVisibleEvent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.TabWeatherV9Fragment.h(this.n, view);
    }
}
