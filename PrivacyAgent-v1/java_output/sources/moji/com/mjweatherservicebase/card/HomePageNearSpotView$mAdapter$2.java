package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lmoji/com/mjweatherservicebase/card/HomePageNearSpotAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class HomePageNearSpotView$mAdapter$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<moji.com.mjweatherservicebase.card.HomePageNearSpotAdapter> {
    final /* synthetic */ android.content.Context $context;
    final /* synthetic */ moji.com.mjweatherservicebase.card.HomePageNearSpotView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageNearSpotView$mAdapter$2(android.content.Context context, moji.com.mjweatherservicebase.card.HomePageNearSpotView homePageNearSpotView) {
        super(0);
        this.$context = context;
        this.this$0 = homePageNearSpotView;
    }

    @Override // kotlin.jvm.functions.Function0
    @org.jetbrains.annotations.NotNull
    public final moji.com.mjweatherservicebase.card.HomePageNearSpotAdapter invoke() {
        int i;
        double d;
        double d2;
        android.content.Context context = this.$context;
        i = this.this$0.mCityId;
        d = this.this$0.mLat;
        d2 = this.this$0.mLon;
        return new moji.com.mjweatherservicebase.card.HomePageNearSpotAdapter(context, i, d, d2);
    }
}
