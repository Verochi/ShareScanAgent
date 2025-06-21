package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class e83 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.aggregation.VideoAggregationActivity n;

    public /* synthetic */ e83(com.moji.mjweather.feed.aggregation.VideoAggregationActivity videoAggregationActivity) {
        this.n = videoAggregationActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.aggregation.VideoAggregationActivity.b(this.n, (com.moji.mjweather.feed.aggregation.VideoAggregationPraiseData) obj);
    }
}
