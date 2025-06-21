package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class h83 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.aggregation.VideoAggregationActivity n;

    public /* synthetic */ h83(com.moji.mjweather.feed.aggregation.VideoAggregationActivity videoAggregationActivity) {
        this.n = videoAggregationActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.aggregation.VideoAggregationActivity.f(this.n, (com.moji.http.fdsapi.entity.VideoAggregationResult) obj);
    }
}
