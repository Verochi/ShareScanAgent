package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class HomePageHotSpotView$mTopImageView$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<android.widget.ImageView> {
    final /* synthetic */ moji.com.mjweatherservicebase.card.HomePageHotSpotView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageHotSpotView$mTopImageView$2(moji.com.mjweatherservicebase.card.HomePageHotSpotView homePageHotSpotView) {
        super(0);
        this.this$0 = homePageHotSpotView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final android.widget.ImageView invoke() {
        return (android.widget.ImageView) this.this$0.getView().findViewById(moji.com.mjweatherservicebase.R.id.mTopImageView);
    }
}
