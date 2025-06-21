package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class HomePageNearSpotView$mEmptyView$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<android.view.View> {
    final /* synthetic */ moji.com.mjweatherservicebase.card.HomePageNearSpotView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageNearSpotView$mEmptyView$2(moji.com.mjweatherservicebase.card.HomePageNearSpotView homePageNearSpotView) {
        super(0);
        this.this$0 = homePageNearSpotView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final android.view.View invoke() {
        return this.this$0.getView().findViewById(moji.com.mjweatherservicebase.R.id.mEmptyView);
    }
}
